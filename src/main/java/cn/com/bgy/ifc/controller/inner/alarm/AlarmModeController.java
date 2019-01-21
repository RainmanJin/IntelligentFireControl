package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.entity.po.alarm.AlarmMode;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmModeVo;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmModeService;
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
 * @description:告警方式
 * @date: 2019-01-21 12:01
 **/
@RestController
@RequestMapping("/alarm/mode")
public class AlarmModeController {

    @Autowired
    private AlarmModeService alarmModeService;

    /**
     * @author: ZhangCheng
     * @description:分页查询
     * @param: [page, alarmMode]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.alarm.AlarmMode>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<AlarmMode>> queryPageData(Page<AlarmMode> page,AlarmMode alarmMode) {
        PageInfo<AlarmMode> pageInfo = alarmModeService.queryListByPage(page, alarmMode);
        return ResponseVO.<PageInfo<AlarmMode>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        AlarmMode alarmMode = alarmModeService.findById(id);
        return ResponseVO.success().setData(alarmMode);
    }

    /**
     * @author: ZhangCheng
     * @description:添加告警方式信息
     * @param: [alarmModeVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加告警方式信息")
    public ResponseVO<Object> createData(@Validated AlarmModeVo alarmModeVo, BindingResult error) {
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        AlarmMode alarmMode = new AlarmMode();
        CopyUtil.copyProperties(alarmModeVo, alarmMode);
        int result = alarmModeService.insertSelective(alarmMode);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

   /**
    * @author: ZhangCheng
    * @description:修改告警方式信息
    * @param: [alarmModeVo, error]
    * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
    */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改告警方式信息")
    public ResponseVO<Object> editData(@Validated AlarmModeVo alarmModeVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        AlarmMode alarmMode = new AlarmMode();
        CopyUtil.copyProperties(alarmModeVo, alarmMode);
        int result = alarmModeService.updateSelective(alarmMode);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:告警方式启用操作
     * @param: [id, state]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("forbidden")
    @SystemLogAfterSave(description = "告警方式启用操作")
    public ResponseVO<Object> forbidden(Long id,Integer state) {
        AlarmMode alarmMode = new AlarmMode();
        alarmMode.setId(id);
        alarmMode.setState(state);
        int result = alarmModeService.updateSelective(alarmMode);
        if (result == 1) {
            return ResponseVO.success().setMsg("操作成功");
        }
        return ResponseVO.error().setMsg("操作失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:获取告警方式类型
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getAlarmModeType")
    public ResponseVO<Object> getAlarmModeType() {
        List<SelectVo> list = EnumUtil.getSelectList(EquipmentConstant.AlarmModeType.class);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:获取告警方式
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getAlarmModeList")
    public ResponseVO<Object> getAlarmModeList() {
        List<AlarmMode> list=alarmModeService.queryAllList();
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:删除告警对象信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除告警方式信息")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = alarmModeService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }
}
