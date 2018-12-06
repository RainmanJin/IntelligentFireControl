package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemMenuDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @Author huxin
 * @Date 2018/12/5 9:52
 * @Description  系统主页面菜单
 **/
@Controller
@RequestMapping(value = "/basic/system")
public class SystemMenuController {
    @Autowired
    SystemMenuDomain systemMenuDomain;

    /**
     * @Author huxin
     * @Description 查询所有系统一，二级菜单信息
     * @Date 2018/12/5 10:04 
     * @Param []
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     */
    @GetMapping(value = "/queryall")
    @ResponseBody
    public List<SystemMenu> queryAllSystemMenuInfo(){
        return systemMenuDomain.queryAllSystemMenuInfo();
    }
    /**
     * @Author huxin
     * @Description 根据ID查询系统菜单 单条信息
     * @Date 2018/12/5 18:04
     * @Param [id]
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     */
    @GetMapping(value = "/queryone")
    public SystemMenu queryOnelSystemMenuInfo(Long id){
        return systemMenuDomain.queryOneSystemMenuInfo(1L);
    }
    public List<SystemMenu> queryKeyWordSystemMenuInfo(String keyWord){
        return systemMenuDomain.queryKeyWordSystemMenuInfo(keyWord);
    }
    /**
     * @Author huxin
     * @Description 增加系统二级菜单
     * @Date 2018/12/5 10:06 
     * @Param [systemMenu]
     * @return void
     */
    @GetMapping(value = "/add")
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
    @GetMapping(value = "/update")
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
    @GetMapping(value = "/deleteone")
    @ResponseBody
    public ResponseVO deleteSystemMenuInfo(Long id){
        return systemMenuDomain.deleteSystemMenuInfo(1L);
    }
   /**
    * @Author huxin
    * @Description 根据ID批量删除菜单，包括一二级菜单
    * @Date 2018/12/5 18:34
    * @Param [list]
    * @return cn.com.bgy.ifc.entity.vo.ResponseVO
    */
    @GetMapping(value = "/deletelist")
    @ResponseBody
    public ResponseVO deleteListSystemMenuInfo( Long[] id){
        return systemMenuDomain.deleteListSystemMenuInfo(id);
    }
}
