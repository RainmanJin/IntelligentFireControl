package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentChange;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentChangeService;
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
 * @description:状态变化
 * @date: 2019-01-16 17:33
 **/
@RestController
@RequestMapping("/equipment/change")
public class EquipmentChangeController {

    @Autowired
    private EquipmentChangeService equipmentChangeService;

    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentChange>> queryPage(Page<EquipmentEvent> page, EquipmentChange equipmentChange) {
        PageInfo<EquipmentChange> pageInfo = equipmentChangeService.queryListByPage(page, equipmentChange);
        return ResponseVO.<PageInfo<EquipmentChange>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:设备状态变化同步
     * @param: `
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
        return equipmentChangeService.synchroEquipmentChange(1, 1000);
    }

    /**
     * @author: ZhangCheng
     * @description:状态记录类型
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getStatusRecordType")
    public ResponseVO<Object> getStatusRecordType(){
        List<SelectVo> list = EnumUtil.getSelectList(EquipmentConstant.StatusRecordType.class);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:删除设备状态变化
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除设备状态变化")
    public ResponseVO<Object> deleteData(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        return equipmentChangeService.deleteEquipmentChange(ids);
    }
}
