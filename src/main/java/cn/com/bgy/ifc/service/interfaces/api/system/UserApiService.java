package cn.com.bgy.ifc.service.interfaces.api.system;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台用户同步
 * @date: 2018-12-19 12:02
 **/
public interface UserApiService {

    /**
     * 获取集成平台用户登录
     * @param telephone
     * @param password
     * @return
     */
    ResponseVO<Object> obtainBgyUserLogin(String telephone, String password);

    /**
     * 修改集成平台用户密码
     * @param telephone
     * @param password
     * @return
     */
    ResponseVO<Object> obtainBgyUpdatePass(String telephone, String password);

    /**
     * 获取集成平台用户信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    ResponseVO<Object> baseObtainBgyUser(int pageNo, int pageSize);

    /**
     * 获取集成平台用户信息（全量）
     * @param pageNo
     * @param pageSize
     * @param config
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyUser(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * 获取集成平台用户信息（增量）
     *
     * @param pageNo
     * @param pageSize
     * @param config
     * @param createTime
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyUserIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;

    /**
     * 获取集成平台用户权限
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    ResponseVO<Object> baseObtainBgyUserPermission(int pageNo, int pageSize);

    /**
     * 获取集成平台用户权限（全量）
     *
     * @param pageNo
     * @param pageSize
     * @param config
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyUserPermission(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * 获取集成平台用户权限（增量）
     *
     * @param pageNo
     * @param pageSize
     * @param config
     * @param createTime
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyUserPermissionIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;
}
