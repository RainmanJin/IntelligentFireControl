package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.DbAgent;
import cn.com.bgy.ifc.dao.system.SystemMenuDao;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
        List<SystemMenu> allMenu= systemMenuDao.queryAllSystemMenuInfo(keyWord);
        List<SystemMenuVo> resultMenu=new ArrayList<>();
        for (SystemMenu all : allMenu) {
            //表示该节点为父节点
            if(all.getParentId()==null||"".equals(all.getParentId())){
                SystemMenuVo systemMenuVo=new SystemMenuVo();
                CopyUtil.copyProperties(all, systemMenuVo);
                systemMenuVo.setOneLabelName(all.getName());
                resultMenu.add(systemMenuVo);
                //获取该节点的所有子节点
                for (SystemMenu twoNav : allMenu) {
                    if (twoNav.getParentId() != null && twoNav.getParentId().longValue() == all.getId().longValue()) {
                        SystemMenuVo vo = new SystemMenuVo();
                        CopyUtil.copyProperties(twoNav, vo);
                        vo.setTwoLabelName(twoNav.getName());
                        resultMenu.add(vo);
                    }
                }
            }
            //如果为子节点,且该节点的父节点不存在
            if (all.getParentId() != null){
                boolean bool=hasParentMenu(allMenu,all.getParentId());
                //且子节点的父节点 未查询到结果集中 或者已删除
                if(!bool){
                    SystemMenuVo systemMenuVo=new SystemMenuVo();
                    CopyUtil.copyProperties(all, systemMenuVo);
                    systemMenuVo.setTwoLabelName(all.getName());
                    resultMenu.add(systemMenuVo);
                }
            }
        }
        //根据查询出所有数据进行分页
        int nowPage=page.getPageNum();
        int recordCount=allMenu.size();
        int pageSize=page.getPageSize();
        PageInfo pageInfo= DbAgent.getPages(recordCount, pageSize, nowPage);
        //分页结果集
        List<SystemMenuVo> newList= DbAgent.memoryPaging(resultMenu,pageInfo);
        pageInfo.setList(newList);
        return pageInfo;
    }

    /**
     * 判断菜单的父节点是否存在
     * @param allMenu
     * @param parentId
     * @return false 不存在 true 存在
     */
    private boolean hasParentMenu(List<SystemMenu> allMenu,Long parentId){
        boolean bool=false;
        for (SystemMenu all : allMenu) {
            if(parentId.equals(all.getId())){
                bool=true;
                break;
            }
        }
        return bool;
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

    @Override
    public List<SystemMenu> queryRolePermission(Long roleId) {
        return systemMenuDao.queryRolePermission(roleId);
    }

    @Override
    public List<SystemMenu> queryTopMenuByRole(Long roleId) {
        SystemMenu systemMenu=new SystemMenu();
        systemMenu.setRoleId(roleId);
        List<SystemMenu> list=systemMenuDao.queryMenuPermission(systemMenu);
        List<SystemMenu> newList=new ArrayList<>();
        for (SystemConstant.SystemMenuType systemMenuType : SystemConstant.SystemMenuType.values()) {
            int type=systemMenuType.getValue();
            String name=systemMenuType.getName();
            boolean multilevel=systemMenuType.getMultilevel();
            //为true，不为多级菜单
            if(multilevel){
                boolean hasMenu=false;
                for(SystemMenu menu:list) {
                    if (menu.getParentId() == null || "".equals(menu.getParentId())) {
                        if(menu.getType()==type){
                            hasMenu=true;
                        }
                    }
                }
                //如果拥有菜单权限
                if(hasMenu){
                    SystemMenu menu=new SystemMenu();
                    menu.setType(type);
                    menu.setName(name);
                    newList.add(menu);
                }
            }
            //如果为多级菜单
            if(!multilevel){
                boolean hasMenu=false;
                String navigateUrl="";
                for(SystemMenu menu:list) {
                    if (menu.getParentId() == null || "".equals(menu.getParentId())) {
                        //只装第一个上级菜单的菜单地址
                        if(menu.getType()==type){
                            //获取该节点的所有子节点
                            List<String> childStr=new ArrayList<>();
                            for (SystemMenu child : list) {
                                if (child.getParentId() != null && child.getParentId().longValue() == menu.getId().longValue()) {
                                    childStr.add(child.getNavigateUrl());
                                }
                            }
                            if(childStr.size()>0){
                                navigateUrl=childStr.get(0);
                                hasMenu=true;
                            }
                        }
                    }
                }
                //如果拥有菜单权限,添加菜单地址
                if(hasMenu){
                    SystemMenu menu=new SystemMenu();
                    menu.setType(type);
                    menu.setName(name);
                    menu.setNavigateUrl(navigateUrl);
                    newList.add(menu);
                }
            }
        }
        return newList;
    }

    @Override
    public List<SystemMenu> queryMenuPermissionByRole(Long roleId) {
        SystemMenu systemMenu=new SystemMenu();
        systemMenu.setRoleId(roleId);
        return systemMenuDao.queryMenuPermission(systemMenu);
    }

    @Override
    public List<SystemMenu> queryMenuTree(Integer type, Long roleId) {
        SystemMenu systemMenu=new SystemMenu();
        systemMenu.setType(type);
        systemMenu.setRoleId(roleId);
        List<SystemMenu> list=systemMenuDao.queryMenuPermission(systemMenu);
        List<SystemMenu> newList=new ArrayList<>();
        for(SystemMenu menu:list){
            //表示该节点为父节点
            if(menu.getParentId()==null||"".equals(menu.getParentId())){
                //获取该节点的所有子节点
                List<SystemMenu> childList=new ArrayList<>();
                for (SystemMenu child : list) {
                    if (child.getParentId() != null && child.getParentId().longValue() == menu.getId().longValue()) {
                        childList.add(child);
                    }
                }
                if(childList.size()>0){
                    menu.setChildren(childList);
                }
                newList.add(menu);
            }
        }
        return newList;
    }

    @Override
    public List<SystemMenu> queryMenuPermission(SystemMenu systemMenu) {
        return systemMenuDao.queryMenuPermission(systemMenu);
    }
}
