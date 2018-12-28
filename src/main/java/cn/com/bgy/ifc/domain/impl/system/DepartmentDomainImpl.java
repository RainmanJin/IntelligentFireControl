package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.dao.system.DepartmentDao;
import cn.com.bgy.ifc.domain.interfaces.system.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.system.Department;
import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentDomainImpl implements DepartmentDomain {


    @Resource
    private DepartmentDao departmentDao;


    @Override
    public PageInfo<Department> queryListByPage(Page<Department> page, Department department) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Department> list=departmentDao.queryListByParam(department);
        return new PageInfo<Department>(list);
    }

    @Override
    public List<Department> queryListByParam(Department department) {
        return departmentDao.queryListByParam(department);
    }

    @Override
    public List<Department> queryListByMap(Map<String, Object> map) {
        return null;
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

    @Override
    public int insertSelective(Department department) {
        return 0;
    }

    @Override
    public int update(Department department) {
        if(department.getId() == null ){
            return 0;
        }
        return departmentDao.update(department);
    }

    @Override
    public int updateSelective(Department department) {
        return 0;
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return departmentDao.deleteBatch(ids);
    }

    @Override
    public List<Department> findParentNameByUserId(Long userId) {
        return departmentDao.findParentNameByUserId(userId);
    }

    /**
     * YanXiaoLu
     * 根据登录用户查询父级部门名称
     * @param userId
     * @return
     */


}
