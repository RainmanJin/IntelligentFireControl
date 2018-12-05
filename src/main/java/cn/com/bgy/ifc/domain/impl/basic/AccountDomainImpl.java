package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.AccountDao;
import cn.com.bgy.ifc.dao.basic.UserDao;
import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.UserDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountDomainImpl implements AccountDomain {
    @Resource
    private AccountDao accountDao;

    @Override
    public int save(Account account) {
        return accountDao.insert(account);
    }

    /*@Override
    public List<Account> searchByWhere(Account account) {
        return accountDao.searchByWhere(account);
    }*/

    @Override
    public int deleteById(Long id) {
        return accountDao.deleteById(id);
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }


}
