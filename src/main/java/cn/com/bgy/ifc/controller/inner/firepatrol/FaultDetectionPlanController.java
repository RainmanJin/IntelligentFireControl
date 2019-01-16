package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.FaultDetectionPlan;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FaultDetectionPlanService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/14 11:14
 * @Description 消防设施故障检测计划
 **/
@RestController
@RequestMapping("/firepatrol/faultDetectionPlan")
public class FaultDetectionPlanController extends BaseController {

    @Autowired
    private FaultDetectionPlanService faultDetectionPlanService;

    /**
     * @Author huxin
     * @Description 添加设施故障检测计划
     * @Date 2019/1/12 10:57
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "消防设施故障检测计划列表添加")
    public ResponseVO<Object> addFaultDetectionPlan( FaultDetectionPlan faultDetectionPlan,Long equipmentId,Long recordContentId){
        int count = faultDetectionPlanService.addFaultDetection(faultDetectionPlan,equipmentId,recordContentId);
        if(count==1){
            return ResponseVO.<Object>addSuccess();
        }
        return ResponseVO.<Object>addError();
    }
    /**
     * @Author huxin
     * @Description 修改设施故障检测计划
     * @Date 2019/1/12 10:57
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "消防设施故障检测计划列表修改")
    public ResponseVO<Object> editFaultDetectionPlan(FaultDetectionPlan faultDetectionPlan){
        int count = faultDetectionPlanService.editFaultDetectionPlan(faultDetectionPlan);
        if(count==1){
            return ResponseVO.<Object>editSuccess();
        }
        return ResponseVO.<Object>editError();

    }
    /**
     * @Author huxin
     * @Description 删除设置故障检测计划
     * @Date 2019/1/12 11:00
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "消防设施故障检测计划列表删除")
    public ResponseVO<Object> deleteFaultDetectionPlan(String ids){
        int count = faultDetectionPlanService.deleteFaultDetectionPlan(ids);
        if(count>=1){
            return ResponseVO.<Object>deleteSuccess();
        }
        return ResponseVO.<Object>deleteError();

    }
    /**
     * @Author huxin
     * @Description 查询设施故障计划列表
     * @Date 2019/1/12 10:58
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> listFaultDetectionPlan( Page<Object> page,String keyword,FaultDetectionPlan faultDetectionPlan){
        PageInfo pageInfo = faultDetectionPlanService.listFaultDetectionPlan(page,keyword,faultDetectionPlan);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询设施故障计划明细
     * @Date 2019/1/12 11:02
     */
    @GetMapping("find")
    public ResponseVO<Object> getFaultDetectionPlanByID( Long id){
        Map<String,Object> map = faultDetectionPlanService.getFaultDetectionPlanByID(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
