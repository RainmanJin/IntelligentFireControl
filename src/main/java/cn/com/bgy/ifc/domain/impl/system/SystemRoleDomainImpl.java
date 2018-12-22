package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.SystemRoleDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统角色
 * @date: 2018-12-05 11:00
 **/
@Service
public class SystemRoleDomainImpl  implements SystemRoleDomain {

    @Resource
    private SystemRoleDao systemRoleDao;

    @Override
    public SystemRole findById(Long id) {
        return systemRoleDao.findById(id);
    }
    /**
     * @Author huxin
     * @Description 查询系统角色（条件查询）
     * @Date 2018/12/17 14:43
     */
    @SuppressWarnings("UnusedAssignment")
    @Override
    public PageInfo<SystemRole> queryListByPage( Page<SystemRole> page, SystemRoleVo systemRoleVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemRole> list= systemRoleDao.queryAllList(systemRoleVo);
        return  new PageInfo<SystemRole>(list);
    }

    @Override
    public List<SystemRole> queryListByParam(SystemRole record) {
        return systemRoleDao.queryListByParam(record);
    }
    /**
     * @Author huxin
     * @Description 添加系统角色
     * @Date 2018/12/17 14:39
     */
    @Transactional
    @Override
    public int insert(SystemRole record) {
        record.setLogicRemove(true);
        record.setOrganizationId(1L);
        record.setState(0);
        return systemRoleDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改系统角色
     * @Date 2018/12/17 14:40
     */
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
    /**
     * @Author yanXiaoLu
     * @Description 批量删除系统角色
     * @Date 2018/12/17 14:40
     */
    @Override
    public void deleteRole(Long[] longs) {
        systemRoleDao.deleteRole(longs);
    }

    /**
     * 根据登录用户查询系统角色（下拉展示）
     * @param userId
     * @return
     */
    @Override
    public List<SystemRole> queryListByUserId(Long userId) {
        return systemRoleDao.queryListByUserId(userId);
    }


}
