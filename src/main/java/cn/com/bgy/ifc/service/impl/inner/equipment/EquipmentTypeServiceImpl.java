package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentTypeDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备类型
 **/
@Service
public class EquipmentTypeServiceImpl implements EquipmentTypeService {

    @Autowired
    private EquipmentTypeDomain equipmentTypeDomain;
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/23 17:16
     */
    @Override
    public PageInfo queryListEquipmentType( Page page,String keyword) {

        return equipmentTypeDomain.queryListEquipmentType(page,keyword);

    }
    /**
     * @Author huxin
     * @Description 增加
     * @Date 2018/12/23 17:16
     */
    @Override
    public int addEquipmentType( EquipmentType record ) {
        return equipmentTypeDomain.addEquipmentType(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/23 17:16
     */
    @Override
    public int updateEquipmentType( EquipmentType record ) {
        return equipmentTypeDomain.updateEquipmentType(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/23 17:16
     */
    @Override
    public int deleteEquipmentType( String str ) {
        return equipmentTypeDomain.deleteEquipmentType(str);
    }

    @Override
    public List<Map<String, Object>> queryEquipmentTypeBySuperId( Long id ) {
        return equipmentTypeDomain.queryEquipmentTypeBySuperId(id);
    }

}
