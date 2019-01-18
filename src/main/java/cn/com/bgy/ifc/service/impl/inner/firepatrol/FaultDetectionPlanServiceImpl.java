package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.FaultDetectionPlanDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionPlanDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FaultDetectionPlan;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FaultDetectionPlanService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/14 11:17
 * @Description 消防设施设备故障检测计划
 **/
@Service
public class FaultDetectionPlanServiceImpl implements FaultDetectionPlanService {

    @Autowired
    private FaultDetectionPlanDomain faultDetectionPlanDomain;

    @Resource
    private FaultDetectionPlanDao faultDetectionPlanDao;

    /*
     * @Author huxin
     * @Description 添加
     * @Date 2019/1/14 11:24
     */
    @Override
    public int addFaultDetection( FaultDetectionPlan faultDetectionPlan ,Long equipmentId,Long recordContentId) {

        return faultDetectionPlanDomain.addFaultDetection(faultDetectionPlan,equipmentId,recordContentId);

    }
    /*
     * @Author huxin
     * @Description 修改
     * @Date 2019/1/14 11:24
     */
    @Override
    public int editFaultDetectionPlan( FaultDetectionPlan faultDetectionPlan ) {
        if(faultDetectionPlan.getId() != null && faultDetectionPlan.getId()>0){
            faultDetectionPlan.setCreateTime(new Date());
            return faultDetectionPlanDao.updateSelective(faultDetectionPlan);
        }
        return 0;
    }
    /*
     * @Author huxin
     * @Description 删除
     * @Date 2019/1/14 11:24
     */
    @Override
    public int deleteFaultDetectionPlan( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return faultDetectionPlanDomain.deleteFaultDetectionPlan(list);
        }
       return 0;
    }
    /*
     * @Author huxin
     * @Description 查询列表（含条件查询）
     * @Date 2019/1/14 11:24
     */
    @Override
    public PageInfo listFaultDetectionPlan( Page<Object> page, String keyword, FaultDetectionPlan faultDetectionPlan ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        map.put("planType",faultDetectionPlan.getPlanType());
        map.put("planStatus",faultDetectionPlan.getPlanStatus());
        map.put("type",faultDetectionPlan.getType());
        List<Map<String,Object>> list = faultDetectionPlanDao.listFaultDetectionPlan(map);
        return new PageInfo(list);
    }
    /*
     * @Author huxin
     * @Description 根据ID查询明细
     * @Date 2019/1/14 11:25
     */
    @Override
    public Map<String, Object> getFaultDetectionPlanByID( Long id ) {
        if(id != null && id>0){
            return (Map<String, Object>) faultDetectionPlanDao.findById(id);
        }
        return null;
    }
}
