package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVo;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:设备信息
 * @date: 2018-12-22 16:41
 **/
@Service
public class EquipmentInfoDomainImpl implements EquipmentInfoDomain {

    private static Logger logger = LoggerFactory.getLogger(EquipmentInfoDomainImpl.class);

    @Resource
    private EquipmentInfoDao equipmentInfoDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;


    @Override
    public ResponseVO<Object> saveBgyEquipmentInfo(List<BgyEquipmentVo> list, Long orgId) {
        try {
            List<EquipmentInfo> infoList = new ArrayList<>();
            for (BgyEquipmentVo bgyEquipmentVo : list) {
                EquipmentInfo info = new EquipmentInfo();
                info.setId(bgyEquipmentVo.getId());
                info.setName(bgyEquipmentVo.getName());
                info.setInputCode(bgyEquipmentVo.getInputCode());
                info.setMachineRoomId(bgyEquipmentVo.getMachineRoomId());
                info.setVersionId(bgyEquipmentVo.getVersionId());
                info.setBrandId(bgyEquipmentVo.getBrandId());
                info.setTypeId(bgyEquipmentVo.getTypeId());
                info.setKeepYears(bgyEquipmentVo.getKeepYears());
                if (bgyEquipmentVo.getInWorkTime() != null) {
                    info.setInWorkTime(TimeUtil.parseStrToDate(bgyEquipmentVo.getInWorkTime()));
                }
                info.setImportant(bgyEquipmentVo.getIsImportant());
                info.setStatus(bgyEquipmentVo.getStatus());
                info.setLocaltionCode(bgyEquipmentVo.getLocaltionCode());
                info.setSimpleCode(bgyEquipmentVo.getSimpleCode());
                info.setApiCode(bgyEquipmentVo.getApiCode());
                info.setDescription(bgyEquipmentVo.getDescription());
                info.setLogicRemove(false);
                infoList.add(info);
            }
            int totalCount = DbUtil.insertByList("equipment_info", infoList);
            if (totalCount != infoList.size()) {
                return ResponseVO.error().setMsg("同步集成平台设备信息异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.GBY_EQUIPMENT_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台设备信息总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台设备信息doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台设备信息异常");
        }
    }

    @Override
    public ResponseVO<Object> alterBgyEquipmentInfo(List<BgyEquipmentVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        for (BgyEquipmentVo bgyEquipmentVo : list) {
            EquipmentInfo info = new EquipmentInfo();
            info.setId(bgyEquipmentVo.getId());
            info.setName(bgyEquipmentVo.getName());
            info.setInputCode(bgyEquipmentVo.getInputCode());
            info.setMachineRoomId(bgyEquipmentVo.getMachineRoomId());
            info.setVersionId(bgyEquipmentVo.getVersionId());
            info.setBrandId(bgyEquipmentVo.getBrandId());
            info.setTypeId(bgyEquipmentVo.getTypeId());
            info.setKeepYears(bgyEquipmentVo.getKeepYears());
            if (bgyEquipmentVo.getInWorkTime() != null) {
                info.setInWorkTime(TimeUtil.parseStrToDate(bgyEquipmentVo.getInWorkTime()));
            }
            info.setImportant(bgyEquipmentVo.getIsImportant());
            info.setStatus(bgyEquipmentVo.getStatus());
            info.setLocaltionCode(bgyEquipmentVo.getLocaltionCode());
            info.setSimpleCode(bgyEquipmentVo.getSimpleCode());
            info.setApiCode(bgyEquipmentVo.getApiCode());
            info.setDescription(bgyEquipmentVo.getDescription());
            info.setLogicRemove(false);
            int operType = bgyEquipmentVo.getOperType();
            //新增
            if (operType == addType) {
                int count = equipmentInfoDao.insertSelective(info);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = equipmentInfoDao.updateSelective(info);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                info.setLogicRemove(true);
                int count = equipmentInfoDao.updateSelective(info);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步设备信息增量数据失败!");
        } else {
            int msgType = ExternalConstant.MsgTypeValue.GBY_EQUIPMENT_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台设备信息增量总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }



    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 11:36
     */
    @Override
    public PageInfo queryListEquipmentInfo( Page<Object> page, RegionAndBrandVO regionAndBrandVO) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Map<String,Object>> list = equipmentInfoDao.queryListEquipmentInfo(regionAndBrandVO);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 11:36
     */
    @Override

    public int addEquipmentInfo( EquipmentInfo equipmentInfo ) {
        return equipmentInfoDao.insert(equipmentInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 11:36
     */
    @Override

    public int updateEquipmentInfo( EquipmentInfo equipmentInfo ) {
        return equipmentInfoDao.updateSelective(equipmentInfo);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 11:36
     */
    @Override

    public int deleteEquipmentInfo( String str ) {
        List<Long> list = ListUtil.getListId(str);
        return equipmentInfoDao.deleteEquipmentInfo(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询设备所有信息
     * @Date 2018/12/24 16:00
     */
    @Override
    public Map<String, Object> queryEquipmentInfoById( Long id ) {

        return equipmentInfoDao.queryEquipmentInfoById(id);
    }

	@Override
	public List<Map<String, Object>> queryAllInfo(RegionAndBrandVO vo) {
		// TODO Auto-generated method stub
		return equipmentInfoDao.queryListEquipmentInfo(vo);
	}


}
