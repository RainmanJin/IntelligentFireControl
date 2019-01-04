package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息service
 **/

public interface EquipmentInfoService {

    PageInfo queryListEquipmentInfo( Page<Object> page,RegionAndBrandVO regionAndBrandVO );

    int addEquipmentInfo( EquipmentInfo equipmentInfo );

    int updateEquipmentInfo(EquipmentInfo equipmentInfo);

    int deleteEquipmentInfo(String str);

    Map<String,Object> queryEquipmentInfoById( Long id );
}
