package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
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
public class SystemOrganizationController {

    @Autowired
    private SystemOrganizationService systemOrganizationService;

    /**
     * @author: ZhangCheng
     * @description:机构分页查询
     * @param: [page, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo                               <                               cn.com.bgy.ifc.entity.po.system.SystemOrganization>>
     */
    @GetMapping("queryPage")
    public ResponseVO<PageInfo<SystemOrganization>> searchPage(Page<SystemOrganization> page, String keywords, String token) {
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
    @SystemLogAfterSave(type = 1, description = "添加机构信息")
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
    @SystemLogAfterSave(type = 1, description = "修改机构信息")
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
     * @description:删除机构信息
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1, description = "删除机构信息")
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
}
