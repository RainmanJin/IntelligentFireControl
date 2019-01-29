package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.AccountDao;
import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.AccountService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:成员管理
 * @date: 2019-01-19 19:53
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public PageInfo<Account> queryListByPage(Page page,Account account) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Account> list = accountDao.queryListByParam(account);
        PageInfo<Account> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<SelectVo> queryListByRole(String roleValue, Long orgId) {
        Map<String, Object> map = new HashMap<>();
        if (roleValue!=null&&roleValue.length() > 0) {
            map.put("roleValue", roleValue);
        }
        if (orgId!=null&&orgId != null) {
            map.put("organizationId", orgId);
        }
        List<SelectVo> selectVos = new ArrayList<>();
        List<Account> list = accountDao.queryListByRole(map);
        for (Account account : list) {
            if (null !=account) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(account.getId()));
                selectVo.setName(account.getUserName());
                selectVos.add(selectVo);
            }
        }
        return selectVos;
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public int insert(Account account) {
        return 0;
    }

    @Override
    public int insertSelective(Account account) {
        return 0;
    }

    @Override
    public int update(Account account) {
        return 0;
    }

    @Override
    public int updateSelective(Account account) {
        return accountDao.updateSelective(account);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return 0;
    }
}
