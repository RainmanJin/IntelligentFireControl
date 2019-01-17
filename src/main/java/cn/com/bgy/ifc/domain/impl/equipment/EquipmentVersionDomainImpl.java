package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentVersionDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentVersionDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVersionVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:设备型号
 * @date: 2018-12-21 17:57
 **/
@Service
public class EquipmentVersionDomainImpl implements EquipmentVersionDomain {

    private static Logger logger = LoggerFactory.getLogger(EquipmentVersionDomainImpl.class);

    @Resource
    private EquipmentVersionDao equipmentVersionDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/24 10:01
     */
    @Override
    public PageInfo queryListEquipmentVersion( Page page, Integer brandId, String keyword ) {
        Map<String,Object> map = new HashMap<>();
        map.put("brandId",brandId);
        map.put("keyword",keyword);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Map<String,Object>> list = equipmentVersionDao.queryListEquipmentVersion(map);
        return new PageInfo(list);
    }
    /*
     * @Author huxin
     * @Description 添加
     * @Date 2018/12/24 10:02
     */
    @Override
    public int addEquipmentVersion( EquipmentVersion record ) {
        record.setStatus(1);
        record.setLogicRemove(false);
        return equipmentVersionDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/24 10:02
     */
    @Override
    public int updateEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDao.updateSelective(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/24 10:02
     */
    @Override
    public int deleteEquipmentVersion( String str ) {
        List<Long> list = ListUtil.getListId(str);
        if(list.size()>0){
            return equipmentVersionDao.deleteEquipmentVersion(list);
        }
        return 0;

    }



    @Override
    public ResponseVO<Object> saveBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId) {
        try {
            List<EquipmentVersion> versionList = new ArrayList<>();
            for (BgyEquipmentVersionVo versionVo : list) {
                EquipmentVersion version = new EquipmentVersion();
                version.setId(versionVo.getId());
                version.setName(versionVo.getName());
                version.setBrandId(versionVo.getBrandId());
                version.setStatus(versionVo.getStatus());
                version.setDescription(versionVo.getDescription());
                version.setLogicRemove(false);
                versionList.add(version);
            }
            int totalCount = DbUtil.insertByList("equipment_version", versionList);
            if (totalCount != versionList.size()) {
                return ResponseVO.error().setMsg("同步集成平台设备型号异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_VERSION_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台设备型号总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台设备型号doMain异常:",e);
            return ResponseVO.error().setMsg("同步集成平台设备型号异常");
        }
    }


    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        for (BgyEquipmentVersionVo versionVo : list) {
            EquipmentVersion version = new EquipmentVersion();
            version.setId(versionVo.getId());
            version.setName(versionVo.getName());
            version.setBrandId(versionVo.getBrandId());
            version.setDescription(versionVo.getDescription());
            version.setStatus(versionVo.getStatus());
            version.setLogicRemove(false);
            int operType = versionVo.getOperType();
            //新增
            if (operType == addType) {
                int count = equipmentVersionDao.insertSelective(version);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = equipmentVersionDao.updateSelective(version);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                version.setLogicRemove(true);
                int count = equipmentVersionDao.updateSelective(version);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步设备型号增量数据失败!");
        } else {
            int msgType = ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_VERSION_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台设备型号增量总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }
}
