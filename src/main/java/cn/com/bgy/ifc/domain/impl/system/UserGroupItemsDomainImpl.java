package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupItemsDomain;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserGroupItemsDomainImpl implements UserGroupItemsDomain {


    private UserGroupItemsDao userGroupItemsDao;
    @Override
    public List<UserGroupItems> queryListByParam(UserGroupItems t) {
        return userGroupItemsDao.queryListByParam(t);
    }

    @Override
    public List<UserGroupItems> queryListByMap(Map<String, Object> map) {
        return userGroupItemsDao.queryListByMap(map);
    }

    @Override
    public UserGroupItems findById(Object id) {
        return userGroupItemsDao.findById(id);
    }

    @Override
    public int insert(UserGroupItems t) {
        return userGroupItemsDao.insert(t);
    }

    @Override
    public int insertSelective(UserGroupItems t) {
        return userGroupItemsDao.insertSelective(t);
    }

    @Override
    public int update(UserGroupItems t) {
        return userGroupItemsDao.update(t);
    }

    @Override
    public int updateSelective(UserGroupItems t) {
        return userGroupItemsDao.updateSelective(t);
    }


    @Override
    public int deleteBatch(List<Object> ids) {
        return userGroupItemsDao.deleteBatch(ids);
    }
}