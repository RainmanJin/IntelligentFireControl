package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.firepatrol.FaultDetectionPlanDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordByContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordTableDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionPlanDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FaultDetectionPlan;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordByContent;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author huxin
 * @Date 2019/1/16 9:38
 * @Description
 **/
@Service
public class FaultDetectionPlanDomainImpl implements FaultDetectionPlanDomain {

    @Resource
    private FaultDetectionPlanDao faultDetectionPlanDao;
    @Resource
    private RecordTableDao recordTableDao;
    @Resource
    private RecordByContentDao recordByContentDao;

    /*
     * @Author  huxin
     * @Description 添加设施设备故障检测计划
     * @param   [faultDetectionPlan, equipmentId, recordContentId]
     * @retrue  int
     * @Date 2019/1/16 11:29
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int addFaultDetection( FaultDetectionPlan faultDetectionPlan,Long equipmentId,Long recordContentId) {
        Date time = new Date();
        RecordTable recordTable = new RecordTable();
        //3代表设施巡检类型
        recordTable.setEquipmentId(equipmentId);
        if(faultDetectionPlan.getType()==2) {
            recordTable.setType(4);
        }else if(faultDetectionPlan.getType()==1) {
            recordTable.setType(3);
        }
        recordTable.setLogicRemove(false);
        recordTable.setCreateTime(time);
        //添加设施故障检测记录
        recordTableDao.insertSelective(recordTable);
        if(recordTable.getId()!=null && recordTable.getId()>0){
            faultDetectionPlan.setCreateTime(time);
            faultDetectionPlan.setLogicRemove(false);
            faultDetectionPlan.setRecordId(recordTable.getId());
            //添加计划信息
            int count = faultDetectionPlanDao.insertSelective(faultDetectionPlan);
            if(count==1){
                RecordByContent recordByContent = new RecordByContent();
                recordByContent.setRecordId(recordTable.getId());
                recordByContent.setContentId(recordContentId);
                //添加记录关联记录内容表数据
                recordByContentDao.insertSelective(recordByContent);
                return count;
            }
        }
        return 0;
    }
    /*
     * @Author  huxin
     * @Description 删除故障检测计划
     * @param   [list]
     * @retrue  int
     * @Date 2019/1/16 11:48
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int deleteFaultDetectionPlan( List<Long> list ) {
        //根据故障检测计划ID获取相关数据
        List<FaultDetectionPlan> plan = faultDetectionPlanDao.getListRecordIdFindById(list);
        List<Long> newList = new ArrayList<>();
        for (int i = 0; i <plan.size() ; i++) {
            //得到故障检测记录ID
            newList.add(plan.get(i).getRecordId());
        }
        //删除故障检测记录
        recordTableDao.deleteBatch(newList);
        //删除故障检测计划
        return faultDetectionPlanDao.deleteBatch(list);
    }
}
