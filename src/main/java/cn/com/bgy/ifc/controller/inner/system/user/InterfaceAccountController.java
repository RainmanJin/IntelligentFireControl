package cn.com.bgy.ifc.controller.inner.system.user;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;

import cn.com.bgy.ifc.domain.interfaces.system.user.InterfaceAccountDomain;
import cn.com.bgy.ifc.entity.vo.system.user.InterfaceAccountVo;
import cn.com.bgy.ifc.entity.po.system.user.InterfaceAccount;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
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
 * @description:接口用户
 * @date: 2018-12-05 09:30
 **/
@Controller
@RequestMapping("/basic/interfaceAccount")
public class InterfaceAccountController {
    @Autowired
    private InterfaceAccountDomain interfaceaccountDomain;
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "添加接口用户")
    @ResponseBody
    public ResponseVO<Object> add(@Validated InterfaceAccountVo interfaceaccountVo, BindingResult error){
            //todo informationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            InterfaceAccount interfaceaccount= new InterfaceAccount();
            CopyUtil.copyProperties(interfaceaccountVo,interfaceaccount);
            interfaceaccount.setCreateTime(new Date());
            interfaceaccount.setLogicRemove(false);
            interfaceaccountDomain.insert(interfaceaccount);
            return ResponseVO.success();

    }
    @SystemLogAfterSave(type = 1,description = "修改接口用户")
    @PostMapping("update")
    @ResponseBody
    public ResponseVO<Object> update(@Validated InterfaceAccountVo interfaceaccountVo, BindingResult error){

            //todo interfaceaccountVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            InterfaceAccount interfaceaccount= new InterfaceAccount();
            CopyUtil.copyProperties(interfaceaccountVo,interfaceaccount);
            interfaceaccountDomain.update(interfaceaccount);
            return ResponseVO.success();

    }
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        interfaceaccountDomain.deleteById(id);
        return ResponseVO.success();
    }
    @GetMapping("findById")
    @SystemLogAfterSave(type = 1,description = "通过id查询接口用户")
    @ResponseBody
    public ResponseVO<Object> findById( Long id){
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
    @SystemLogAfterSave(type = 1,description = "分页查询通知公告")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<InterfaceAccount> page){
        InterfaceAccount interfaceAccount= new InterfaceAccount();
        PageInfo<InterfaceAccount> pageInfo=interfaceaccountDomain.searchByWhere(page,interfaceAccount);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 批量删除用户接口
     * @param longs
     * @return
     */
    @PostMapping("deleteInterfaceAccount")
    @SystemLogAfterSave(type = 1,description = "批量删除接口用户")
    @ResponseBody
    public ResponseVO<Object> deleteInterfaceAccount(String longs) {
        if (longs==null){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(longs,Long.class);
        Long[] deleteLongs = new Long[list.size()];
        list.toArray(deleteLongs);
        if (list.size()==1){
            interfaceaccountDomain.deleteById(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }else {
            interfaceaccountDomain.deleteInterfaceAccount(deleteLongs);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }
    }
}
