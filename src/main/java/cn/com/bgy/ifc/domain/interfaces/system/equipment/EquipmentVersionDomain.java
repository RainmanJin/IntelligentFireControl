package cn.com.bgy.ifc.domain.interfaces.system.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentVersionVo;

import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/

public interface EquipmentVersionDomain {

    void queryListEquipmentVersion();

    int addEquipmentVersion( EquipmentVersion record );

    int updateEquipmentVersion( EquipmentVersion record );

    int deleteEquipmentVersion( String str );

    /**
     * @author: ZhangCheng
     * @description:集成平台全量增加设备型号信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyEquipmentVersion( List<BgyEquipmentVersionVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量增加设备型号信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyEquipmentVersion( List<BgyEquipmentVersionVo> list, Long orgId);

}