package cn.com.bgy.ifc.domain.impl.system.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentVersionDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVersionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:设备型号
 * @date: 2018-12-21 17:57
 **/
@Service
public class EquipmentVersionDomainImpl implements EquipmentVersionDomain {
    private static Logger logger = LoggerFactory.getLogger(EquipmentVersionDomainImpl.class);
    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public ResponseVO<Object> saveBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId) {
        try{
            List<EquipmentVersion> versionList=new ArrayList<>();
            for(BgyEquipmentVersionVo versionVo:list){
                EquipmentVersion version=new EquipmentVersion();
                version.setId(versionVo.getId());
                version.setName(versionVo.getName());
                version.setBrandId(versionVo.getBrandId());
                version.setDescription(versionVo.getDescription());
            }
        int totalCount = DBUtil.insertByList("equipment_brand", versionList);
        if (totalCount != versionList.size()) {
            return ResponseVO.error().setMsg("同步集成平台设备品牌异常");
        } else {
            externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_EQUIPMENT_BRAND_OBTAIN.getValue(), totalCount);
            return ResponseVO.success().setMsg("同步集成平台设备品牌总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    } catch (Exception e) {
        logger.error("同步集成平台设备品牌doMain异常:" + e);
        return ResponseVO.error().setMsg("同步集成平台设备品牌异常");
    }
    }

    @Override
    public ResponseVO<Object> alterBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId) {
        return null;
    }
}
