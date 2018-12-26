package cn.com.bgy.ifc.service.impl.inner.repair;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.repair.RepairOrderDao;
import cn.com.bgy.ifc.domain.interfaces.repair.RepairOrderDomain;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.repair.RepaicOrderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/26 11:50
 * @Description
 **/
@Service
public class RepaicOrderServiceImpl implements RepaicOrderService {

        @Resource
        private RepairOrderDao repairOrderDao;

        @Autowired
        private RepairOrderDomain repairOrderDomain;
    /*
     * @Author huxin
     * @Description 发起招修
     * @Date 2018/12/26 12:03
     */
    @Override
    public ResponseVO<Object> launchRepair( RepairOrder repairOrder ) {
        int count = repairOrderDomain.launchRepair(repairOrder);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author huxin
     * @Description 查询招修工单列表
     * @Date 2018/12/26 12:03
     */
    @Override
    public PageInfo queryListRepairOrder( Page<Object> page,RegionAndBrandVO regionAndBrandVO  ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Map<String,Object>> list  = repairOrderDao.queryListRepairOrder(regionAndBrandVO);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 给句订单ID查询详情
     * @Date 2018/12/26 12:03
     */
    @Override
    public Map<String, Object> queryRepairOrderById( Long id ) {
        if(id !=null || id>0){
            return repairOrderDao.queryRepairOrderById(id);
        }
        return null;
    }
    /**
     * @Author huxin
     * @Description 修改订单信息
     * @Date 2018/12/26 14:57
     */
    @Override
    public int updateRepairOrder( RepairOrder repairOrder ) {

        //根据id查询订单是否可以修改
       int count =  repairOrderDao.queryRepairOrderIsUpdate(repairOrder.getId());
       if(count>0){
           return repairOrderDao.updateRepairOrder(repairOrder);
       }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 删除订单信息（含批量）
     * @Date 2018/12/26 12:04
     */
    @Override
    public int deleteRepairOrder( String arr ) {
        List<Long> list = ListUtil.getListId(arr);
        if(list.size()>0){
            //批量查询根据ID查询订单是否可以删除，返回可以删除的id
            List<Long> newList = repairOrderDao.queryRepairOrderIsDelete(list);
            //返回ID都不符合
            if(newList.size()>0){
                return repairOrderDao.deleteRepairOrder(newList);
            }
            return  0;
        }
        return 0;
    }


}
