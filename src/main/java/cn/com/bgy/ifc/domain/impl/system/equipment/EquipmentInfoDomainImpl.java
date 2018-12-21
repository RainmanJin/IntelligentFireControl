package cn.com.bgy.ifc.domain.impl.system.equipment;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentInfoDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息domainImpl
 **/
@Service
public class EquipmentInfoDomainImpl implements EquipmentInfoDomain {

    @Resource
    private EquipmentInfoDao equipmentInfoDao;
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 11:36
     */
    @Override
    public void queryListEquipmentInfo() {
        
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 11:36
     */
    @Override
    @Transactional
    public int addEquipmentInfo( EquipmentInfo equipmentInfo ) {
        return equipmentInfoDao.insert(equipmentInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 11:36
     */
    @Override
    @Transactional
    public int updateEquipmentInfo( EquipmentInfo equipmentInfo ) {
        return equipmentInfoDao.updateEquipmentInfo(equipmentInfo);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 11:36
     */
    @Override
    @Transactional
    public int deleteEquipmentInfo( String str ) {
        List<Long> list = ListUtil.getListId(str);
        return equipmentInfoDao.deleteEquipmentInfo(list);
    }
}
