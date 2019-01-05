package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.InformationDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.Information;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.InformationVo;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author: YanXiaoLu
 * @description:通知公告
 * @date: 2018-12-05 09:30
 **/
@RestController
@RequestMapping("/system/information")
public class InformationController extends BaseController {
    @Autowired
    private InformationDomain informationDomain;

    @Autowired
    AccountDomain accountDomain;

    @PostMapping("add")
    @SystemLogAfterSave(description = "添加通知公告")
    public ResponseVO<Object> add(@Validated InformationVo informationVo, BindingResult error) {
        //informationVo 做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        Account user = this.getUser();
        informationVo.setOrgId(user.getOrganizationId());
        informationVo.setuId(user.getId());
        Information information = new Information();
        CopyUtil.copyProperties(informationVo, information);
        information.setCreateTime(new Date());
        information.setLogicRemove(false);
        informationDomain.insert(information);
        return ResponseVO.success();
    }

    @PostMapping("update")
    @SystemLogAfterSave(description = "修改通知公告")
    public ResponseVO<Object> update(@Validated InformationVo informationVo, BindingResult error) {
        //informationVo 做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        Information information = new Information();
        CopyUtil.copyProperties(informationVo, information);
        informationDomain.update(information);
        return ResponseVO.success();
    }

    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        if (id == null) {
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
     *
     * @param information
     * @return
     */
    @GetMapping("searchPage")
    public ResponseVO<PageInfo<Information>> searchPage(Page<Information> page, Information information) {
        PageInfo<Information> pageInfo = informationDomain.searchByPage(page, information);
        return ResponseVO.<PageInfo<Information>>success().setData(pageInfo);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @PostMapping("deleteInformation")
    @SystemLogAfterSave(description = "批量删除通知公告")
    public ResponseVO<Object> deleteInformation(String ids) {
        if (ids == null || ids.isEmpty()) {
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(ids, Long.class);
        informationDomain.deleteInformation(list);
        return ResponseVO.deleteSuccess();
    }

}
