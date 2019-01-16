package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-15 17:10
 **/
@RestController
@RequestMapping("/equipment/event")
public class EquipmentEventController {

    @Autowired
    private EquipmentEventService equipmentEventService;


    /**
     * @author: ZhangCheng
     * @description:
     * @param: [page, equipmentEventVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentEvent>> queryPage(Page<EquipmentEvent> page, EquipmentEventVo equipmentEventVo) {
        PageInfo<EquipmentEvent> pageInfo =equipmentEventService.queryListByPage(page, equipmentEventVo);
        return ResponseVO.<PageInfo<EquipmentEvent>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:模拟量数据同步
     * @param: `
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
        return equipmentEventService.synchroEquipmentEvent(1, 100);
    }

    /**
     * @author: ZhangCheng
     * @description:获取设备事件类型
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getEventType")
    public ResponseVO<Object> getEventType() {
        List<SelectVo> list = EnumUtil.getSelectList(EquipmentConstant.EventType.class);
        return ResponseVO.success().setData(list);
    }
}
