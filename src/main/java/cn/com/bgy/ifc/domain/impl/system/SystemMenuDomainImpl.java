package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.dao.system.SystemMenuDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    @Resource
    SystemMenuDao systemMenuDao;
    //<editor-fold desc="Description">
    /**
     * @Author huxin
     * @Description 分页查询所有菜单信息
     * @Date 2018/12/5 10:04
     * @Param []
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     */
    public PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord){

        List<SystemMenu> allMenu= systemMenuDao.queryAllSystemMenuInfo(keyWord);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemMenu> pageMenu= systemMenuDao.queryAllSystemMenuInfo(keyWord);
        List<SystemMenu> rootMenu=new ArrayList<>();
        List<SystemMenu> twoMenu=new ArrayList<>();
        List<SystemMenuVo> resultMenu=new ArrayList<>();
        for (SystemMenu nav : allMenu) {
            if(nav.getParentId()==null||nav.getParentId().equals("")){//父节点是空的，为根节点。
                nav.setPowerName("["+nav.getPowerName()+"]");
                rootMenu.add(nav);
            }
        }
        for (SystemMenu nav : rootMenu) {
            SystemMenuVo vo=new SystemMenuVo();
            CopyUtil.copyProperties(nav,vo);
            vo.setOneLabelName(nav.getName());
            resultMenu.add(vo);
            for (SystemMenu twonav : allMenu) {
                if(twonav.getParentId()!=null &&twonav.getParentId().longValue()==nav.getId().longValue()){
                        twonav.setPowerName(nav.getPowerName()+"["+twonav.getPowerName()+"]");
                        vo=new SystemMenuVo();
                        CopyUtil.copyProperties(twonav,vo);
                        vo.setTwoLabelName(twonav.getName());
                        resultMenu.add(vo);
                        /*for (SystemMenu threenav : allMenu) {
                            if(threenav.getParentId() !=null &&threenav.getParentId().longValue()==twonav.getId().longValue()){
                                vo=new SystemMenuVo();
                                CopyUtil.copyProperties(threenav,vo);
                                vo.setTreeLabelName(threenav.getName());
                                vo.setPowerName(twonav.getPowerName()+"["+threenav.getPowerName()+"]");
                                resultMenu.add(vo);

                        }
                    }*/
                }

            }
        }

        page.setEndRow(page.getPageNum()*page.getPageSize()>page.getTotal()?
                (int)page.getTotal():(int)(page.getPageNum())*page.getPageSize());

        PageInfo<SystemMenuVo> pageInfo=new PageInfo<SystemMenuVo>(resultMenu.subList(page.getStartRow(),page.getEndRow()));
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPageSize(page.getPageSize());
        pageInfo.setPageNum(page.getPageNum());
        return pageInfo ;
    }
    //</editor-fold>
    /**
     * @Author huxin
     * @Description 根据ID查询系统菜单 单条信息
     * @Date 2018/12/5 17:00
     * @Param []
     * @return java.util.List<cn.com.bgy.ifc.entity.po.basic.SystemMenu>
     */
    public SystemMenu queryOneSystemMenuInfo(Long id){
        return systemMenuDao.queryOneSystemMenuInfo(id);
    }

    /**
     * @Author huxin
     * @Description 增加菜单,包括一二级菜单
     * @Date 2018/12/5 10:06
     * @Param [systemMenu]
     * @return void
     */
    public ResponseVO addSystemMenuInfo(SystemMenu systemMenu){
        int i =systemMenuDao.addSystemMenuInfo(systemMenu);
        if(i>0){
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.success().setMsg("添加失败");
    }
    /**
     * @Author huxin
     * @Description 根据ID修改菜单，包括一二级信息
     * @Date 2018/12/5 10:09
     * @Param [systemMenu]
     * @return void
     */
    public ResponseVO updateSystemMenuInfo(SystemMenu systemMenu){
        int i =systemMenuDao.updateSystemMenuInfo(systemMenu);
        if(i>0){
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.success().setMsg("修改失败");
    }
    /**
     * @Author huxin
     * @Description 根据ID删除一条菜单，包括一二级菜单
     * @Date 2018/12/5 10:11
     * @Param [id]
     * @return void
     */
    public ResponseVO deleteSystemMenuInfo(Long id){
        int i =systemMenuDao.deleteSystemMenuInfo(id);
        if(i>0){
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.success().setMsg("删除失败");
    }
    /**
     * @Author huxin
     * @Description 根据ID批量删除菜单，包括一二级菜单
     * @Date 2018/12/5 10:13
     * @Param [id]
     * @return void
     */
    public ResponseVO deleteListSystemMenuInfo(Long[] id){
        id = new Long[]{1L,2l,5L};
        int i =systemMenuDao.deleteListSystemMenuInfo(id);
        if(i==id.length){
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.success().setMsg("删除失败");
    }

    /**
     * 根据用户id查询所有权限菜单
     * @param userId
     * @return
     */
    @Override
    public List<SystemMenu> findMenuListByType(int type,Long userId) {
        return systemMenuDao.findMenuListByType(type,userId);
    }

    /**
     * 根据用户id查询所有菜单树
     * @param userId
     * @return
     */
    public Map<String,Object> findTree(int type,Long userId){
        Map<String,Object> data = new HashMap<String,Object>();
        try {//查询所有菜单
            List<SystemMenu> allMenu = systemMenuDao.findMenuListByType(type,userId);
            //根节点
            List<SystemMenu> rootMenu = new ArrayList<SystemMenu>();
            for (SystemMenu nav : allMenu) {
                if(nav.getParentId()==null){//父节点是空的，为根节点。
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
            /**
             * 输出构建好的菜单数据。
             *
             */
            data.put("success", "true");
            data.put("list", rootMenu);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            data.put("success", "false");
            data.put("list", new ArrayList<>());
            return data;
        }
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
                if(o1.getSortIndex() != o2.getSortIndex()){
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
        Map<String,Object> data = new HashMap<String,Object>();
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
