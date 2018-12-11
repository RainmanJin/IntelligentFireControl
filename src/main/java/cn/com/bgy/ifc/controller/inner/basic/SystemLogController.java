package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.SystemLogDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/7 10:13
 * @Description  系统日志查询
 **/
@Controller
@RequestMapping(value = "/basic/systemLog")
public class SystemLogController {

    @Autowired
    SystemLogDomain systemLogDomain;
    /**
     * @Author huxin
     * @Description 系统日志查询及分页
     * @Date 2018/12/7 10:14
     */
    @GetMapping("/query")
    public ResponseVO<PageInfo<SystemOperationLog>> querySystemLogInfo( Page<SystemOperationLog> page){
        PageInfo<SystemOperationLog> pageInfo = systemLogDomain.querySystemLogInfo(page);
        return ResponseVO.<PageInfo<SystemOperationLog>>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 多条件查询日志及分页
     * @Date 2018/12/7 10:16
     */
    @GetMapping("/queryRequirement")
    public ResponseVO<PageInfo<SystemOperationLog>> queryRequirementSytemLogInfo( Page<SystemOperationLog> page, Map<String,String> map){
        PageInfo<SystemOperationLog> pageInfo = systemLogDomain.queryRequirementSytemLogInfo(page,map);
        return ResponseVO.<PageInfo<SystemOperationLog>>success().setData(pageInfo);
    }
}
