package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.UserDao;
import cn.com.bgy.ifc.domain.interfaces.basic.UserDomain;
import cn.com.bgy.ifc.entity.po.basic.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDomainImpl implements UserDomain {
    @Resource
    private UserDao userDao;

    @Override
    public int save(User user) {
        return userDao.insert(user);
    }

}
