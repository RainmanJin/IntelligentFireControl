package cn.com.bgy.ifc.controller.inner.basic;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.SystemOrganizationVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/basic/systemOrganization")
public class SystemOrganizationController {
    @Autowired
    private SystemOrganizationDomain systemOrganizationDomain;
    @PostMapping("add")
    @ResponseBody
    public ResponseVO<Object> add(@Validated SystemOrganizationVo systemOrganizationVo, BindingResult error){

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }

    @PostMapping("update")
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
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<SystemOrganization> page){
        SystemOrganization systemOrganization= new SystemOrganization();
        PageInfo<SystemOrganization> pageInfo=systemOrganizationDomain.searchByWhere(page,systemOrganization);
        return ResponseVO.success().setData(pageInfo);
    }
}
