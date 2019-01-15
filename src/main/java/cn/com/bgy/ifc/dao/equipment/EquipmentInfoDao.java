package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;

import java.util.List;
import java.util.Map;

public interface EquipmentInfoDao extends BaseDao<EquipmentInfo> {

	
    List<Map<String,Object>> queryListEquipmentInfo(RegionAndBrandVO regionAndBrandVO);

    int updateEquipmentInfo( EquipmentInfo equipmentInfo);

    int deleteEquipmentInfo(List<Long> list);

    Map<String,Object> queryEquipmentInfoById(Long id);

    //根据设备ID查询机房ID
    Long queryRoomIdByEquipmentId(Long id);
    //根据苑区ID查询设备信息下拉列表
    List<EquipmentInfo> ListByCourtId( Map<String,Object> map );
}