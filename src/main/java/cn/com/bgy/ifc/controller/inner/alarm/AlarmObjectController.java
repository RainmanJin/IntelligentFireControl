package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.alarm.AlarmObject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmObjectVo;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmObjectService;
import cn.com.bgy.ifc.service.interfaces.inner.system.AccountService;
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
 * @description:告警对象
 * @date: 2019-01-19 17:19
 **/
@RestController
@RequestMapping("/alarm/object")
@RolePermission
public class AlarmObjectController extends BaseController {

    @Autowired
    private AlarmObjectService alarmObjectService;

    @Autowired
    private AccountService accountService;

    /**
     * @author: ZhangCheng
     * @description:告警对象分页查询
     * @param: [page, alarmObject]
     * @return:
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<AlarmObject>> queryPageData(Page<AlarmObject> page, AlarmObjectVo alarmObjectVo) {
        PageInfo<AlarmObject> pageInfo = alarmObjectService.queryListByPage(page, alarmObjectVo);
        return ResponseVO.<PageInfo<AlarmObject>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:告警对象ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        AlarmObject alarmObject = alarmObjectService.findById(id);
        return ResponseVO.success().setData(alarmObject);
    }

    /**
     * @author: ZhangCheng
     * @description:添加告警对象信息
     * @param: [alarmObjectVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加告警对象信息")
    public ResponseVO<Object> createData(@Validated AlarmObjectVo alarmObjectVo, BindingResult error) {
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        AlarmObject alarmObject = new AlarmObject();
        CopyUtil.copyProperties(alarmObjectVo, alarmObject);
        int result = alarmObjectService.insertSelective(alarmObject);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:修改告警对象信息
     * @param: [alarmObjectVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改告警对象信息")
    public ResponseVO<Object> editData(@Validated AlarmObjectVo alarmObjectVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        AlarmObject alarmObject = new AlarmObject();
        CopyUtil.copyProperties(alarmObjectVo, alarmObject);
        int result = alarmObjectService.updateSelective(alarmObject);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:告警对象启用操作
     * @param: [id, state]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("forbidden")
    @SystemLogAfterSave(description = "告警对象启用操作")
    public ResponseVO<Object> forbidden(Long id,Integer state) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.setId(id);
        alarmObject.setState(state);
        int result = alarmObjectService.updateSelective(alarmObject);
        if (result == 1) {
            return ResponseVO.success().setMsg("操作成功");
        }
        return ResponseVO.error().setMsg("操作失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:删除告警对象信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除告警对象信息")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = alarmObjectService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:获取通知人
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getNotifier")
    public ResponseVO<Object> getNotifier() {
        Long orgId = this.getUser().getOrganizationId();
        List<SelectVo> list = accountService.queryListByRole("",orgId);
        return ResponseVO.success().setData(list);
    }
}
