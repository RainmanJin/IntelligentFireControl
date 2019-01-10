package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.dao.system.GroupsDao;
import cn.com.bgy.ifc.dao.system.UserGroupDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupDomain;
import cn.com.bgy.ifc.entity.po.system.UserGroup;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;
import cn.com.bgy.ifc.entity.vo.system.GroupsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserGroupDomainImpl implements UserGroupDomain {
    @Resource
    private UserGroupDao userGroupDao;
    @Resource
    private GroupsDao groupsDao;

    @Resource
    private UserGroupItemsDao userGroupItemsDao;

    @Override
    public List<UserGroup> queryListByParam(UserGroup t) {
        return userGroupDao.queryListByParam(t);
    }

    @Override
    public List<UserGroup> queryListByMap(Map<String, Object> map) {
        return userGroupDao.queryListByMap(map);
    }

    @Override
    public UserGroup findById(Long id) {
        return userGroupDao.findById(id);
    }

    @Override
    public int insert(UserGroup t) {
        return userGroupDao.insert(t);
    }

    @Override
    public int insertSelective(UserGroup t) {
        return insertSelective(t);
    }

    @Override
    public int update(UserGroup t) {
        return userGroupDao.update(t);
    }

    @Override
    public int updateSelective(UserGroup t) {
        return updateSelective(t);
    }


    @Override
    public int deleteBatch(List<Long> ids) {
        return userGroupDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<Map<String,Object>> searchByPage(Page<Map<String,Object>> page, GroupsVo groupsVo){
        UserGroup userGroup=new UserGroup();
        CopyUtil.copyProperties(groupsVo,userGroup);
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Map<String, Object>> list = userGroupDao.queryListMapByParam(userGroup);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    @Transactional
    public void distributionRegion(Long groupId, List<Long> list) {
        //查询组对应的区域




         groupsDao.findById(groupId);
    }

    @Override
    @Transactional
    public void distributionAccount(Long groupId, List<Long> list) {

    }

    @Override
    @Transactional
    public void distributionProject(Long groupId, List<Long> list) {

    }
}