package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentStateService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-10 19:27
 **/
@Service
public class EquipmentStateServiceImpl implements EquipmentStateService {

    @Override
    public EquipmentState findById(Long id) {
        return null;
    }

    @Override
    public int insert(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int insertSelective(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int update(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int updateSelective(EquipmentState equipmentState) {
        return 0;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return 0;
    }
}
