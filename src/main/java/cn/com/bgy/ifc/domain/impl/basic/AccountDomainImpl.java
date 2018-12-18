package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.dao.basic.AccountDao;
import cn.com.bgy.ifc.dao.basic.UserDao;
import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.UserDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.po.basic.User;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyUserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AccountDomainImpl implements AccountDomain {
    @Resource
    private AccountDao accountDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

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
     *
     * @param telephone
     * @return
     */
    @Override

    public Account findAccountByUserName(String telephone) {
        Account account = accountDao.findAccountByUserName(telephone);
        return account;
    }

    @Override
    public PageInfo<Account> findUserPowerByPage(Page<Account> page, Account account) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Account> accountList = accountDao.findUserPowerByPage(account);
        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
        return pageInfo;
    }

    @Override
    public int saveBgyAccount(BgyUserVo bgyUserVo) {
        Account account = new Account();
        account.setId(bgyUserVo.getId());
        account.setSex(bgyUserVo.getSex());
        account.setOrganizationId(bgyUserVo.getOrgId());
        account.setDepartmentId(0L);
        account.setTelephone(bgyUserVo.getTelephone());
        account.setUserName(bgyUserVo.getUserName());
        account.setPassword(bgyUserVo.getPassword());
        account.setUserType(SystemConstant.UserType.GENERAL_USER.getValue());
        account.setJobNumber(bgyUserVo.getJobNum());
        account.setIsDisable(bgyUserVo.getIsDisable());
        account.setIdentityNumber(bgyUserVo.getCreditNo());
        account.setRemark(bgyUserVo.getRemark());
        account.setRegistTime(new Date());
        return accountDao.insertSelective(account);
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> saveBgyAccountList(List<BgyUserVo> list, Long orgId) {
        int totalCount = 0;
        for (BgyUserVo userVo : list) {
            Account account = new Account();
            account.setId(userVo.getId());
            account.setSex(userVo.getSex());
            account.setOrganizationId(orgId);
            account.setDepartmentId(0L);
            account.setTelephone(userVo.getTelephone());
            account.setUserName(userVo.getUserName());
            account.setPassword(userVo.getPassword());
            account.setUserType(SystemConstant.UserType.GENERAL_USER.getValue());
            account.setJobNumber(userVo.getJobNum());
            account.setIsDisable(userVo.getIsDisable());
            account.setIdentityNumber(userVo.getCreditNo());
            account.setRemark(userVo.getRemark());
            account.setRegistTime(new Date());
            int count = accountDao.insertSelective(account);
            if (count == 1) {
                totalCount++;
            }
        }
        if(totalCount!=list.size()){
            throw new RuntimeException("批量同步用户数据失败!");
        }else {
            ExternalInterfaceMsg externalInterfaceMsg = new ExternalInterfaceMsg();
            externalInterfaceMsg.setPlatformValue(ExternalConstant.PlatformValue.INTEGERATED_PLATFORM.getValue());
            externalInterfaceMsg.setOrgId(orgId);
            externalInterfaceMsg.setMsgTypeValue(ExternalConstant.MsgTypeValue.BGY_ACCOUNT_OBTAIN.getValue());
            externalInterfaceMsg.setTotalCount(totalCount);
            externalInterfaceMsg.setAddCount(totalCount);
            externalInterfaceMsg.setSuccessCount(totalCount);
            externalInterfaceMsg.setErrorCount(0);
            externalInterfaceMsg.setRequestTime(new Date());
            externalInterfaceMsgDomain.insertSelective(externalInterfaceMsg);
            return ResponseVO.success().setMsg("同步集成平台用户总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }

}
