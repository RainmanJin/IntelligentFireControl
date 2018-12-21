package cn.com.bgy.ifc.domain.impl.system.equipment;

import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentVersionDomain;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVersionVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:设备型号
 * @date: 2018-12-21 17:57
 **/
public class EquipmentVersionDomainImpl implements EquipmentVersionDomain {

    @Override
    public ResponseVO<Object> saveBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId) {
        return null;
    }

    @Override
    public ResponseVO<Object> alterBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId) {
        return null;
    }
}
