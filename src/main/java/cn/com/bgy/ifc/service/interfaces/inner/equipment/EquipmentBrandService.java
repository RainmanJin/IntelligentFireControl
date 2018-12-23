package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备品牌service
 **/

public interface EquipmentBrandService {

    void queryEquipmentBrand();

    int addEquipmentBrand( EquipmentBrand equipmentBrand );

    int updateEquipmentBrand( EquipmentBrand equipmentBrand );

    int deleteEquipmentBrand( String str );


}
