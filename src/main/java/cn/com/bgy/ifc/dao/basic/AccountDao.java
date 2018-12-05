package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Account;

import java.util.List;

public interface AccountDao {
    int insert(Account record);

    int insertSelective(Account record);
    List<Account> searchByWhere(Account account);

    int deleteById(Long id);

    Account findById(Long id);

    int updateById(Account account);
}