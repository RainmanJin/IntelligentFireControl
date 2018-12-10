package cn.com.bgy.ifc.service.interfaces.api.basic;

import cn.com.bgy.ifc.entity.vo.ResponseVO;

public interface UserApiService {

    //获取集成平台用户登录
    ResponseVO<Object> obtainBgyUserLogin(String telephone, String password);

    //修改集成平台用户密码
    ResponseVO<Object> obtainBgyUpdatePass(String telephone, String password);

    //获取集成平台用户信息
    void obtainBgyUser();

    //获取集成平台用户信息（增量）
    void obtainBgyUserIncrement();

    //获取集成平台用户权限
    void obtainBgyUserPermission();

    //获取集成平台用户权限（增量）
    void obtainBgyUserPermissionIncrement();
}
