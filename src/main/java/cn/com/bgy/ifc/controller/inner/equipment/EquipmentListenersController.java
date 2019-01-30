package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentListeners;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentListenersVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentListenersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:设备事件监听管理
 * @date: 2019-01-16 14:01
 **/
@RestController
@RequestMapping("/equipment/listeners")
@RolePermission
public class EquipmentListenersController {

    @Autowired
    private EquipmentListenersService equipmentListenersService;

    /**
     * @author: ZhangCheng
     * @description:事件监听分页查询
     * @param: [page, keyword]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo < cn.com.bgy.ifc.entity.po.equipment.EquipmentListeners>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentListeners>> queryPage(Page<EquipmentListeners> page, String keyword) {
        PageInfo<EquipmentListeners> pageInfo = equipmentListenersService.queryListByPage(page, keyword);
        return ResponseVO.<PageInfo<EquipmentListeners>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:事件监听ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        EquipmentListeners equipmentListeners = equipmentListenersService.findById(id);
        return ResponseVO.success().setData(equipmentListeners);
    }

    /**
     * @author: ZhangCheng
     * @description:事件监听数据同步
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
        return equipmentListenersService.synchroEquipmentListeners(1, 100);
    }

    /**
     * @author: ZhangCheng
     * @description:添加事件监听信息
     * @param: [equipmentConfigVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加事件监听信息")
    public ResponseVO<Object> add(@Validated EquipmentListenersVo equipmentListenersVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentListeners equipmentListeners = new EquipmentListeners();
        CopyUtil.copyProperties(equipmentListenersVo, equipmentListeners);
        return equipmentListenersService.createEquipmentListeners(equipmentListeners);
    }

    /**
     * @author: ZhangCheng
     * @description:修改事件监听信息
     * @param: [equipmentConfigVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改事件监听信息")
    public ResponseVO<Object> edit(@Validated EquipmentListenersVo equipmentListenersVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentListeners equipmentListeners = new EquipmentListeners();
        CopyUtil.copyProperties(equipmentListenersVo, equipmentListeners);
        return equipmentListenersService.editEquipmentListeners(equipmentListeners);
    }

    /**
     * @author: ZhangCheng
     * @description:删除事件监听信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除事件监听信息")
    public ResponseVO<Object> deleteData(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        return equipmentListenersService.deleteEquipmentListeners(ids);
    }
}
