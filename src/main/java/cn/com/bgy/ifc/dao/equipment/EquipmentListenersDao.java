package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentListeners;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentListenersDao extends BaseDao<EquipmentListeners> {

    /**
     * 关键字查询
     * @param keyword
     * @return
     */
    List<EquipmentListeners> queryListByPage(@Param("keyword")String keyword);

}