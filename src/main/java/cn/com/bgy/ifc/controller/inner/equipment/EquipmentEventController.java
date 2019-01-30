package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:事件管理
 * @date: 2019-01-15 17:10
 **/
@RestController
@RequestMapping("/equipment/event")
@RolePermission
public class EquipmentEventController extends BaseController {

    @Autowired
    private EquipmentEventService equipmentEventService;


    /**
     * @author: ZhangCheng
     * @description:事件信息分页查询
     * @param: [page, equipmentEventVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo   <   cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentEvent>> queryPage(Page<EquipmentEvent> page, EquipmentEventVo equipmentEventVo) {
        PageInfo<EquipmentEvent> pageInfo = equipmentEventService.queryListByPage(page, equipmentEventVo);
        return ResponseVO.<PageInfo<EquipmentEvent>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:事件信息ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        EquipmentEvent equipmentEvent = equipmentEventService.findById(id);
        return ResponseVO.success().setData(equipmentEvent);
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

    /**
     * @author: ZhangCheng
     * @description:添加事件信息
     * @param: [equipmentConfigVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加事件信息")
    public ResponseVO<Object> add(@Validated EquipmentEventVo equipmentEventVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentEvent equipmentEvent = new EquipmentEvent();
        CopyUtil.copyProperties(equipmentEventVo, equipmentEvent);
        return equipmentEventService.createEquipmentEvent(equipmentEvent);
    }

    /**
     * @author: ZhangCheng
     * @description:修改事件信息
     * @param: [equipmentConfigVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改事件信息")
    public ResponseVO<Object> edit(@Validated EquipmentEventVo equipmentEventVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentEvent equipmentEvent = new EquipmentEvent();
        CopyUtil.copyProperties(equipmentEventVo, equipmentEvent);
        return equipmentEventService.editEquipmentEvent(equipmentEvent);
    }

    /**
     * @author: ZhangCheng
     * @description:删除事件信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除事件信息")
    public ResponseVO<Object> deleteData(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        return equipmentEventService.deleteEquipmentEvent(ids);
    }
}
