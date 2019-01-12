package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.dao.equipment.EquipmentTypeDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordByContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordTableDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordByContent;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordContent;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

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
    private EquipmentTypeDao equipmentTypeDao;

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
            //添加记录内容
            RecordContent con = new RecordContent();
            //根据设备ID查询设备类型ID
            EquipmentType type = equipmentTypeDao.findById(recordTable.getEquipmentId());
            con.setEquipmentTypeId(type.getId());
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
}
