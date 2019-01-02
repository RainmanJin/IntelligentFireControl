package cn.com.bgy.ifc.controller.inner.fireinspection;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireContentsDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireContents;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireContentsVo;

/**
 * lvbingjian
 * 检查内容  码表维护
 * 2018年12月30日
 */
@Controller
@RequestMapping("/fireinspection/fireContents")
public class FireContentsController extends BaseController{
	@Autowired
	private FireContentsDomain domain;
	/**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @GetMapping("queryPageData")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<FireContents> page, FireContents po) {
    	//获取当前登录人做角色数据权限过滤
    	//Account user=this.getUser();
        PageInfo<FireContents> pageInfo = domain.getPageList(page, po);
        return ResponseVO.success().setData(pageInfo);
    }
	 /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAllData")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
        return ResponseVO.success().setData(domain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增检查内容  码表
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("createData")
    @SystemLogAfterSave(type = 1,description = "检查内容  码表新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated FireContentsVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        FireContents fireContents = new FireContents();
        //默认是false删除后设为true
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, fireContents);
        int count = domain.insert(fireContents);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功！");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author lvbingjian
     * @Description 修改
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("editData")
    @RequiresRoles(value= {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ADMIN},logical=Logical.OR)
    @SystemLogAfterSave(type = 1,description = "检查内容  码表修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(FireContents po, String token){
        int resout = 1;
        int count = domain.update(po);
        if (count == resout) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * 通过ID查看详细信息
     * lbj
     * 2018年12月20日
     * @param id
     * @param token
     * @return
     */
    @GetMapping("queryById/{id}")
    @ResponseBody
    public ResponseVO<FireContents> queryById(@PathVariable long id, String token) {
        FireContents bean = domain.findById(id);

        return ResponseVO.<FireContents>success().setData(bean);
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(type = 1,description = "检查内容  码表删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String arr, String token){
    	String []ids = arr.split(",");
    	List<Long>list = new ArrayList<Long>();
    	int count;
    	if(ids.length>0) {
    		for (int i = 0; i < ids.length; i++) {
    			list.add(Long.valueOf(ids[i]));
			}
    		count = domain.deleteBatch(list);
    	}else {
    		count = 0;
    	}
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }

}
