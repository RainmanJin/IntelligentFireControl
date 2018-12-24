package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备类型service
 **/

public interface EquipmentTypeService {

    PageInfo<Object> queryListEquipmentType(Page<Object> page);

    int addEquipmentType( EquipmentType equipmentType );

    int updateEquipmentType( EquipmentType equipmentType );

    int deleteEquipmentType( String str );


}