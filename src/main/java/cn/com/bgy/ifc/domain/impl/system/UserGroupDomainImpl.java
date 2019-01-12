package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.dao.system.GroupsDao;
import cn.com.bgy.ifc.dao.system.UserGroupDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupDomain;
import cn.com.bgy.ifc.entity.po.project.Project;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.Groups;
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
    public PageInfo<Map<String,Object>> searchByPage(Page<Map<String,Object>> page, UserGroup userGroup){
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<Map<String, Object>> list = userGroupDao.queryListMapByParam(userGroup);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
    /**
     * @description:给用户组分配区域
     * @param: [groupId, list]
     * @return: void
     * @auther: chenlie
     * @date: 2019/1/10 10:25
     */
    @Override
    @Transactional
    public void distributionRegion(Long groupId, List<Long> list) {

        //删除用户组区域数据和用户区域数据
        userGroupItemsDao.deleteByGroupId(groupId);
        //插入新的用户组区域数据
        for (Long regionId: list){
            UserGroupItems userGroupItems=new UserGroupItems();
            userGroupItems.setRegionId(regionId);
            userGroupItems.setGroupId(groupId);
            userGroupItemsDao.insertSelective(userGroupItems);
        }
        UserGroup t =new UserGroup();
        t.setGroupId(groupId);
        List<UserGroup> userGroupList = userGroupDao.queryListByParam(t);
        //插入新的用户区域数据
        for (UserGroup userGroup:userGroupList){
            for (Long regionId: list){
                UserGroupItems userGroupItems=new UserGroupItems();
                userGroupItems.setRegionId(regionId);
                userGroupItems.setGroupId(groupId);
                userGroupItems.setUserId(userGroup.getUserId());
                userGroupItemsDao.insertSelective(userGroupItems);
            }
        }

    }
    /**
     * @description:重新分组用户
     * @param: [groupId, list]
     * @return:
     * @auther: chenlie
     * @date: 2019/1/10 10:40
     */
    //删除用户组项目数据和用户区域数据
    @Override
    @Transactional
    public void distributionAccount(Long groupId, List<Long> list) {

        Groups group = groupsDao.findById(groupId);
        userGroupItemsDao.deleteByGroupIdAndUserId(groupId,list);
       if(group.getType()==1){
           List<RegionInfo> userGroupItemsList = userGroupItemsDao.findRegionInfoByGroupId(groupId);
           //插入新的用户组项目数据
           for (Long userId: list){
               for (RegionInfo region :userGroupItemsList) {
                   UserGroupItems userGroupItems = new UserGroupItems();
                   userGroupItems.setRegionId(region.getId());
                   userGroupItems.setGroupId(groupId);
                   userGroupItems.setUserId(userId);
                   userGroupItemsDao.insertSelective(userGroupItems);
               }
           }
       }else if(group.getType()==2){
           List<Project> userGroupItemsList = userGroupItemsDao.findProjectInfoByGroupId(groupId);
           //插入新的用户组项目数据
           for (Long userId: list){
               for (Project project :userGroupItemsList) {
                   UserGroupItems userGroupItems = new UserGroupItems();
                   userGroupItems.setProjectId(project.getId());
                   userGroupItems.setGroupId(groupId);
                   userGroupItems.setUserId(userId);
                   userGroupItemsDao.insertSelective(userGroupItems);
               }
           }
       }

    }

    @Override
    @Transactional
    public void distributionProject(Long groupId, List<Long> list) {
        //删除用户组项目数据和用户区域数据
        userGroupItemsDao.deleteByGroupId(groupId);
        //插入新的用户组项目数据
        for (Long projectId: list){
            UserGroupItems userGroupItems=new UserGroupItems();
            userGroupItems.setProjectId(projectId);
            userGroupItems.setGroupId(groupId);
            userGroupItemsDao.insertSelective(userGroupItems);
        }
        UserGroup t =new UserGroup();
        t.setGroupId(groupId);
        List<UserGroup> userGroupList = userGroupDao.queryListByParam(t);
        //插入新的用户区域数据
        for (UserGroup userGroup:userGroupList){
            for (Long projectId: list){
                UserGroupItems userGroupItems=new UserGroupItems();
                userGroupItems.setProjectId(projectId);
                userGroupItems.setGroupId(groupId);
                userGroupItems.setUserId(userGroup.getUserId());
                userGroupItemsDao.insertSelective(userGroupItems);
            }
        }
    }
}