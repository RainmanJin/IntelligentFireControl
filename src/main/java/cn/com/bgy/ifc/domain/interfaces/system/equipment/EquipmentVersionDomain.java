package cn.com.bgy.ifc.domain.interfaces.system.equipment;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVersionVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:设备型号
 * @date: 2018-12-21 17:57
 **/
public interface EquipmentVersionDomain {

    /**
     * @author: ZhangCheng
     * @description:集成平台全量增加设备型号信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量增加设备型号信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyEquipmentVersion(List<BgyEquipmentVersionVo> list, Long orgId);
}
