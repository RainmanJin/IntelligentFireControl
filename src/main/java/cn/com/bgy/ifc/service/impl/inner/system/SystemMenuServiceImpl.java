package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.SystemMenuDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统菜单
 * @date: 2018-12-28 09:47
 **/
@Service
public class SystemMenuServiceImpl implements SystemMenuService {

    @Resource
    private SystemMenuDao systemMenuDao;

    @Autowired
    private SystemMenuDomain systemMenuDomain;

    @Override
    public SystemMenu findById(Long id) {
        return systemMenuDao.findById(id);
    }

    @Override
    public int insert(SystemMenu systemMenu) {
        systemMenu.setLogicRemove(false);
        return systemMenuDao.insert(systemMenu);
    }

    @Override
    public int insertSelective(SystemMenu systemMenu) {
        systemMenu.setLogicRemove(false);
        return systemMenuDao.insertSelective(systemMenu);
    }

    @Override
    public int update(SystemMenu systemMenu) {
        return systemMenuDao.update(systemMenu);
    }

    @Override
    public int updateSelective(SystemMenu systemMenu) {
        return systemMenuDao.updateSelective(systemMenu);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return systemMenuDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord) {
        return systemMenuDomain.queryAllSystemMenuInfo(page,keyWord);
    }

    @Override
    public List<SystemMenu> findMenuTreeByType(int type, Long userId) {
        return systemMenuDomain.findMenuTreeByType(type,userId);
    }

    @Override
    public List<SystemMenu> queryListByParam(SystemMenu systemMenu) {
        return systemMenuDao.queryListByParam(systemMenu);
    }

    @Override
    public List<SelectVo> getParentMenu() {
        List<SelectVo> selectVos=new ArrayList<>();
        List<SystemMenu> list= systemMenuDao.queryParentMenu();
        for(SystemMenu systemMenu:list){
            SelectVo selectVo=new SelectVo();
            selectVo.setValue(String.valueOf(systemMenu.getId()));
            selectVo.setName(systemMenu.getName());
            selectVos.add(selectVo);
        }
        return selectVos;
    }
}
