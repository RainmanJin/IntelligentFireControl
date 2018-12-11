package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AccountDomain {
    /**
     * 保存用户
     * @param account
     * @return
     */
    int save(Account account);

    /**
     * 条件查找用户
     * @param account
     * @return
     */
    List<Account> searchByWhere(Account account);

    /**
     * 分页查询用户
     * @param page
     * @param account
     * @return
     */
    PageInfo<Account> searchByPage(Page page, Account account);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    Account findById(Long id);

    /**
     * 根据id更新用户
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 根据用户名称查询用户对象
     * @param userName
     * @return
     */
    Account findAccountByUserName(String userName,String password);
}
