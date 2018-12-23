package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.GroupsDomain;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupDomain;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupItemsDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.Groups;
import cn.com.bgy.ifc.entity.po.system.UserGroup;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.GroupsVo;
import cn.com.bgy.ifc.entity.vo.system.UserGroupVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/group")
public class UserGroupController {

    @Autowired
    private GroupsDomain groupsDomain;
    @Autowired
    private UserGroupDomain userGroupDomain;
    @Autowired
    private UserGroupItemsDomain userGroupItemsDomain;

    @GetMapping("/groupPage")
    public String userPage(){

        return "/basic/groupPage";
    }
    @PostMapping("add")
    @ResponseBody
    public   ResponseVO<Object>  add(@Validated GroupsVo groupsVo, BindingResult error){
        try {
            //todo userVO 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            Groups groups= new Groups();
            CopyUtil.copyProperties(groupsVo,groups);
            groupsDomain.insert(groups);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Map<String,Object>> page, @Validated GroupsVo groupsVo, BindingResult error){
        /*Subject subject = SecurityUtils.getSubject();
        Account user = (Account) subject.getPreviousPrincipals();*/
        Groups groups= new Groups();
        CopyUtil.copyProperties(groupsVo,groups);
        PageInfo<Map<String,Object>> pageInfo=userGroupDomain.searchByPage(page, groupsVo);
        return ResponseVO.success().setData(pageInfo);
    }


    /**
     * 根据用户id删除用户组
     * @param id
     * @return
     */
    @PostMapping("deleteById")
    @ResponseBody
    public ResponseVO<Object> deleteById(Long id){

            Groups groups= groupsDomain.findById(id);
            if(groups==null) {
                ResponseVO.error().setMsg("请求数据不存在，请刷新重试！");
            }
            List<Object> list=new ArrayList<>();
            list.add(id);
          int res= groupsDomain.deleteBatch(list);
        return ResponseVO.success().setMsg("数据删除成功！");
    }

}
