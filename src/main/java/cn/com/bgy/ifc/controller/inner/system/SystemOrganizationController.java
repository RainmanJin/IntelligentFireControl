package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemOrganizationVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOrganizationService;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: YanXiaoLu
 * @description:机构信息
 * @date: 2018-12-05 09:30
 **/
@Controller
@RequestMapping("/basic/systemOrganization")
public class SystemOrganizationController {


    @Autowired
    private SystemOrganizationDomain systemOrganizationDomain;

    @Autowired
    private SystemOrganizationService systemOrganizationService;

    /**
     * @author: ZhangCheng
     * @description:机构分页查询
     * @param: [page, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo < cn.com.bgy.ifc.entity.po.system.SystemOrganization>>
     */
    @GetMapping("searchPage")
    @SystemLogAfterSave(type = 1, description = "分页查询机构")
    @ResponseBody
    public ResponseVO<PageInfo<SystemOrganization>> searchPage(Page<SystemOrganization> page, String token) {
        SystemOrganization systemOrganization = new SystemOrganization();
        PageInfo<SystemOrganization> pageInfo = systemOrganizationDomain.searchByWhere(page, systemOrganization);
        return ResponseVO.<PageInfo<SystemOrganization>>success().setData(pageInfo);
    }

    @GetMapping("findById")
    @SystemLogAfterSave(type = 1, description = "通过id查询机构")
    @ResponseBody
    public ResponseVO<Object> findById(Long id) {
        if (id == null) {
            return ResponseVO.error().setMsg("id不能为空");
        }
        SystemOrganization systemOrganization = systemOrganizationService.findById(id);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(systemOrganization);
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setMsg("success");
        return responseVO.setData(systemOrganization);
    }

    /**
     * @author: ZhangCheng
     * @description:添加机构信息
     * @param: [systemOrganizationVo, error, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1, description = "添加机构信息")
    @ResponseBody
    public ResponseVO<Object> add(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemOrganization systemOrganization = new SystemOrganization();
        CopyUtil.copyProperties(systemOrganizationVo, systemOrganization);
        int result=systemOrganizationService.insertSelective(systemOrganization);
        if(result==1){
            return ResponseVO.addSuccess();
        }else{
            return ResponseVO.addError();
        }
    }
    
    /**
     * @author: ZhangCheng
     * @description:修改机构信息
     * @param: [systemOrganizationVo, error, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(type = 1, description = "修改机构信息")
    @ResponseBody
    public ResponseVO<Object> edit(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error, String token) {
            //做参数校检
            if (error.hasErrors()) {
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemOrganization systemOrganization = new SystemOrganization();
            CopyUtil.copyProperties(systemOrganizationVo, systemOrganization);
            int result=systemOrganizationService.updateSelective(systemOrganization);
            if(result==1){
                return ResponseVO.editSuccess();
            }else{
                return ResponseVO.editError();
            }
    }

    /**
     * @author: ZhangCheng
     * @description:删除机构信息
     * @param: [ids, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteBatch")
    @SystemLogAfterSave(type = 1, description = "删除机构信息")
    @ResponseBody
    public ResponseVO<Object> deleteSystemOrganization(String ids, String token) {
        if (ids.length()==0) {
            return ResponseVO.deleteError();
        }
        List<Long> list=ListUtil.getListId(ids);
        int resultCount=systemOrganizationService.deleteBatch(list);
        if (resultCount==list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }
}
