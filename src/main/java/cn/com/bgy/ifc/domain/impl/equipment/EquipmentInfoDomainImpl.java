package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.domain.interfaces.equipment.EquipmentInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentBrandVo;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:设备信息
 * @date: 2018-12-22 16:41
 **/
public class EquipmentInfoDomainImpl implements EquipmentInfoDomain {

    private static Logger logger = LoggerFactory.getLogger(EquipmentInfoDomainImpl.class);

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;


    @Override
    public ResponseVO<Object> saveBgyEquipmentInfo(List<BgyEquipmentVo> list, Long orgId) {
        try {
            List<EquipmentInfo> infoList = new ArrayList<>();
            for (BgyEquipmentVo bgyEquipmentVo : list) {
                EquipmentInfo info=new EquipmentInfo();
                info.setId(bgyEquipmentVo.getId());
                info.setName(bgyEquipmentVo.getName());
                info.setDescription(bgyEquipmentVo.getDescription());
                info.setApiCode(bgyEquipmentVo.getApiCode());
                info.setInputCode(bgyEquipmentVo.getInputCode());
                info.setMachineRoomId(bgyEquipmentVo.getMachineRoomId());
                info.setLocaltionCode(bgyEquipmentVo.getLocaltionCode());
                info.setBrandId(bgyEquipmentVo.getBrandId());
                //info.setInWorkTime(bgyEquipmentVo.getInWorkTime());
                infoList.add(info);
            }
            int totalCount = DBUtil.insertByList("equipment_info", infoList);
            if (totalCount != infoList.size()) {
                return ResponseVO.error().setMsg("同步集成平台设备信息异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.GBY_EQUIPMENT_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台设备信息总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            logger.error("同步集成平台设备信息doMain异常:" + e);
            return ResponseVO.error().setMsg("同步集成平台设备信息异常");
        }
    }

    @Override
    public ResponseVO<Object> alterBgyEquipmentInfo(List<BgyEquipmentVo> list, Long orgId) {
        return null;
    }
}
