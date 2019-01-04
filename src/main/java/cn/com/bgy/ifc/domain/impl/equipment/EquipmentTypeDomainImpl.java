package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentTypeDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentTypeDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentTypeVo;
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
 * @description:设备类型
 * @date: 2018-12-21 11:51
 **/
@Service
public class EquipmentTypeDomainImpl implements EquipmentTypeDomain {

    private static Logger logger = LoggerFactory.getLogger(EquipmentTypeDomainImpl.class);

    @Resource
    private EquipmentTypeDao equipmentTypeDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备类型
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> saveBgyEquipmentType(List<BgyEquipmentTypeVo> list, Long orgId) {
        try {
            List<EquipmentType> newList = new ArrayList<>();
            for (BgyEquipmentTypeVo equipmentTypeVo : list) {
                EquipmentType type = new EquipmentType();
                type.setId(equipmentTypeVo.getId());
                type.setName(equipmentTypeVo.getName());
                type.setParentId(equipmentTypeVo.getParentId());
                type.setStatus(equipmentTypeVo.getStatus());
                newList.add(type);
            }
            int totalCount = DBUtil.insertByList("equipment_type", newList);
            if (totalCount != newList.size()) {
                return ResponseVO.error().setMsg("同步集成平台设备类型异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_TYPE_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台设备类型总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台设备类型doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台设备类型异常");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备类型增量
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyEquipmentType(List<BgyEquipmentTypeVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int status = SystemConstant.StatusType.INVALID.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        for (BgyEquipmentTypeVo equipmentTypeVo : list) {
            EquipmentType type = new EquipmentType();
            type.setId(equipmentTypeVo.getId());
            type.setName(equipmentTypeVo.getName());
            type.setParentId(equipmentTypeVo.getParentId());
            type.setStatus(equipmentTypeVo.getStatus());
            int operType = equipmentTypeVo.getOperType();
            //新增
            if (operType == addType) {
                int count = equipmentTypeDao.insertSelective(type);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = equipmentTypeDao.updateSelective(type);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                type.setStatus(status);
                int count = equipmentTypeDao.updateSelective(type);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步设备类型增量数据失败!");
        } else {
            int msgType = ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_TYPE_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台设备类型增量总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }
    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/23 16:04
     */
    @Override
    public PageInfo queryListEquipmentType( Page page ,String keyword) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        List<Map<String,Object>> list = equipmentTypeDao.queryListEquipmentType(map);
        return new PageInfo(list);
    }

    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/23 16:03
     */
    @Override
    public int addEquipmentType( EquipmentType equipmentType ) {
        return equipmentTypeDao.addEquipmentType(equipmentType);
    }
    /*
     * @Author huxin
     * @Description 改
     * @Date 2018/12/23 16:04
     */
    @Override

    public int updateEquipmentType( EquipmentType equipmentType ) {
        return equipmentTypeDao.updateSelective(equipmentType);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/23 16:04
     */
    @Override
    public int deleteEquipmentType( String str ) {
        List<Long> list  = ListUtil.getListId(str);
        return equipmentTypeDao.deleteEquipmentType(list);
    }
    /**
     * @Author huxin
     * @Description 根据父级id查询所有子节点
     * @Date 2018/12/24 16:38
     */
    @Override
    public List<Map<String, Object>> queryEquipmentTypeBySuperId( Long id ) {
        if(id==null|| id==77L){
            id=77L;
        }
        return equipmentTypeDao.queryEquipmentTypeBySuperId(id);
    }

	@Override
	public List<EquipmentType> queryAll() {
		return equipmentTypeDao.queryListByParam(null);
	}
}
