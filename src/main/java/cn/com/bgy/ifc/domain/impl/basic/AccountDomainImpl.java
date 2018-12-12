package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.AccountDao;
import cn.com.bgy.ifc.dao.basic.UserDao;
import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.UserDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public List<Account> searchByWhere(Account account) {
        return accountDao.searchByWhere(account);
    }

    @Override
    public PageInfo<Account> searchByPage(Page page, Account account) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Account> accountList = this.searchByWhere(account);
        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
        return pageInfo;
    }

    @Override
    public int deleteById(Long id) {
        return accountDao.deleteById(id);
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public int update(Account account) {
        return accountDao.updateById(account);
    }

    /**
     * 登录
     * @param userName
     * @return
     */
    @Override
    public Account findAccountByUserName(String userName,String password) {
        Account account = accountDao.findAccountByUserName(userName);
        /**
         * 判断密码是否一致
         */
        if (password.equals(account.getPassword())){
            return account;
        }
        return null;
    }

    @Override
    public PageInfo<Account> findUserPowerByPage(Page<Account> page,Account account) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Account> accountList = accountDao.findUserPowerByPage(account);
        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
        return pageInfo;
    }


}
