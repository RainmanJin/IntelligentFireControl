package cn.com.bgy.ifc.domain.interfaces.system.equipment;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyEquipmentTypeVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:设备类型
 * @date: 2018-12-21 11:51
 **/
public interface EquipmentTypeDomain {

    /**
     * @author: ZhangCheng
     * @description:集成平台全量增加设备类型信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyEquipmentType(List<BgyEquipmentTypeVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量增加设备类型信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyEquipmentType(List<BgyEquipmentTypeVo> list, Long orgId);
}
