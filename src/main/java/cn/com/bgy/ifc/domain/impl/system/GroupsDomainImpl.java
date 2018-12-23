package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.GroupsDao;
import cn.com.bgy.ifc.domain.interfaces.system.GroupsDomain;
import cn.com.bgy.ifc.entity.po.system.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GroupsDomainImpl implements GroupsDomain {
    @Resource
    private GroupsDao groupsDao;
    @Override
    public List<Groups> queryListByParam(Groups t) {
        return groupsDao.queryListByParam(t);
    }

    @Override
    public List<Groups> queryListByMap(Map<String, Object> map) {
        return groupsDao.queryListByMap(map);
    }

    @Override
    public Groups findById(Object id) {
        return groupsDao.findById(id);
    }

    @Override
    public int insert(Groups t) {
        return groupsDao.insert(t);
    }

    @Override
    public int insertSelective(Groups t) {
        return groupsDao.insertSelective(t);
    }

    @Override
    public int update(Groups t) {
        return groupsDao.update(t);
    }

    @Override
    public int updateSelective(Groups t) {
        return groupsDao.updateSelective(t);
    }


    @Override
    public int deleteBatch(List<Object> ids) {
        return groupsDao.deleteBatch(ids);
    }


}