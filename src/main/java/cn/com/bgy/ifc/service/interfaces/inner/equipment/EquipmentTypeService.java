package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.po.system.SystemPower;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentTypeVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备类型service
 **/

public interface EquipmentTypeService  extends  BaseService<EquipmentType> {

    PageInfo<EquipmentTypeVo> queryListByPage(Page<EquipmentType> page, EquipmentTypeVo equipmentTypeVo);

    PageInfo<Object> queryListEquipmentType(Page page, String keyword);

    List<Map<String, Object>> queryEquipmentTypeBySuperId(Long id);

    List<EquipmentType> queryAllEquipmentType();

    List<EquipmentType>  queryAllList();
}
