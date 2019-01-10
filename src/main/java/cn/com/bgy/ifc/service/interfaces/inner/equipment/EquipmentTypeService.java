package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备类型service
 **/

public interface EquipmentTypeService {

    PageInfo<Object> queryListEquipmentType(Page page, String keyword);

    int addEquipmentType(EquipmentType equipmentType);

    int updateEquipmentType(EquipmentType equipmentType);

    int deleteEquipmentType(String str);

    List<Map<String, Object>> queryEquipmentTypeBySuperId(Long id);

    Map<String, Object> findById(Long id);

    List<Map<String, Object>> queryAllEquipmentType();

    List<EquipmentType>  queryAllList();
}
