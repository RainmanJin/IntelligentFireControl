package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/

public interface EquipmentVersionService  {


    PageInfo queryListEquipmentVersion( Page page, Integer brandID, String keyword);

    int addEquipmentVersion(EquipmentVersion record);

    int updateEquipmentVersion(EquipmentVersion record);

    int deleteEquipmentVersion( String str );

}
