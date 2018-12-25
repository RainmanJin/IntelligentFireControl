package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.domain.interfaces.system.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @Author huxin
 * @Date 2018/12/5 9:52
 * @Description  系统主页面菜单
 **/
@Controller
@RequestMapping(value = "/sys/menu")
public class SystemMenuController {
    @Autowired
    SystemMenuDomain systemMenuDomain;

    /**
     * @Author huxin
     * @Description 分页查询所有菜单信息
     * @Date 2018/12/5 10:04 
     * @Param []
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     */
    @GetMapping(value = "/queryAllSystemMenuInfo")
    @ResponseBody
    public ResponseVO<Object> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord){
        try {
            PageInfo<SystemMenuVo> pageInfo = systemMenuDomain.queryAllSystemMenuInfo(page,keyWord);
            return ResponseVO.success().setData(pageInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseVO.error();
    }
    /**
     * @Author huxin
     * @Description 根据ID查询系统菜单 单条信息
     * @Date 2018/12/5 18:04
     * @Param [id]
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     */
    @GetMapping(value = "/queryOnelSystemMenuInfo")
    @ResponseBody
    public SystemMenu queryOnelSystemMenuInfo(Long id){
        return systemMenuDomain.queryOneSystemMenuInfo(1L);
    }

    /**
     * @Author huxin
     * @Description 增加系统二级菜单
     * @Date 2018/12/5 10:06 
     * @Param [systemMenu]
     * @return void
     */
    @PostMapping(value = "/add")
    @ResponseBody
    public ResponseVO addSystemMenuInfo( SystemMenu systemMenu){

        return systemMenuDomain.addSystemMenuInfo(systemMenu);

    }
    /**
     * @Author huxin
     * @Description 根据ID修改系统二级菜单信息
     * @Date 2018/12/5 10:09
     * @Param [systemMenu]
     * @return void
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public ResponseVO updateSystemMenuInfo(SystemMenu systemMenu){
        return systemMenuDomain.updateSystemMenuInfo(systemMenu);
    }
    /**
     * @Author huxin
     * @Description 根据ID删除一条二级菜单信息
     * @Date 2018/12/5 10:11
     * @Param [id]
     * @return void
     */
    @PostMapping(value = "/deteleOne")
    @ResponseBody
    public ResponseVO deleteSystemMenuInfo(Long id){
        return systemMenuDomain.deleteSystemMenuInfo(id);
    }
   /**
    * @Author huxin
    * @Description 根据ID批量删除菜单，包括一二级菜单
    * @Date 2018/12/5 18:34
    * @Param [list]
    * @return cn.com.bgy.ifc.entity.vo.ResponseVO
    */
    @GetMapping(value = "/deleteList")
    @ResponseBody
    public ResponseVO deleteListSystemMenuInfo( Long[] id){
        return systemMenuDomain.deleteListSystemMenuInfo(id);
    }

    /**
     * @Author huxin
     * @Description 根据用户id和父级菜单id获取子级菜单
     * @Date 2018/12/5 18:34
     * @Param [list]
     * @return cn.com.bgy.ifc.entity.vo.ResponseVO
     *//*
    @GetMapping(value = "/findMenuByUserAndParentId")
    @ResponseBody
    public ResponseVO<Object> findMenuByUserAndParentId( Long parentId,Long userId){
        try {


        return ResponseVO.success().setData(systemMenuDomain.findMenuByUserAndParentId(parentId,userId));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }*/
    /**
     * @Author chenlie
     * @Description根据上级菜单获取二三级菜单
     * @Date 2018/12/5 18:34
     * @Param [list]
     * @return cn.com.bgy.ifc.entity.vo.ResponseVO
     */
    @GetMapping(value = "/findMenuTreeByType")
    @ResponseBody
    public ResponseVO<Object> findMenuTreeByType(int type){
        Account user= (Account)SecurityUtils.getSubject().getSession().getAttribute("user");

        return ResponseVO.success().setData(systemMenuDomain.findMenuTreeByType(type,user.getId()));
    }

    /**
     * @Author huxin
     * @Description 树级结构获取所有菜单信息
     * @Date 2018/12/5 10:04
     * @Param []
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     *//*
    @GetMapping(value = "/findTree")
    @ResponseBody
    public ResponseVO<Object> findTree(Account account){
        try {
            account=new Account();
            account.setId(1L);
            Map<String,Object> map = systemMenuDomain.findTree(account.getId());
            return ResponseVO.success().setData(map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseVO.error();
    }*/
}
