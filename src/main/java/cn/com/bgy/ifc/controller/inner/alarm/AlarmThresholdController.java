package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentStateVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentStateService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:告警阀值
 * @date: 2019-01-23 21:59
 **/
@RestController
@RequestMapping("/alarm/threshold")
public class AlarmThresholdController {

    @Autowired
    private EquipmentStateService equipmentStateService;

    /**
     * @author: ZhangCheng
     * @description:分页查询设备告警阀值信息
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
     * @description:ID查询设备告警阀值信息
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
     * @description:修改物联设备告警阀值信息
     * @param: [equipmentState]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改物联设备告警阀值信息")
    public ResponseVO<Object> edit(EquipmentState equipmentState) {
        int result=equipmentStateService.updateSelective(equipmentState);
        if(result==1){
            return ResponseVO.editSuccess();
        }else{
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:批量修改设备告警阀值信息
     * @param: [list]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editDataList")
    @SystemLogAfterSave(description = "批量修改设备告警阀值信息")
    public ResponseVO<Object> editDataList(String list) {
        List<EquipmentState> newList=JSON.parseArray(list,EquipmentState.class);
        int result=equipmentStateService.updateStateList(newList);
        if(result==1){
            return ResponseVO.editSuccess();
        }else{
            return ResponseVO.editError();
        }
    }

}
