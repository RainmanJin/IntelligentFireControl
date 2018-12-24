package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备品牌service
 **/

public interface EquipmentBrandService {

    PageInfo queryListEquipmentBrand( Page page,String keyword );

    int addEquipmentBrand( EquipmentBrand equipmentBrand );

    int updateEquipmentBrand( EquipmentBrand equipmentBrand );

    int deleteEquipmentBrand( String str );


    List<Map<String,Object>> queryAllEquipmentBrand();
}
