package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.AccountDao;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-19 19:53
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public List<SelectVo> queryListByRole(String roleValue, Long orgId) {
        Map<String,Object> map=new HashMap<>();
        if(roleValue.length()>0){
            map.put("roleValue",roleValue);
        }
        if(orgId!=null){
            map.put("organizationId",orgId);
        }
        List<SelectVo> selectVos=new ArrayList<>();
        List<Account> list=accountDao.queryListByRole(map);
        for(Account account:list){
            SelectVo selectVo=new SelectVo();
            selectVo.setValue(String.valueOf(account.getId()));
            selectVo.setName(account.getUserName());
            selectVos.add(selectVo);
        }
        return selectVos;
    }
}
