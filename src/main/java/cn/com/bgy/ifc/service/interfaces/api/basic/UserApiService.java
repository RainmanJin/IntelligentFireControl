package cn.com.bgy.ifc.service.interfaces.api.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

public interface UserApiService {

    //获取集成平台用户登录
    ResponseVO<Object> obtainBgyUserLogin(String telephone, String password);

    //修改集成平台用户密码
    ResponseVO<Object> obtainBgyUpdatePass(String telephone, String password);

    //获取集成平台用户信息
    ResponseVO<Object> baseObtainBgyUser(int pageNo, int pageSize);

    //获取集成平台用户信息（全量）
    ResponseVO<Object> obtainBgyUser(int pageNo, int pageSize,ExternalInterfaceConfig config)throws Exception;

    //获取集成平台用户信息（增量）
    ResponseVO<Object> obtainBgyUserIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime)throws Exception;

    //获取集成平台用户权限
    void obtainBgyUserPermission();

    //获取集成平台用户权限（增量）
    void obtainBgyUserPermissionIncrement();
}
