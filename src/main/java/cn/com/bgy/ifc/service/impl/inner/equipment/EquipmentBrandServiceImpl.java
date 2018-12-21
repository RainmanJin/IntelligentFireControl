package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentBrandDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息serviceImpl
 **/
@Service
public class EquipmentBrandServiceImpl implements EquipmentBrandService {

    @Autowired
    private EquipmentBrandDomain equipmentBrandDomain;

    /**
     * @Author huxin
     * @Description 差
     * @Date 2018/12/21 11:30
     */
    @Override
    public void queryEquipmentBrand() {

    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 11:30
     */
    @Override
    public int addEquipmentBrand( EquipmentBrand equipmentBrand ) {
        return equipmentBrandDomain.addEquipmentBrand(equipmentBrand);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 11:31
     */
    @Override
    public int updateEquipmentBrand( EquipmentBrand equipmentBrand ) {
        return equipmentBrandDomain.updateEquipmentBrand(equipmentBrand);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 11:36
     */
    @Override
    public int deleteEquipmentBrand( String str ) {
        return equipmentBrandDomain.deleteEquipmentBrand(str);
    }
}
