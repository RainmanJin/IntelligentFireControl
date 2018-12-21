package cn.com.bgy.ifc.domain.impl.system.user;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.dao.system.user.AccountDao;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.user.AccountDomain;
import cn.com.bgy.ifc.entity.po.system.user.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyUserVo;
import cn.com.bgy.ifc.entity.vo.system.user.AccountVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<AccountVo> searchByWhere(AccountVo account) {
        return accountDao.searchByWhere(account);
    }

    @Override
    public PageInfo<AccountVo> searchByPage(Page page, AccountVo account) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<AccountVo> accountList = this.searchByWhere(account);
        PageInfo<AccountVo> pageInfo = new PageInfo<>(accountList);
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
    public ResponseVO<Object> saveBgyAccountList(List<BgyUserVo> list, Long orgId) {
        try {
            List<Account> accountList = new ArrayList<>();
            Date createTime = new Date();
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
                account.setRegistTime(createTime);
                accountList.add(account);
            }
            int totalCount = DBUtil.insertByList("account", accountList);
            if (totalCount != accountList.size()) {
                return ResponseVO.error().setMsg("同步集成平台用户异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_ACCOUNT_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台用户总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            return ResponseVO.error().setMsg("同步集成平台用户异常");
        }
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyAccountList(List<BgyUserVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int isDelete = SystemConstant.EnableState.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        Date createTime = new Date();
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
            account.setRegistTime(createTime);
            int operType = userVo.getOperType();
            //新增
            if (operType == addType) {
                int count = accountDao.insertSelective(account);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = accountDao.updateSelective(account);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                account.setIsDisable(isDelete);
                int count = accountDao.updateSelective(account);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步用户增量数据失败!");
        } else {
            int msgType = ExternalConstant.MsgTypeValue.BGY_ACCOUNT_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台用户总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }

    }

}
