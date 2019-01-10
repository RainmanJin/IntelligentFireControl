package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.AnalogueUnit;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:中联永安物联接口模拟量单位
 * @date: 2019-01-10 15:29
 **/
public interface AnalogueUnitService {

    /**
     * 查询所有模拟量单位
     * @return
     */
    List<AnalogueUnit> queryAllList();
}
