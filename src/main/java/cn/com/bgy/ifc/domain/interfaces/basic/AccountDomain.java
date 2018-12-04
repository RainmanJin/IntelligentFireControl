package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.User;

import java.util.List;

public interface AccountDomain {
    int save(Account account);

    List<Account> searchByWhere(Account account);

    int deleteById(Long id);

    Account findById(Long id);
}
