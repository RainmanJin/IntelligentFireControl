package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.entity.po.equipment.AnalogueUnit;

import java.util.List;

/**
 * @author zhangcheng
 */
public interface AnalogueUnitDao {
    /**
     * @mbg.generated 2019-01-10
     */
    int insert(AnalogueUnit record);

    /**
     * @mbg.generated 2019-01-10
     */
    int insertSelective(AnalogueUnit record);

    /**
     * 查询所有模拟量单位
     * @return
     */
    List<AnalogueUnit> queryAllList();
}