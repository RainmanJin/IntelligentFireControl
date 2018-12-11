package cn.com.bgy.ifc.service.interfaces.api.basic;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-11 16:23
 **/
public interface BgyProjectService {

    //获取集成平台用户信息
    void obtainBgyProject();

    //获取集成平台用户信息（增量）
    void obtainBgyProjectIncrement();
}
