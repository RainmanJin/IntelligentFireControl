package cn.com.bgy.ifc.domain.interfaces.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentTypeVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

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

    PageInfo queryListEquipmentType( Page page ,String keyword);

    int addEquipmentType( EquipmentType equipmentType );

    int updateEquipmentType( EquipmentType equipmentType );

    int deleteEquipmentType( String str );

    List<Map<String,Object>> queryEquipmentTypeBySuperId( Long id );
}
