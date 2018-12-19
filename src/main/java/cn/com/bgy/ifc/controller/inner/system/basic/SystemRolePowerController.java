package cn.com.bgy.ifc.controller.inner.system.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.SystemRolePowerDomain;
import cn.com.bgy.ifc.entity.po.system.user.Account;
import cn.com.bgy.ifc.entity.po.system.basic.SystemRolePower;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemRolePowerVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/basic/systemRolePower")
public class SystemRolePowerController {

    @Autowired
    private SystemRolePowerDomain systemRolePowerDomain;
    @GetMapping("/systemRolePowerPage")
    public String userPage(){

        return "/basic/systemRolePowerPage";
    }
    @PostMapping("add")
    @ResponseBody
    public   ResponseVO<Object>  add(Page<SystemRolePower> page, @Validated SystemRolePowerVo systemRolePowerVo, BindingResult error){

        try {
            //todo userVO 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemRolePower systemRolePower= new SystemRolePower();
            CopyUtil.copyProperties(systemRolePowerVo,systemRolePower);
            systemRolePowerDomain.save(systemRolePower);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Account> page,@Validated SystemRolePowerVo systemRolePowerVo, BindingResult error){
        SystemRolePower systemRolePower= new SystemRolePower();
        CopyUtil.copyProperties(systemRolePowerVo,systemRolePower);
        PageInfo<SystemRolePower> pageInfo=systemRolePowerDomain.searchByPage(page,systemRolePower);
        return ResponseVO.success().setData(pageInfo);
    }

    @PostMapping("deleteById")
    @ResponseBody
    public ResponseVO<Object> deleteById(Long id){

        SystemRolePower systemRolePower=systemRolePowerDomain.findById(id);
            if(systemRolePower==null) {
                ResponseVO.error().setMsg("请求数据不存在，请刷新重试！");
            }
          int res=systemRolePowerDomain.deleteById(id);
        return ResponseVO.success().setMsg("数据删除成功！");
    }


}
