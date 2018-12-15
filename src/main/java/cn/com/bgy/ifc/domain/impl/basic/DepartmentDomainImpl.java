package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.basic.DepartmentDao;
import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentDomainImpl implements DepartmentDomain {
    @Resource
    private DepartmentDao departmentDao;


    @SuppressWarnings("UnusedAssignment")
    @Override
    public PageInfo<Department> queryListByPage(Page<Department> page,Department department) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Department> list=departmentDao.queryListByParam(department);
        return new PageInfo<Department>(list);
    }

    @Override
    public List<Department> queryListByParam(Department department) {
        return departmentDao.queryListByParam(department);
    }

    @Override
    public List<Department> queryAllList() {
        return departmentDao.queryAllList();
    }

    @Override
    public Department findById(Long id) {
        return departmentDao.findById(id);
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        return departmentDao.deleteById(id);
    }

    @Transactional
    @Override
    public int insert(Department department) {
        if(department.getParentId()==null){
            department.setParentId(0L);
        }
        department.setState(SystemConstant.EnableState.ENABLE.getValue());
        department.setCreateTime(new Date());
        department.setLogicRemove(false);
        return departmentDao.insert(department);
    }

    @Transactional
    @Override
    public int update(Department department) {
        if(department == null || StringUtils.isEmpty(department.getId())){
            return 0;
        }
        if(department.getParentId()==null){
            department.setParentId(0L);
        }
        department.setCreateTime(new Date());
        return departmentDao.update(department);
    }

    @Transactional
    @Override
    public int deleteBatchById(List<Long> ids) {
        return departmentDao.deleteBatchById(ids);
    }
}
