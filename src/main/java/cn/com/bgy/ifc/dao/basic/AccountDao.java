package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Account;

import java.util.List;

public interface AccountDao {
    int insert(Account record);

    int insertSelective(Account record);

    /**
     * 条件查询用户
     * @param account
     * @return
     */
    List<Account> searchByWhere(Account account);

    /**
     * 根据Id删除用户
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据Id查找用户
     * @param id
     * @return
     */
    Account findById(Long id);

    /**
     * 根据id更新用户
     * @param account
     * @return
     */
    int updateById(Account account);

    /**
     *
     * @param userName
     * @return
     */
    Account findAccountByUserName(String userName);

    /**
     * 分页查询用户权限
     * @param account
     * @return
     */
    List<Account> findUserPowerByPage(Account account);
}