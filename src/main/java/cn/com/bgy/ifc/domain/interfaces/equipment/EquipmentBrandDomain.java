package cn.com.bgy.ifc.domain.interfaces.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyEquipmentBrandVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

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

    PageInfo queryListEquipmentBrand( Page page,String keyword);

    int addEquipmentBrand( EquipmentBrand equipmentBrand );

    int updateEquipmentBrand(EquipmentBrand equipmentBrand);

    int deleteEquipmentBrand(String str);

    List<Map<String,Object>> queryAllEquipmentBrand();
}
