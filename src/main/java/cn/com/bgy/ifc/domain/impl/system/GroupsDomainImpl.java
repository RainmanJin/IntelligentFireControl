package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.GroupsDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.system.GroupsDomain;
import cn.com.bgy.ifc.entity.po.system.Groups;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GroupsDomainImpl implements GroupsDomain {
    @Resource
    private GroupsDao groupsDao;
    @Resource
    private UserGroupItemsDao userGroupItemsDao;
    @Override
    public List<Groups> queryListByParam(Groups t) {
        return groupsDao.queryListByParam(t);
    }

    @Override
    public List<Groups> queryListByMap(Map<String, Object> map) {
        return groupsDao.queryListByMap(map);
    }

    @Override
    public Groups findById(Long id) {
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
    public PageInfo<Groups> queryListByPage(Page<Groups> page,Groups groups) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());

        List<Groups> list=groupsDao.queryListByParam(groups);
        return new PageInfo<Groups>(list);
    }

    @Override
    @Transactional
    public int insertWithRegionAndProject(Groups groups, List<Long> idList) {
        int res=groupsDao.insert(groups);
        if(groups.getType()==1){
           if(idList !=null){
               for(Long id:idList){
                   UserGroupItems record=new UserGroupItems();
                   record.setRegionId(id);
                   record.setGroupId(groups.getId());
                   userGroupItemsDao.insertSelective(record);
               }
           }
        }else if(groups.getType()==2){
            if(idList !=null){
                for(Long id:idList){
                    UserGroupItems record=new UserGroupItems();
                    record.setProjectId(id);
                    record.setGroupId(groups.getId());
                    userGroupItemsDao.insertSelective(record);
                }
            }
        }
        return res;
    }


    @Override
    public int deleteBatch(List<Long> ids) {
        return groupsDao.deleteBatch(ids);
    }


}