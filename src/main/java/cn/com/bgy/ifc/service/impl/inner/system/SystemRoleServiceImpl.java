package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.SystemRoleDao;
import cn.com.bgy.ifc.dao.system.SystemRoleMenuDao;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.po.system.SystemRoleMenu;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemRoleService;
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
 * @date: 2018-12-26 17:58
 **/
@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Resource
    private SystemRoleDao systemRoleDao;

    @Resource
    private SystemRoleMenuDao systemRoleMenuDao;

    @Override
    public SystemRole findById(Long id) {
        return systemRoleDao.findById(id);
    }

    @Override
    public int insert(SystemRole systemRole) {
        systemRole.setLogicRemove(false);
        return systemRoleDao.insert(systemRole);
    }

    @Override
    public int insertSelective(SystemRole systemRole) {
        systemRole.setLogicRemove(false);
        return systemRoleDao.insertSelective(systemRole);
    }

    @Override
    public int update(SystemRole systemRole) {
        return systemRoleDao.update(systemRole);
    }

    @Override
    public int updateSelective(SystemRole systemRole) {
        return systemRoleDao.updateSelective(systemRole);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return systemRoleDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<SystemRole> queryListByPage(Page<SystemRole> page, SystemRoleVo systemRoleVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemRole> list= systemRoleDao.queryAllList(systemRoleVo);
        return  new PageInfo<SystemRole>(list);
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public int insertRoleMenu(Long roleId,List<SystemMenu> list) {
        systemRoleMenuDao.deleteRoleMenu(roleId);
        List<SystemRoleMenu> roleMenuList=new ArrayList<>();
        for(SystemMenu menu: list){
                SystemRoleMenu roleMenu=new SystemRoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menu.getId());
                roleMenuList.add(roleMenu);
        }
        int result=systemRoleMenuDao.insertList(roleMenuList);
        if(result==roleMenuList.size()){
            return 1;
        }else{
            throw new RuntimeException("角色权限配置失败!");
        }
    }
}
