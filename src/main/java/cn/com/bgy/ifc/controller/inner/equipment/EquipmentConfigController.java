package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.entity.po.equipment.AnalogueUnit;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentConfigVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogueUnitService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentConfigService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
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
 * @description:中联永安物联接口设备配置
 * @date: 2019-01-10 14:09
 **/
@RestController
@RequestMapping("/equipment/config")
public class EquipmentConfigController {

    @Autowired
    private EquipmentConfigService equipmentConfigService;

    @Autowired
    private AnalogueUnitService analogueUnitService;

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    /**
     * @author: ZhangCheng
     * @description:分页查询设备配置信息
     * @param: [page, equipmentConfig]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo   <   cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentConfig>> searchPage(Page<EquipmentConfig> page, EquipmentConfig equipmentConfig) {
        PageInfo<EquipmentConfig> pageInfo = equipmentConfigService.queryListByPage(page, equipmentConfig);
        return ResponseVO.<PageInfo<EquipmentConfig>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:ID查询设备配置信息
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        EquipmentConfig equipmentConfig = equipmentConfigService.findById(id);
        return ResponseVO.success().setData(equipmentConfig);
    }

    /**
     * @author: ZhangCheng
     * @description:添加设备配置信息
     * @param: [equipmentConfigVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加设备配置信息")
    public ResponseVO<Object> add(@Validated EquipmentConfigVo equipmentConfigVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentConfig equipmentConfig = new EquipmentConfig();
        CopyUtil.copyProperties(equipmentConfigVo, equipmentConfig);
        return equipmentConfigService.createEquipmentConfig(equipmentConfig);
    }

    /**
     * @author: ZhangCheng
     * @description:修改设备配置信息
     * @param: [equipmentConfigVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改设备配置信息")
    public ResponseVO<Object> edit(@Validated EquipmentConfigVo equipmentConfigVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentConfig equipmentConfig = new EquipmentConfig();
        CopyUtil.copyProperties(equipmentConfigVo, equipmentConfig);
        return equipmentConfigService.editEquipmentConfig(equipmentConfig);
    }

    /**
     * @author: ZhangCheng
     * @description:同步设备配置信息列表
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
        return equipmentConfigService.synchroEquipmentConfig(1, 100);
    }

    /**
     * @author: ZhangCheng
     * @description:获取模拟量类型枚举
     * @param:
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getQuantityType")
    public ResponseVO<Object> getQuantityType() {
        List<SelectVo> list = EnumUtil.getSelectList(EquipmentConstant.AnalogQuantityType.class);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:获取模拟量单位
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getAnalogueUnit")
    public ResponseVO<Object> getAnalogueUnit() {
        List<AnalogueUnit> list = analogueUnitService.queryAllList();
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:获取设备类型
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getEquipmentType")
    public ResponseVO<Object> getEquipmentType() {
        List<EquipmentType> list = equipmentTypeService.queryAllList();
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:删除设备配置信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除设备配置信息")
    public ResponseVO<Object> deleteData(String ids) {
       if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        return equipmentConfigService.deleteEquipmentConfig(ids);
    }

}
