package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.SystemOperationLogVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统日志查询
 */
@RestController
@RequestMapping(value = "/basic/systemLog")
public class SystemLogController extends BaseController {

    @Autowired
    private SystemOperationLogService systemOperationLogService;

    /**
     * @author: ZhangCheng
     * @description:系统日志分页查询
     * @param: [page, systemOperationLogVo, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo   <   cn.com.bgy.ifc.entity.po.system.SystemOperationLog>>
     */
    @GetMapping("queryPage")
    public ResponseVO<PageInfo<SystemOperationLog>> queryPage(Page<SystemOperationLog> page, SystemOperationLogVo systemOperationLogVo) {
        PageInfo<SystemOperationLog> pageInfo = systemOperationLogService.queryListByParam(page, systemOperationLogVo);
        return ResponseVO.<PageInfo<SystemOperationLog>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:获取日志类型枚举
     * @param: [token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getLogType")
    public ResponseVO<Object> getLogType() {
        List<SelectVo> list = SystemLogType.getSelectList();
        return ResponseVO.success().setData(list);
    }
}
