package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentConfigVo;
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
    public ResponseVO<PageInfo<EquipmentState>> searchPage(Page<EquipmentState> page, EquipmentState equipmentState) {
        PageInfo<EquipmentState> pageInfo = equipmentStateService.queryListByPage(page, equipmentState);
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
        List<SelectVo> list = EnumUtil.getSelectList(EquipmentConstant.stateEnum.class);
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
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = equipmentStateService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }


}
