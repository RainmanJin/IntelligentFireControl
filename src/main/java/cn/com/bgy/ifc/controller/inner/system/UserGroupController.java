package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.system.GroupsDao;
import cn.com.bgy.ifc.domain.interfaces.system.GroupsDomain;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupDomain;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupItemsDomain;
import cn.com.bgy.ifc.entity.po.project.Project;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
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
@RequestMapping("/system/userGroup")
public class UserGroupController {

    @Autowired
    private GroupsDomain groupsDomain;
    @Autowired
    private UserGroupDomain userGroupDomain;
    @Autowired
    private UserGroupItemsDomain userGroupItemsDomain;


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
     * @description:根据id删除系统用户分组
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 18:07
     */
    @PostMapping("deleteById")
    @ResponseBody
    public ResponseVO<Object> deleteById(Long id){
            Groups groups= groupsDomain.findById(id);
            if(groups==null) {
                ResponseVO.error().setMsg("请求数据不存在，请刷新重试！");
            }
            List<Long> list=new ArrayList<>();
            list.add(id);
          int res= groupsDomain.deleteBatch(list);
        return ResponseVO.success().setMsg("数据删除成功！");
    }


    /**
     * @description:用户分组分配区域
     * @param: [groupId, regionIds]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 16:37
     */
    @PostMapping("distributionRegion")
    @ResponseBody
    public ResponseVO<Object> distributionRegion(Long groupId,String regionIds){

        List<Long> list=new ArrayList<>();
        if (regionIds !=null && !regionIds.isEmpty()) {
             list = ListUtil.getListId(regionIds);
        }
        try {
            userGroupDomain.distributionRegion( groupId, list);
        }catch (Exception e){
            ResponseVO.error().setMsg("操作失败！");
        }
        return ResponseVO.success();
    }
    /**
     * @description:用户分组分配用户
     * @param: [groupId, accountIds]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 16:37
     */
    @PostMapping("distributionAccount")
    @ResponseBody
    public ResponseVO<Object> distributionAccount(Long groupId,String accountIds){

        List<Long> list=new ArrayList<>();
        if (accountIds !=null && !accountIds.isEmpty()) {
            list = ListUtil.getListId(accountIds);
        }
        try {
            userGroupDomain.distributionAccount( groupId, list);
        }catch (Exception e){
            ResponseVO.error().setMsg("操作失败！");
        }
        return ResponseVO.success().setMsg("数据删除成功！");
    }

    /**
     * @description:用户分组分配项目
     * @param: [groupId, accountIds]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 16:36
     */
    @PostMapping("distributionProject")
    @ResponseBody
    public ResponseVO<Object> distributionProject(Long groupId,String accountIds){

        List<Long> list=new ArrayList<>();
        if (accountIds !=null && !accountIds.isEmpty()) {
            list = ListUtil.getListId(accountIds);
        }
        try {
            userGroupDomain.distributionAccount( groupId, list);
        }catch (Exception e){
            ResponseVO.error().setMsg("操作失败！");
        }
        return ResponseVO.success().setMsg("数据删除成功！");
    }
    /**
     * @description:分页查询系统用户分组
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/8 18:07
     */
    @GetMapping("searchGroupsByPage")
    @ResponseBody
    public   ResponseVO<Object>  searchGroupsByPage(Page<Groups> page,Groups groups){
        PageInfo<Groups> list =groupsDomain.queryListByPage(page,groups);

        return  ResponseVO.success().setData(list);
    }
    /**
     * @description:添加用户分组
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/8 18:06
     */
    @GetMapping("addGroups")
    @ResponseBody
    public   ResponseVO<Object>  addGroups(Groups groups){
        int res =groupsDomain.insert(groups);
        return  ResponseVO.addSuccess();
    }

    /**
     * @description:添加用户分组
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/8 18:06
     */
    @GetMapping("editGroups")
    @ResponseBody
    public   ResponseVO<Object> editGroups (Groups groups){
        Groups query= groupsDomain.findById(groups.getId());
        CopyUtil.copyProperties(groups,query);
        groupsDomain.update(query);
        return  ResponseVO.editSuccess();
    }



    /**
     * @description:查询用户分组
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/8 18:06
     */
    @GetMapping("findGroupsById")
    @ResponseBody
    public   ResponseVO<Object> findGroupsById (Integer type,Long id){
        Groups query= groupsDomain.findById(id);
        if (type.intValue()==1) {
            List<RegionInfo> listRegionInfo = userGroupItemsDomain.findRegionInfoByGroupId(id);
            return  ResponseVO.success().setData(listRegionInfo);
        }
        else if (type.intValue()==2) {
            List<Project> listProject = userGroupItemsDomain.findProjectInfoByGroupId(id);
            return  ResponseVO.success().setData(listProject);
        }else{
            return ResponseVO.error().setMsg("请选择正确的类型");
        }


    }
}
