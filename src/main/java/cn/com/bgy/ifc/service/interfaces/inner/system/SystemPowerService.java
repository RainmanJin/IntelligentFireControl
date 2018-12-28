package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemPower;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统权限
 * @date: 2018-12-28 11:16
 **/
public interface SystemPowerService extends BaseService<SystemPower> {
    /**
     * @author: ZhangCheng
     * @description:关键字分页查询
     * @param: [page, record]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.system.SystemPower>
     */
    PageInfo<SystemPower> queryListByPage(Page<SystemPower> page,  String keywords);


    /**
     * @author: ZhangCheng
     * @description:UserId查询
     * @param: [userId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.system.SystemPower>
     */
    List<SystemPower> queryListByUserId(Long userId);
}
