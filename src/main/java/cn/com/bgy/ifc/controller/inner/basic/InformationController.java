package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.InformationDomain;
import cn.com.bgy.ifc.entity.po.basic.Information;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.InformationVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/basic/information")
public class InformationController {
    @Autowired
    private InformationDomain informationDomain;

    @PostMapping("add")
    @ResponseBody
    public ResponseVO<Object> add(@Validated InformationVo informationVo, BindingResult error){

        try {
            //todo informationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            Information information= new Information();
            CopyUtil.copyProperties(informationVo,information);
            information.setCreateTime(new Date());
            information.setLogicRemove(false);
            informationDomain.insert(information);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }

    @PostMapping("update")
    @ResponseBody
    public ResponseVO<Object> update(@Validated InformationVo informationVo, BindingResult error){
        try {
            //todo informationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            Information information= new Information();
            CopyUtil.copyProperties(informationVo,information);
            informationDomain.update(information);
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
        informationDomain.deleteById(id);
        return ResponseVO.success();
    }

    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        Information information = informationDomain.findById(id);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(information);
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setMsg("success");
        return responseVO.setData(information);
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Information> page){
        Information information= new Information();
        PageInfo<Information> pageInfo=informationDomain.searchByPage(page,information);
        return ResponseVO.success().setData(pageInfo);
    }
}
