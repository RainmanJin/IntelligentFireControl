package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.DbAgent;
import cn.com.bgy.ifc.dao.system.SystemMenuDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author huxin
 * @Date 2018/12/5 10:27
 * @Description 系统菜单Service层
 **/
@Service
public class SystemMenuDomainImpl implements SystemMenuDomain {
    @Resource
    SystemMenuDao systemMenuDao;

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

   /**
    * @author: ZhangCheng
    * @description:系统菜单转换
    * @param: [page, keyWord]
    * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.vo.system.SystemMenuVo>
    */
    @Override
    public PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord){
        List<SystemMenu> allMenu= systemMenuDao.queryAllSystemMenuInfo(keyWord);
        List<SystemMenuVo> resultMenu=new ArrayList<>();
        for (SystemMenu all : allMenu) {
            //表示该节点为父节点
            if(all.getParentId()==null||all.getParentId().equals("")){
                SystemMenuVo systemMenuVo=new SystemMenuVo();
                CopyUtil.copyProperties(all, systemMenuVo);
                systemMenuVo.setOneLabelName(all.getName());
                systemMenuVo.setPowerName("["+all.getName()+"]");
                resultMenu.add(systemMenuVo);
                //获取该节点的所有子节点
                for (SystemMenu twoNav : allMenu) {
                    if (twoNav.getParentId() != null && twoNav.getParentId().longValue() == all.getId().longValue()) {
                        SystemMenuVo vo = new SystemMenuVo();
                        CopyUtil.copyProperties(twoNav, vo);
                        vo.setPowerName("["+all.getName()+"]" + "[" + twoNav.getPowerName() + "]");
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
                    systemMenuVo.setPowerName("[" + all.getPowerName() + "]");
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
     * 获取子节点
     * @param id 父节点id
     * @param allMenu 所有菜单列表
     * @return 每个根节点下，所有子菜单列表
     */
    public List<SystemMenu> getChild(Long id,List<SystemMenu> allMenu){
        //子菜单
        List<SystemMenu> childList = new ArrayList<SystemMenu>();
        for (SystemMenu nav : allMenu) {
            // 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较
            //相等说明：为该根节点的子节点。
            if(id .equals(nav.getParentId())){
                childList.add(nav);
            }
        }
        //递归
        for (SystemMenu nav : childList) {
            nav.setChildren(getChild(nav.getId(), allMenu));
        }
        Collections.sort(childList,order());//排序
        //如果节点下没有子节点，返回一个空List（递归退出）
        if(childList.size() == 0){
            return new ArrayList<SystemMenu>();
        }
        return childList;
    }
    /*
     * 排序,根据order排序
     */
    public Comparator<SystemMenu> order(){
        Comparator<SystemMenu> comparator = new Comparator<SystemMenu>() {
            @Override
            public int compare(SystemMenu o1, SystemMenu o2) {
                if( !o1.getSortIndex().equals(o2.getSortIndex())){
                    return o1.getSortIndex() - o2.getSortIndex();
                }
                return 0;
            }
        };
        return comparator;
    }

    /**
     * chenlie
     * 根据父级菜单和用户id查询菜单
     * @param type
     * @param userId
     * @return
     */
    @Override
    public List<SystemMenu> findMenuTreeByType(int type , Long userId){
        try {//查询所有菜单
            List<SystemMenu> allMenu = systemMenuDao.findMenuListByType(type,userId);
            //根节点
            List<SystemMenu> rootMenu = new ArrayList<SystemMenu>();
            for (SystemMenu nav : allMenu) {
                if(nav.getParentId() ==null ){//父节点是空的，为根节点。
                    rootMenu.add(nav);
                }
            }
            /* 根据Menu类的order排序 */
            Collections.sort(rootMenu, order());
            //为根菜单设置子菜单，getClild是递归调用的
            for (SystemMenu nav : rootMenu) {
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<SystemMenu> childList = getChild(nav.getId(), allMenu);
                nav.setChildren(childList);//给根节点设置子节点
            }
            return rootMenu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
