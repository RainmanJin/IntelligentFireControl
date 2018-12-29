package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.InformationDomain;
import cn.com.bgy.ifc.entity.po.system.Information;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.InformationVo;
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
 * @description:通知公告
 * @date: 2018-12-05 09:30
 **/
@Controller
@RequestMapping("/system/information")
public class InformationController {
    @Autowired
    private InformationDomain informationDomain;

    @Autowired
    AccountDomain accountDomain;

    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "添加通知公告")
    @ResponseBody
    public ResponseVO<Object> add(@Validated InformationVo informationVo, BindingResult error){
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
    }

    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "修改通知公告")
    @ResponseBody
    public ResponseVO<Object> update(@Validated InformationVo informationVo, BindingResult error){
            //todo informationVo 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            Information information= new Information();
            CopyUtil.copyProperties(informationVo,information);
            informationDomain.update(information);
            return ResponseVO.success();
    }
    /*@PostMapping("delete")
    @ResponseBody
    public ResponseVO<Object> delete(String  ids){
        ListUtil.getListId(ids);
        if(id==null){
            return ResponseVO.error().setMsg("id不能为空");
        }
        informationDomain.delete(id);
        return ResponseVO.success();
    }*/

    @GetMapping("findById")
    @SystemLogAfterSave(type = 1,description = "通过id查询通知公告")
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
     * @param information
     * @return
     */
    @GetMapping("searchPage")
    @SystemLogAfterSave(type = 1,description = "分页查询通知公告")
    @ResponseBody
    public ResponseVO<PageInfo<Information>> searchPage(Page<Information> page,Information information){
        PageInfo<Information> pageInfo=informationDomain.searchByPage(page,information);
        return ResponseVO.<PageInfo<Information>>success().setData(pageInfo);
    }
    /**
     * 批量删除
     * @param longs
     * @return
     */
    @PostMapping("deleteInformation")
    @SystemLogAfterSave(type = 1,description = "批量删除通知公告")
    @ResponseBody
    public ResponseVO<Object> deleteInformation(String longs) {
        if (longs==null){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(longs,Long.class);
        Long[] deleteLongs = new Long[list.size()];
        list.toArray(deleteLongs);
        if (list.size()==1){
            informationDomain.deleteById(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }else {
            informationDomain.deleteInformation(deleteLongs);
            return ResponseVO.success().setMsg("删除成功").setData(null);
        }
    }

}
