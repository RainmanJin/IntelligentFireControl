package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.SystemOrganizationVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOrganizationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: YanXiaoLu
 * @description:机构信息
 * @date: 2018-12-05 09:30
 **/
@RestController
@RequestMapping("/system/systemOrganization")
public class SystemOrganizationController extends BaseController {

    @Autowired
    private SystemOrganizationService systemOrganizationService;

    /**
     * @author: ZhangCheng
     * @description:机构分页查询
     * @param: [page, keywords]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo                                                               <                                                               cn.com.bgy.ifc.entity.po.system.SystemOrganization>>
     */
    @GetMapping("queryPage")
    public ResponseVO<PageInfo<SystemOrganization>> searchPage(Page<SystemOrganization> page, String keywords) {
        PageInfo<SystemOrganization> pageInfo = systemOrganizationService.queryListByPage(page, keywords);
        return ResponseVO.<PageInfo<SystemOrganization>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:机构查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        SystemOrganization systemOrganization = systemOrganizationService.findById(id);
        return ResponseVO.success().setData(systemOrganization);
    }

    /**
     * @author: ZhangCheng
     * @description:添加机构信息
     * @param: [systemOrganizationVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "添加机构信息")
    public ResponseVO<Object> add(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemOrganization systemOrganization = new SystemOrganization();
        CopyUtil.copyProperties(systemOrganizationVo, systemOrganization);
        int result = systemOrganizationService.insertSelective(systemOrganization);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:修改机构信息
     * @param: [systemOrganizationVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(description = "修改机构信息")
    public ResponseVO<Object> edit(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemOrganization systemOrganization = new SystemOrganization();
        CopyUtil.copyProperties(systemOrganizationVo, systemOrganization);
        int result = systemOrganizationService.updateSelective(systemOrganization);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:机构管理启用操作
     * @param: [systemOrganizationVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("forbidden")
    @SystemLogAfterSave(description = "机构管理启用操作")
    public ResponseVO<Object> forbidden(SystemOrganizationVo systemOrganizationVo) {
        SystemOrganization systemOrganization = new SystemOrganization();
        CopyUtil.copyProperties(systemOrganizationVo, systemOrganization);
        int result = systemOrganizationService.updateSelective(systemOrganization);
        if (result == 1) {
            return ResponseVO.success().setMsg("操作成功");
        }
        return ResponseVO.error().setMsg("操作失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:删除机构信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteBatch")
    @SystemLogAfterSave(type = SystemLogType.OPERATION_LOG, description = "删除机构信息")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = systemOrganizationService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:获取机构管理员
     * @param: [orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("getOrgAdmin")
    public ResponseVO<Object> getOrgAdmin(Long orgId) {
        List<SelectVo> list = systemOrganizationService.getOrgAdmin("orgAdmin", orgId);
        return ResponseVO.success().setData(list);
    }
}
