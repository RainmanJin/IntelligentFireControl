package cn.com.bgy.ifc.controller.inner.repair;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.repair.RepaicOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/26 10:31
 * @Description 招修订单Controller
 **/
@Controller
@RequestMapping("/basic/Repair")
public class RepaicOrderController extends BaseController {

    @Autowired
    private RepaicOrderService repaicOrderService;

    /**
     * @Author huxin
     * @Description 发起设备招修
     * @Date 2018/12/26 10:35
     */
    @PostMapping("launchRepair")
    @SystemLogAfterSave(type = 1,description = "发起招修，添加订单")
    @ResponseBody
    public ResponseVO<Object> launchRepair(RepairOrder repairOrder ){
        return repaicOrderService.launchRepair(repairOrder);
    }
    /**
     * @Author huxin
     * @Description 查询工单列表
     * @Date 2018/12/26 10:36
     */
    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListRepairOrder( Page<Object> page,RegionAndBrandVO regionAndBrandVO ){
        PageInfo pageInfo = repaicOrderService.queryListRepairOrder(page,regionAndBrandVO);
        return   ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据工单Id查询详细信息
     * @Date 2018/12/26 10:39
     */
    @PostMapping("queryInfo")
    @ResponseBody
    public ResponseVO<Object> queryRepairOrderById(Long id){
        Map<String,Object> map = repaicOrderService.queryRepairOrderById(id);
        return ResponseVO.<Object>success().setData(map);
    }
    /**
     * @Author huxin
     * @Description 修改工单信息
     * @Date 2018/12/26 14:54
     */
    @PostMapping("update")
    @ResponseBody
    public ResponseVO<Object> updateRepairOrder(RepairOrder repairOrder){
        int count = repaicOrderService.updateRepairOrder(repairOrder);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author huxin
     * @Description 删除工单信息（含批量）
     * @Date 2018/12/26 10:40
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "订单信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteRepairOrder(String ids){
        int count = repaicOrderService.deleteRepairOrder(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
}
