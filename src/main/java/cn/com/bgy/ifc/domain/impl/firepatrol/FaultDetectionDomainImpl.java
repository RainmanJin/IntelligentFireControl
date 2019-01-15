package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordByContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordTableDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordByContent;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordContent;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/12 18:20
 * @Description
 **/
@Service
public class FaultDetectionDomainImpl implements FaultDetectionDomain {

    @Resource
    private RecordTableDao recordTableDao;

    @Resource
    private RecordContentDao recordContentDao;

    @Resource
    private RecordByContentDao recordByContentDao;

    @Resource
    private EquipmentInfoDao equipmentInfoDao;

    /**
     * @Author huxin
     * @Description 添加设施巡检类型
     * @Date 2019/1/12 18:23
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int addFaultDetection( RecordTable recordTable, String recordContent ) {
        Date time = new Date();
        //3代表设施巡检类型
        recordTable.setType(3);
        recordTable.setLogicRemove(false);
        recordTable.setCreateTime(time);
        int count = recordTableDao.insertSelective(recordTable);
        if(count==1){

            //根据设备ID查询设备信息
            Map<String,Object> map = equipmentInfoDao.queryEquipmentInfoById(recordTable.getEquipmentId());
            if(map.get("id")!=null){
                //添加记录内容
                RecordContent con = new RecordContent();
                con.setEquipmentTypeId((Long) map.get("id"));
                con.setRecordContent(recordContent);
                con.setLogicRemove(false);
                con.setCreateTime(time);
                recordContentDao.insertSelective(con);
                //添加记录关联记录内容表数据
                RecordByContent recordByContent = new RecordByContent();
                recordByContent.setRecordId(recordTable.getId());
                recordByContent.setContentId(con.getId());
                recordByContentDao.insertSelective(recordByContent);
                return count;
            }

            return 0;
        }
        return 0;
    }
}
