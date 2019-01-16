package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentThingType;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentThingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:中联永安物联网设备编码
 * @date: 2019-01-15 09:58
 **/
@RestController
@RequestMapping("/equipment/thingtype")
public class EquipmentThingTypeController {

    @Autowired
    private EquipmentThingTypeService equipmentThingTypeService;

    /**
     * @author: ZhangCheng
     * @description:获取所有设备编码
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("queryAllList")
    public ResponseVO<Object> getQuantityType() {
        List<EquipmentThingType> list = equipmentThingTypeService.queryAllList();
        return ResponseVO.success().setData(list);
    }
}
