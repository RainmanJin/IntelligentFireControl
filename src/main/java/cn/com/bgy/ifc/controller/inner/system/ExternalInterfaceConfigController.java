package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.ExternalInterfaceConfigVo;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:接入接口配置
 * @date: 2018-12-17 16:57
 **/
@Controller
@RequestMapping("/basic/interfaceConfig")
public class ExternalInterfaceConfigController {
    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;
    @Autowired
    private SystemOrganizationDomain systemOrganizationDomain;
    /**
     * 分页查询外部接口配置
     * @param externalInterfaceConfig
     * @return
     */
    @PostMapping("searchPage")
    @SystemLogAfterSave(type = 1,description = "分页查询外部接口配置")
    @ResponseBody
    public ResponseVO<PageInfo<ExternalInterfaceConfig>> searchPage(Page<ExternalInterfaceConfig> page, ExternalInterfaceConfig externalInterfaceConfig){

        PageInfo<ExternalInterfaceConfig> pageInfo=externalInterfaceConfigDomain.queryListByPage(page,externalInterfaceConfig);
        return ResponseVO.<PageInfo<ExternalInterfaceConfig>>success().setData(pageInfo);
    }
    /**
     * 批量删除外部接口配置/或者根据id删除外部接口配置
     * @param longs
     * @return
     */
    @PostMapping("deleteExternalInterfaceConfig")
    @SystemLogAfterSave(type = 1,description = "批量删除外部接口配置")
    @ResponseBody
    public ResponseVO<Object> deleteExternalInterfaceConfig(String longs) {
        if (longs==null){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(longs,Long.class);
        Long[] deleteLongs = new Long[list.size()];
        list.toArray(deleteLongs);
        if (list.size()==1){
            externalInterfaceConfigDomain.deleteById(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }else {
            externalInterfaceConfigDomain.deleteExternalInterfaceConfig(deleteLongs);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }
    }

    /**
     * YanXiaoLu
     * 根据当前登录用户id添加接入接口配置
     * @param externalInterfaceConfigVo
     * @param error
     * @return
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "接入接口配置添加")
    @ResponseBody
    public ResponseVO<Object> add(@Validated ExternalInterfaceConfigVo externalInterfaceConfigVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        if(externalInterfaceConfigVo.getUserId()==null){
            return ResponseVO.error().setMsg("userId参数异常");
        }
        //根据当前登录用户的id获取机构
        SystemOrganization systemOrganization=systemOrganizationDomain.querySystemOrganizationByUserId(externalInterfaceConfigVo.getUserId());
        if (systemOrganization==null){
            return ResponseVO.error().setMsg("当前登录用户没有所属机构");
        }
        ExternalInterfaceConfig externalInterfaceConfig = new ExternalInterfaceConfig();
        CopyUtil.copyProperties(externalInterfaceConfigVo,externalInterfaceConfig);
        externalInterfaceConfig.setOrgId(systemOrganization.getId());
        externalInterfaceConfig.setState(1);
        externalInterfaceConfig.setLogicRemove(false);
        int count = externalInterfaceConfigDomain.insert(externalInterfaceConfig);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功！");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }

}
