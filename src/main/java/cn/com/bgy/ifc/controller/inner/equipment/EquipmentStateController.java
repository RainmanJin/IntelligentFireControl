package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentConfigVo;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentStateVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentStateService;
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
 * @description:中联永安物联接口设备状态
 * @date: 2019-01-10 14:10
 **/
@RestController
@RequestMapping("/equipment/state")
public class EquipmentStateController {

    @Autowired
    private EquipmentStateService equipmentStateService;

    /**
     * @author: ZhangCheng
     * @description:分页查询设备状态信息
     * @param: [page, equipmentState]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.equipment.EquipmentState>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentState>> queryPageData(Page<EquipmentState> page, EquipmentStateVo equipmentStateVo) {
        PageInfo<EquipmentState> pageInfo = equipmentStateService.queryListByPage(page, equipmentStateVo);
        return ResponseVO.<PageInfo<EquipmentState>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:ID查询设备状态信息
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        EquipmentState equipmentState = equipmentStateService.findById(id);
        return ResponseVO.success().setData(equipmentState);
    }

    /**
     * @author: ZhangCheng
     * @description:添加物联设备信息
     * @param: [equipmentStateVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加物联设备信息")
    public ResponseVO<Object> add(@Validated EquipmentStateVo equipmentStateVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentState equipmentState = new EquipmentState();
        CopyUtil.copyProperties(equipmentStateVo, equipmentState);
        return equipmentStateService.createEquipmentState(equipmentState);
    }

    /**
     * @author: ZhangCheng
     * @description:修改物联设备信息
     * @param: [equipmentStateVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改物联设备信息")
    public ResponseVO<Object> edit(@Validated EquipmentStateVo equipmentStateVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentState equipmentState = new EquipmentState();
        CopyUtil.copyProperties(equipmentStateVo, equipmentState);
        return equipmentStateService.editEquipmentState(equipmentState);
    }

    /**
     * @author: ZhangCheng
     * @description:同步设备状态信息列表
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData(){
        return equipmentStateService.synchroEquipmentState(1,300);
    }

    /**
     * @author: ZhangCheng
     * @description:获取设备状态枚举
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getStateEnum")
    public ResponseVO<Object> getStateEnum() {
        List<SelectVo> list = EnumUtil.getSelectList(EquipmentConstant.StateEnum.class);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:设备状态信息查询所有
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("queryAllList")
    public ResponseVO<Object> queryAllList() {
        List<EquipmentState> list = equipmentStateService.queryAllList();
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:删除设备状态信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除设备状态信息")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        return equipmentStateService.deleteEquipmentState(ids);
    }

}
