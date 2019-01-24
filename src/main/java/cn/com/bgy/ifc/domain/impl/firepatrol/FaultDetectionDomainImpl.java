package cn.com.bgy.ifc.domain.impl.firepatrol;

import cn.com.bgy.ifc.bgy.utils.StringUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordByContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordContentDao;
import cn.com.bgy.ifc.dao.firepatrol.RecordTableDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
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
    private EquipmentInfoDao equipmentInfoDao;



    /**
     * @Author huxin
     * @Description 添加设施巡检类型
     * @Date 2019/1/12 18:23
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int addFaultDetection( RecordTable recordTable, String recordContent ) {
        //查询设备信息
        EquipmentInfo equipmentInfo = equipmentInfoDao.findById(recordTable.getEquipmentId());
        Long equipmentTypeId = equipmentInfo.getTypeId();
        //判定设备类型ID是否为空
        if(equipmentTypeId!=null&&equipmentTypeId>0){
            Date time = new Date();
            recordTable.setLogicRemove(false);
            recordTable.setCreateTime(time);
            int count = recordTableDao.insertSelective(recordTable);
            //添加记录内容
            RecordContent con = new RecordContent();
            //添加设备ID
            con.setEquipmentTypeId(equipmentTypeId);
            con.setType(recordTable.getType());
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
    /*
     * @Author  huxin
     * @Description 修改设施设备故障检测
     * @param   [recordTable, recordContent]
     * @retrue  int
     * @Date 2019/1/15 18:14
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int editFaultDetection( RecordTable recordTable, String recordContent ) {
        Date time = new Date();
        if(recordTable.getId()!=null && recordTable.getId()>0){
            recordTable.setCreateTime(time);
            int count= recordTableDao.updateSelective(recordTable);
            if(StringUtil.isNotEmpty(recordContent)){
                //根据记录表ID查询设施设备故障检查内容
                RecordContent con= recordContentDao.queryContentByRecordId(recordTable.getId());
                if(null!=con){
                    if(!recordContent.equals(con.getRecordContent())){
                        con.setRecordContent(recordContent);
                        con.setCreateTime(time);
                        recordContentDao.updateSelective(con);
                    }
                }

            }
            return count;
        }
        return 0;
    }
}
