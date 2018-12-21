package cn.com.bgy.ifc.domain.impl.system.equipment;


import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentVersionDao;
import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentVersionDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVersionVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/
@Service
public class EquipmentVersionDomainImpl implements EquipmentVersionDomain {

    @Resource
    private EquipmentVersionDao equipmentVersionDao;

    @Override
    public void queryListEquipmentVersion() {

    }

    @Override
    public int addEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDao.insert(record);
    }

    @Override
    public int updateEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDao.updateEquipmentVersion(record);
    }

    @Override
    public int deleteEquipmentVersion( String str ) {
        List<Long> list = ListUtil.getListId(str);
        return equipmentVersionDao.deleteEquipmentVersion(list);
    }

    @Override
    public ResponseVO<Object> saveBgyEquipmentVersion( List<BgyEquipmentVersionVo> list, Long orgId ) {
        return null;
    }

    @Override
    public ResponseVO<Object> alterBgyEquipmentVersion( List<BgyEquipmentVersionVo> list, Long orgId ) {
        return null;
    }

}
