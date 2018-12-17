package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.SystemRoleDao;
import cn.com.bgy.ifc.domain.interfaces.basic.RoleDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统角色
 * @date: 2018-12-05 11:00
 **/
@Service
public class RoleDomainImpl implements RoleDomain {

    @Resource
    private SystemRoleDao systemRoleDao;

    @Override
    public SystemRole findById(Long id) {
        return systemRoleDao.findById(id);
    }

    @SuppressWarnings("UnusedAssignment")
    @Override
    public PageInfo<SystemRole> queryListByPage(Page<SystemRole> page, SystemRole record) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemRole> list = systemRoleDao.queryAllList();
        return new PageInfo<SystemRole>(list);
    }

    @Override
    public List<SystemRole> queryListByParam(SystemRole record) {
        return systemRoleDao.queryListByParam(record);
    }

    @Transactional
    @Override
    public int insert(SystemRole record) {
        record.setLogicRemove(false);
        record.setOrganizationId(1L);
        record.setState(1);
        return systemRoleDao.insert(record);
    }

    @Transactional
    @Override
    public int updateRole(SystemRole record) {
        return systemRoleDao.updateRole(record);
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        return systemRoleDao.deleteById(id);
    }

    @Override
    public int deleteRole( String str ) {
            List<Long> list = new ArrayList<>();
            String arr[] = str.split(",");
            if(arr.length>0){
                for (int i = 0; i <arr.length ; i++) {
                    System.out.println("*****"+arr[i]);
                    list.add(Long.valueOf(arr[i]));
                }
                return systemRoleDao.deleteRole(list);
            }else{
                return 0;
            }
    }
    /**
     * @Author huxin
     * @Description 查询角色类型
     * @Date 2018/12/15 17:42
     */
    @Override
    public List<SystemRole> queryRoleType() {

        return systemRoleDao.queryRoleType();
    }

}
