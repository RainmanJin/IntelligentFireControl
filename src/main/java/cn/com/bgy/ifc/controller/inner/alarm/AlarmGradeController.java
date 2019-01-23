package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentStateVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:告警等级
 * @date: 2019-01-23 20:54
 **/
@RestController
@RequestMapping("/alarm/grade")
public class AlarmGradeController {

    @Autowired
    private EquipmentStateService equipmentStateService;

    /**
     * @author: ZhangCheng
     * @description:修改物联设备等级信息
     * @param: [equipmentState]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改物联设备等级信息")
    public ResponseVO<Object> edit(EquipmentState equipmentState) {
        if(equipmentState.getGrade()==null){
            return ResponseVO.error().setMsg("告警等级不能为空！");
        }
        int result=equipmentStateService.updateSelective(equipmentState);
        if(result==1){
            return ResponseVO.editSuccess();
        }else{
            return ResponseVO.editError();
        }
    }
}
