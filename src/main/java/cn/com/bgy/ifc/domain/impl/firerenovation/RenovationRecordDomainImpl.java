package cn.com.bgy.ifc.domain.impl.firerenovation;

import cn.com.bgy.ifc.dao.firepatrol.*;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.RenovationRecordDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author huxin
 * @Date 2019/1/7 9:25
 * @Description 装修备案情况
 **/
@Service
public class RenovationRecordDomainImpl implements RenovationRecordDomain {

    @Resource
    private RenovationRecordDao renovationRecordDao;

    @Resource
    private RegionByRecordDao regionByRecordDao;

    @Resource
    private ExtinguisherConfigDao extinguisherConfigDao;

    @Resource
    private FacilityProtectionDao facilityProtectionDao;

    @Resource
    private FireApplicationDao fireApplicationDao;

    @Resource
    private RenovationJunkDao renovationJunkDao;


    /**
     * @Author huxin
     * @Description 添加装修备案
     * @Date 2019/1/7 9:41
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int addRenovationRecord( RegionByRecord regionByRecord, RenovationRecord renovationRecord ) {
        renovationRecord.setCreateTime(new Date());
        renovationRecord.setLogicRemove(false);
        int count = renovationRecordDao.insertSelective(renovationRecord);
        if(count ==0){
            Long id = renovationRecord.getId();
            if(id != null||id>0){
                //添加备案信息与区域项目的关联信息
                regionByRecord.setId(id);
                int rel =regionByRecordDao.insertSelective(regionByRecord);
                if(rel!=1){
                    return 0;
                }
            }
            return count;
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 删除备案信息（含批量）
     * @Date 2019/1/7 11:48
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int deleteRenovationRecord( List<Long> list ) {
        int count = renovationRecordDao.deleteBatch(list);
        if(count>0){
            //根据备案ID删除
            //删除动火申请证明
            fireApplicationDao.deleteByRecordId(list);
            //删除消防设施保护措施情况
            facilityProtectionDao.deleteByRecordId(list);
            //删除附近灭火器配置情况
            extinguisherConfigDao.deleteByRecordId(list);
            //删除装修垃圾清理情况
            renovationJunkDao.deleteByRecordId(list);
            return count;
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改备案信息
     * @Date 2019/1/7 14:03
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int updateRenovationRecord( RenovationRecord renovationRecord ) {
        if(renovationRecord.getId() != null || renovationRecord.getId()>0){
            //修改数据不存在动火情况
            if(renovationRecord.getFire()==false){
                //根据备案ID查询是否存在动火证申请情况数据
                FireApplication fireApplication = fireApplicationDao.queryByRecordId(renovationRecord.getId());
                //动火证申请情况存在
                if(fireApplication.getId()!=null ||fireApplication.getId()>0){
                    List<Long> list =new ArrayList<>();
                    list.add(fireApplication.getId());
                    //删除
                    fireApplicationDao.deleteBatch(list);
                }
            }
            //修改数据 附近不存在消防设施
            if(renovationRecord.getFireFacilities()==false){
                //根据备案ID查询是否存在消防设施保护情况
                FacilityProtection facilityProtection = facilityProtectionDao.queryByRecordId(renovationRecord.getId());
                //存在
                if(facilityProtection.getId()!=null ||facilityProtection.getId()>0){
                    List<Long> list =new ArrayList<>();
                    list.add(facilityProtection.getId());
                    facilityProtectionDao.deleteBatch(list);
                }
            }
            return renovationRecordDao.updateSelective(renovationRecord);
        }

        return 0;

    }
}
