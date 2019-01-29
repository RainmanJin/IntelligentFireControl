package cn.com.bgy.ifc.controller.inner.common;

import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统主面板加载
 * @date: 2019-01-26 18:06
 **/
@RestController
@RequestMapping("/main/index/")
public class IndexController extends BaseController{

    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * @author: ZhangCheng
     * @description:获取顶部系统菜单
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("queryTopMenuByUserRole")
    public ResponseVO<Object> queryTopMenuByUserRole(){
        Account user = this.getUser();
        List<SystemMenu> list=systemMenuService.queryTopMenuByRole(user.getRoleId());
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description: 根据人员角色及所属模块查询菜单树
     * @param: [type]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("queryMenuTree")
    public ResponseVO<Object>  queryMenuTree(Integer type){
        Account user = this.getUser();
        List<SystemMenu> list=systemMenuService.queryMenuTree(type,user.getRoleId());
        return ResponseVO.success().setData(list);
    }
}
