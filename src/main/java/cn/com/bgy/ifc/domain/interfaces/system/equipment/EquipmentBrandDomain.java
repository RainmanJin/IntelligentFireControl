package cn.com.bgy.ifc.domain.interfaces.system.equipment;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentBrandVo;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentTypeVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:设备品牌
 * @date: 2018-12-21 15:00
 **/
public interface EquipmentBrandDomain {

    /**
     * @author: ZhangCheng
     * @description:集成平台全量增加设备品牌信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyEquipmentBrand(List<BgyEquipmentBrandVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量增加设备品牌信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyEquipmentBrand(List<BgyEquipmentBrandVo> list, Long orgId);
}
