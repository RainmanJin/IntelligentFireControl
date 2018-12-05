package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.DepartmentDao;
import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentDomainImpl implements DepartmentDomain {
    @Resource
    private DepartmentDao departmentDao;


    @Override
    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    @Override
    public int deleteById(Long id) {
        return departmentDao.deleteById(id);
    }

    @Override
    public int insert(Department department) {
        if(department.getParentId()==null){
            department.setParentId(0L);
        }
        department.setState(1);
        department.setCreateTime(new Date());
        department.setLogicRemove(false);
        return departmentDao.insert(department);
    }

    @Override
    public int update(Department department) {
        return departmentDao.update(department);
    }

    @Override
    public int deleteBatchById(List<Long> ids) {
        return departmentDao.deleteBatchById(ids);
    }
}
