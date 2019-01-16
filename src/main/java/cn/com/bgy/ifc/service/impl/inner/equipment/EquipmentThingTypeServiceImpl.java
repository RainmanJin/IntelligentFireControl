package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.dao.equipment.EquipmentThingTypeDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentThingType;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentThingTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-15 09:58
 **/
@Service
public class EquipmentThingTypeServiceImpl implements EquipmentThingTypeService {

    @Resource
    private EquipmentThingTypeDao equipmentThingTypeDao;

    @Override
    public List<EquipmentThingType> queryAllList() {
        return equipmentThingTypeDao.queryListByParam(new EquipmentThingType());
    }
}
