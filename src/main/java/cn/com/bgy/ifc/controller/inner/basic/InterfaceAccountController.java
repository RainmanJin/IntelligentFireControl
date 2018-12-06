package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.InterfaceAccountDomain;

import cn.com.bgy.ifc.entity.vo.basic.InterfaceAccountVo;
import cn.com.bgy.ifc.entity.po.basic.InterfaceAccount;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/basic/interfaceAccount")
public class InterfaceAccountController {
    @Autowired
    private InterfaceAccountDomain interfaceaccountDomain;
    @GetMapping("add")
    @ResponseBody
    public ResponseVO<Object> add(@Validated InterfaceAccountVo interfaceaccountVo, BindingResult error){

        try {
            //todo informationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            InterfaceAccount interfaceaccount= new InterfaceAccount();
            CopyUtil.copyProperties(interfaceaccountVo,interfaceaccount);
            interfaceaccount.setCreateTime(new Date());
            interfaceaccountDomain.insert(interfaceaccount);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @GetMapping("update")
    @ResponseBody
    public ResponseVO<Object> update(@Validated InterfaceAccountVo interfaceaccountVo, BindingResult error){
        try {
            //todo interfaceaccountVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            InterfaceAccount interfaceaccount= new InterfaceAccount();
            CopyUtil.copyProperties(interfaceaccountVo,interfaceaccount);
            interfaceaccountDomain.update(interfaceaccount);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @GetMapping("delete")
    @ResponseBody
    public ResponseVO<Object> delete( Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        interfaceaccountDomain.deleteById(id);
        return ResponseVO.success();
    }
    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        InterfaceAccount interfaceaccount = interfaceaccountDomain.findById(id);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(interfaceaccount);
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setMsg("success");
        return responseVO.setData(interfaceaccount);
    }
    /**
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<InterfaceAccount> page){
        InterfaceAccount interfaceAccount= new InterfaceAccount();
        PageInfo<InterfaceAccount> pageInfo=interfaceaccountDomain.searchByWhere(page,interfaceAccount);
        return ResponseVO.success().setData(pageInfo);
    }
}
