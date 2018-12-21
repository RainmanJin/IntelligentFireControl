package cn.com.bgy.ifc.domain.impl.system.user;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.dao.system.user.DepartmentDao;
import cn.com.bgy.ifc.domain.interfaces.system.user.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.vo.basic.DepartmentVo;
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
    public PageInfo<DepartmentVo> queryListByPage(Page<DepartmentVo> page, DepartmentVo departmentVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Department> list=departmentDao.queryListByParam(departmentVo);
        return new PageInfo<DepartmentVo>(CopyUtil.convertList(list, new DepartmentVo()));
    }

    @Override
    public List<Department> queryListByParam(DepartmentVo departmentVo) {
        return departmentDao.queryListByParam(departmentVo);
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
        department.setCreateTime(new Date());
        return departmentDao.update(department);
    }

}
