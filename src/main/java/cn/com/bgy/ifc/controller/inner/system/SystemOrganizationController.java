package cn.com.bgy.ifc.controller.inner.system;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemOrganizationVo;
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
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "添加机构信息")
    @ResponseBody
    public ResponseVO<Object> add(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error){
            //todo systemOrganizationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemOrganization systemOrganization= new SystemOrganization();
            CopyUtil.copyProperties(systemOrganizationVo,systemOrganization);
            systemOrganization.setCreateTime(new Date());
            systemOrganization.setLogicRemove(false);
            systemOrganizationDomain.insert(systemOrganization);
            return ResponseVO.success();
    }

    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "修改机构信息")
    @ResponseBody
    public ResponseVO<Object> update(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error){
        try {
            //todo informationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemOrganization systemOrganization = new SystemOrganization();
            CopyUtil.copyProperties(systemOrganizationVo,systemOrganization);
            systemOrganizationDomain.update(systemOrganization);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        systemOrganizationDomain.deleteById(id);
        return ResponseVO.success();
    }

    @GetMapping("findById")
    @SystemLogAfterSave(type = 1,description = "通过id查询机构")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        SystemOrganization systemOrganization = systemOrganizationDomain.findById(id);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(systemOrganization);
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setMsg("success");
        return responseVO.setData(systemOrganization);
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("searchPage")
    @SystemLogAfterSave(type = 1,description = "分页查询机构")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<SystemOrganization> page){
        SystemOrganization systemOrganization= new SystemOrganization();
        PageInfo<SystemOrganization> pageInfo=systemOrganizationDomain.searchByWhere(page,systemOrganization);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 批量删除
     * @param longs
     * @return
     */
    @PostMapping("deleteSystemOrganization")
    @SystemLogAfterSave(type = 1,description = "批量删除机构信息")
    @ResponseBody
    public ResponseVO<Object> deleteSystemOrganization(String longs) {
        if (longs==null){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(longs,Long.class);
        Long[] deleteLongs = new Long[list.size()];
        list.toArray(deleteLongs);
        if (list.size()==1){
            systemOrganizationDomain.deleteById(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }else {
            systemOrganizationDomain.deleteInterSystemOrganization(deleteLongs);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }
    }
}
