package cn.com.bgy.ifc.controller.inner.fireinspection;


import java.util.ArrayList;
import java.util.List;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDay;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireInspectionDayDomain;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireInspectionDayVo;
/**
 * lvbingjian
 * 每日防火巡查记录表
 * 2018年12月30日
 */
@Controller
@RequestMapping("/fireinspection/fireInspectionDay")
public class FireInspectionDayController extends BaseController{
	@Autowired
	private FireInspectionDayDomain fireInspectionDayDomain;
	/**
     * 分页查询
     *
     * @return
     */
    @GetMapping("queryPageData")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<FireInspectionDay> page, FireInspectionDay po) {
    	//获取当前登录人做角色数据权限过滤
    	//Account user=this.getUser();
        PageInfo<FireInspectionDay> pageInfo = fireInspectionDayDomain.getPageList(page, po,null);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAllList")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
        return ResponseVO.success().setData(fireInspectionDayDomain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增每日防火巡查记录表
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "每日防火巡查记录表新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated FireInspectionDayVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        FireInspectionDay fireInspectionDay = new FireInspectionDay();
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, fireInspectionDay);
        int count = fireInspectionDayDomain.insert(fireInspectionDay);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功！");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author chenlie
     * @Description 修改
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("editData")
    @RequiresRoles(value= {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ADMIN},logical=Logical.OR)
    @SystemLogAfterSave(description = "每日防火巡查记录表修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(FireInspectionDay po, String token){
        FireInspectionDay bean = fireInspectionDayDomain.findById(po.getId());
        CopyUtil.copyProperties(po,bean);
        int count = fireInspectionDayDomain.update(bean);
        if (count >0) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * @description:通过id查询数据
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/18 11:36
     */
    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<FireInspectionDay> queryById( long id) {
        FireInspectionDay bean = fireInspectionDayDomain.findById(id);

        return ResponseVO.<FireInspectionDay>success().setData(bean);
    }
    /**
     * @Author chenlie
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "每日防火巡查记录表删除")
    @ResponseBody
    public ResponseVO<Object> deleteData( String ids){
        List<Long> list = ListUtil.getListId(ids);
    	int	count = fireInspectionDayDomain.deleteBatch(list);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
}
