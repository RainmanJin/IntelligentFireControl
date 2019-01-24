package cn.com.bgy.ifc.domain.interfaces.equipment;

import cn.com.bgy.ifc.entity.po.equipment.Analog;

/**
 * @author: ZhangCheng
 * @description:模拟量管理
 * @date: 2019-01-24 09:02
 **/
public interface AnalogDomain {

    /**
     * 添加设备模拟量值
     * @param analog
     * @return
     */
    int insertAnalogAndState(Analog analog);
}
