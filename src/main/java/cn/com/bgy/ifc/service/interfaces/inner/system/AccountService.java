package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:用户管理
 * @date: 2019-01-19 19:52
 **/
public interface AccountService extends BaseService<Account> {

    /**
     * 分页查询用户数据
     * @param page
     * @param account
     * @return
     */
    PageInfo<Account> queryListByPage(Page page,Account account);

    /**
     * 根据角色值查询
     * @param roleValue
     * @param orgId
     * @return
     */
    List<SelectVo> queryListByRole(String roleValue, Long orgId);
}
