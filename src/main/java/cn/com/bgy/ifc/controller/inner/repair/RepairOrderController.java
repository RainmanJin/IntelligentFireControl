package cn.com.bgy.ifc.controller.inner.repair;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.repair.RepairOrderDomain;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.repair.RepairOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/26 10:31
 * @Description 招修订单Controller
 **/
@Controller
@RequestMapping("/repair/repairOrder")
@RolePermission
public class RepairOrderController extends BaseController {

    @Autowired
    private RepairOrderService repaicOrderService;
    @Autowired
    private RepairOrderDomain repairOrderDomain;

    /**
     * @Author huxin
     * @Description 发起设备招修
     * @Date 2018/12/26 10:35
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "发起招修，添加订单")
    @ResponseBody
    public ResponseVO<Object> launchRepair(RepairOrder repairOrder) {
        repairOrder.setCreateTime(new Date());
        repairOrder.setState(-1);
        repairOrder.setLogicRemove(false);
        repairOrder.setOrganizationId(this.getUser().getOrganizationId());
        repairOrder.setRepairTime(new Date());
        return repaicOrderService.launchRepair(repairOrder);
    }

    /**
     * @Author huxin
     * @Description 查询工单列表
     * @Date 2018/12/26 10:36
     */
    @GetMapping("queryPageData")
    @ResponseBody
    public ResponseVO<PageInfo> queryListRepairOrder(Page<Object> page, @RequestParam Map<String, Object> params) {
        PageInfo pageInfo = repaicOrderService.queryListRepairOrder(page, params);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }

    /**
     * @Author huxin
     * @Description 根据工单Id查询详细信息
     * @Date 2018/12/26 10:39
     */
    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<Object> findById(Long id) {
        Map<String, Object> query = repaicOrderService.queryRepairOrderById(id);
        return ResponseVO.<Object>success().setData(query);
    }

    /**
     * @Author huxin
     * @Description 修改工单信息
     * @Date 2018/12/26 14:54
     */
    @PostMapping("editData")
    @ResponseBody
    public ResponseVO<Object> updateRepairOrder(RepairOrder repairOrder) {
        RepairOrder query= repairOrderDomain.findById(repairOrder.getId());
        CopyUtil.copyProperties(repairOrder,query);
        if(query.getState()!=-1){
            ResponseVO.editError();
        }
        int count = repaicOrderService.updateRepairOrder(query);
        if (count > 0) {
            return ResponseVO.editSuccess();
        }
        return ResponseVO.editError();
    }

    /**
     * @Author huxin
     * @Description 删除工单信息（含批量）
     * @Date 2018/12/26 10:40
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "订单信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteRepairOrder(String ids) {
        int count = repaicOrderService.deleteRepairOrder(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
}
