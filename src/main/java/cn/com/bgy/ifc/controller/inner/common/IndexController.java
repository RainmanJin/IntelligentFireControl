package cn.com.bgy.ifc.controller.inner.common;

import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:系统主面板加载
 * @date: 2019-01-26 18:06
 **/
@RestController
@RequestMapping("/main/index/")
public class IndexController extends BaseController{

    /**
     * @author: ZhangCheng
     * @description:获取顶部系统菜单
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findTopMenuByUser")
    public ResponseVO<Object> findTopMenuByUser(){
        Account user = this.getUser();
        user.getHasRole();
        return null;
    }
}
