package cn.com.bgy.ifc.controller.inner.fireinspection;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskDrill;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskDrillVo;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskTrainVo;
import cn.com.bgy.ifc.service.interfaces.inner.fireinspection.FireTaskDrillService;
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
 * @description:消防演练任务
 * @date: 2019-01-04 12:04
 **/
@RestController
@RequestMapping("/fireInspection/fireTaskDrill")
@RolePermission
public class FireTaskDrillController extends BaseController {

    @Autowired
    private FireTaskDrillService fireTaskDrillService;

    /**
     * @author: ZhangCheng
     * @description:消防演练任务分页查询
     * @param: [page, fireTaskDrillVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.fireinspection.FireTaskDrill>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<FireTaskDrill>> searchPage(Page<FireTaskDrill> page, FireTaskDrillVo fireTaskDrillVo) {
        PageInfo<FireTaskDrill> pageInfo = fireTaskDrillService.queryListByPage(page, fireTaskDrillVo);
        return ResponseVO.<PageInfo<FireTaskDrill>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:消防演练任务ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        FireTaskDrill fireTaskDrill = fireTaskDrillService.findById(id);
        return ResponseVO.success().setData(fireTaskDrill);
    }

    /**
     * @author: ZhangCheng
     * @description:添加消防演练任务
     * @param: [fireTaskDrillVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave( description = "添加消防演练任务")
    public ResponseVO<Object> add(@Validated FireTaskDrillVo fireTaskDrillVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        FireTaskDrill fireTaskDrill = new FireTaskDrill();
        CopyUtil.copyProperties(fireTaskDrillVo, fireTaskDrill);
        int result = fireTaskDrillService.insertSelective(fireTaskDrill);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:修改消防演练任务
     * @param: [fireTaskDrillVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改消防演练任务")
    public ResponseVO<Object> edit(@Validated FireTaskDrillVo fireTaskDrillVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        FireTaskDrill fireTaskDrill = new FireTaskDrill();
        CopyUtil.copyProperties(fireTaskDrillVo, fireTaskDrill);
        int result = fireTaskDrillService.updateSelective(fireTaskDrill);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:删除消防演练任务
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除消防演练任务")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = fireTaskDrillService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:培训演练任务周期
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getFirePlanCycle")
    public ResponseVO<Object> getFirePlanCycle() {
        List<SelectVo> list = EnumUtil.getSelectList(SystemConstant.FirePlanCycle.class);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:培训演练工作状态
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getCompleteType")
    public ResponseVO<Object> getCompleteType() {
        List<SelectVo> list = EnumUtil.getSelectList(SystemConstant.CompleteType.class);
        return ResponseVO.success().setData(list);
    }
}
