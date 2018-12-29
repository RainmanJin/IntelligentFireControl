package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;

import cn.com.bgy.ifc.domain.interfaces.system.InterfaceAccountDomain;
import cn.com.bgy.ifc.entity.vo.system.InterfaceAccountVo;
import cn.com.bgy.ifc.entity.po.system.InterfaceAccount;
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
@RequestMapping("/system/interfaceAccount")
public class InterfaceAccountController {
    @Autowired
    private InterfaceAccountDomain interfaceAccountDomain;
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
            interfaceAccountDomain.insert(interfaceaccount);
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
            interfaceAccountDomain.update(interfaceaccount);
            return ResponseVO.success();

    }
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        interfaceAccountDomain.deleteById(id);
        return ResponseVO.success();
    }
    @GetMapping("findById")
    @SystemLogAfterSave(type = 1,description = "通过id查询接口用户")
    @ResponseBody
    public ResponseVO<Object> findById( Long id){
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        InterfaceAccount interfaceaccount = interfaceAccountDomain.findById(id);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(interfaceaccount);
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setMsg("success");
        return responseVO.setData(interfaceaccount);
    }
    /**
     * @author chenlie
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("searchPage")
    @SystemLogAfterSave(type = 1,description = "分页查询接口用户")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<InterfaceAccount> page, InterfaceAccount interfaceAccount){
        PageInfo<InterfaceAccount> pageInfo=interfaceAccountDomain.searchByWhere(page,interfaceAccount);
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
            interfaceAccountDomain.deleteById(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }else {
            interfaceAccountDomain.deleteInterfaceAccount(deleteLongs);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }
    }
}
