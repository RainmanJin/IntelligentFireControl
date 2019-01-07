package cn.com.bgy.ifc.domain.impl.firerenovation;

import cn.com.bgy.ifc.dao.firepatrol.*;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.RenovationRecordDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        Date time= new Date();
        renovationRecord.setCreateTime(time);
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
                //判定是否动火，插入动火申请证明
                if(renovationRecord.getFire()==true){
                    FireApplication fireApplication =new FireApplication();
                    fireApplication.setRecordId(id);
                    fireApplication.setCreateTime(time);
                    fireApplication.setLogicRemove(false);
                    int rel1=fireApplicationDao.insertSelective(fireApplication);
                    if(rel1 !=1){
                        return 0;
                    }
                }
                //判定附近是否存在消防设施
                if(renovationRecord.getFireFacilities()==true){
                    FacilityProtection facilityProtection = new FacilityProtection();
                    facilityProtection.setRecordId(id);
                    facilityProtection.setCreateTime(time);
                    facilityProtection.setLogicRemove(false);
                    int rel2=facilityProtectionDao.insertSelective(facilityProtection);
                    if(rel2 !=1){
                        return 0;
                    }
                }
                //添加附近灭火器配置情况
                ExtinguisherConfig extinguisherConfig = new ExtinguisherConfig();
                extinguisherConfig.setRecordId(id);
                extinguisherConfig.setCreateTime(time);
                extinguisherConfig.setLogicRemove(false);
                int rel3 = extinguisherConfigDao.insertSelective(extinguisherConfig);
                if(rel3 !=1){
                    return 0;
                }
                //添加装修垃圾清理情况
                RenovationJunk renovationJunk = new RenovationJunk();
                renovationJunk.setRecordId(id);
                renovationJunk.setCreateTime(time);
                renovationJunk.setLogicRemove(false);
                renovationJunkDao.insertSelective(renovationJunk);
                int rel4 = renovationJunkDao.insertSelective(renovationJunk);
                if(rel4 !=1){
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
            //删除动火申请证明
            fireApplicationDao.deleteBatch(list);
            //删除消防设施保护措施情况
            facilityProtectionDao.deleteBatch(list);
            //删除附近灭火器配置情况
            extinguisherConfigDao.deleteBatch(list);
            //删除装修垃圾清理情况
            renovationJunkDao.deleteBatch(list);
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
    public int updateRenovationRecord( RenovationRecord renovationRecord ) {
//        FireApplication fireApplication =new FireApplication();
//        FacilityProtection facilityProtection = new FacilityProtection();
//        Long id = renovationRecord.getId();
//        //根据备案ID查询数据是否动火和附近是否有消防设施
//        RenovationRecord dateRenovationRecord = renovationRecordDao.findById(id);
//        //原数据   同时存在动火和附近有消防设施
//        if(dateRenovationRecord.getFire()==true && dateRenovationRecord.getFireFacilities()==true){
//            //修改数据  同时存在动火和附近有消防设施
//            if(renovationRecord.getFire()==true && dateRenovationRecord.getFireFacilities()==true){
//                return renovationRecordDao.updateSelective(renovationRecord);
//            //修改数据  存在动火
//            }else if(renovationRecord.getFire()==true && dateRenovationRecord.getFireFacilities()==false){
//
//                fireApplication.setRecordId(id);
//                fireApplication.setLogicRemove(true);
//                int rel = fireApplicationDao.updateSelective(fireApplication);
//                if(rel==1){
//                    return renovationRecordDao.updateSelective(renovationRecord);
//                }
//                return 0;
//           //修改数据   附近有消防设施
//            }else if(renovationRecord.getFire()==false && dateRenovationRecord.getFireFacilities()==true){
//                return null;
//            }
//            return null;
//        //原数据   存在动火申请
//        }else if(dateRenovationRecord.getFire()==true && dateRenovationRecord.getFireFacilities()==false){
//            //修改数据  不存在动火
//            if(renovationRecord.getFire()==false){
//                fireApplication.setRecordId(id);
//                fireApplication.setLogicRemove(true);
//                int rel = fireApplicationDao.updateSelective(fireApplication);
//                if(rel==1){
//                    return renovationRecordDao.updateSelective(renovationRecord);
//                }
//                return 0;
//            }
//            return renovationRecordDao.updateSelective(renovationRecord);
//        //原数据   附近存在消防设施
//        }else if(dateRenovationRecord.getFire()==false && dateRenovationRecord.getFireFacilities()==true){
//            //修改数据 附近不存在消防设施
//            if(dateRenovationRecord.getFireFacilities()==false){
//
//                facilityProtection.setRecordId(id);
//                facilityProtection.setLogicRemove(true);
//                int rel = facilityProtectionDao.updateSelective(facilityProtection);
//                if(rel==1){
//                    return renovationRecordDao.updateSelective(renovationRecord);
//                }
//                return 0;
//            }
//            return renovationRecordDao.updateSelective(renovationRecord);
//        }
//        //修改备案信息
//        return renovationRecordDao.updateSelective(renovationRecord);
        return 0;

    }
}
