package cn.com.bgy.ifc.controller.inner.maintenance;

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
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePlanDetailDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlanDetail;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenancePlanDetailVo;

/**
 * 维保计划明细
 * 2018年12月27日14:07:18
 * @author lvbingjian
 *
 */
@Controller
@RequestMapping("/maintenance/maintenancePlanDetail")
public class MaintenancePlanDetailContorller extends BaseController{
	@Autowired
	private MaintenancePlanDetailDomain domain;
	
	/**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenancePlanDetail> page, MaintenancePlanDetail po) {
        //关键只查询暂时默认为公司名称的模糊查询
        PageInfo<MaintenancePlanDetail> pageInfo = domain.queryListByPage(page, po);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAllList")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
        return ResponseVO.success().setData(domain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增维保公司
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "维保计划明细表新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenancePlanDetailVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenancePlanDetail MaintenancePlanDetail = new MaintenancePlanDetail();
        //默认是false删除后设为true
        //vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, MaintenancePlanDetail);
        int count = domain.insert(MaintenancePlanDetail);
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
    @PostMapping("update")
    //@RequiresRoles(value= {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ADMIN},logical=Logical.OR)
    @SystemLogAfterSave(description = "维保计划明细表修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenancePlanDetail po, String token){
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
    @GetMapping("queryById")
    @ResponseBody
    public ResponseVO<MaintenancePlanDetail> queryById( long id, String token) {
        MaintenancePlanDetail bean = domain.findById(id);

        return ResponseVO.<MaintenancePlanDetail>success().setData(bean);
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "维保计划明细表删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String ids, String token){
    	ids = ids.replace("[", "") ;
    	ids = ids.replace("]", "") ;
    	String []idss = ids.split(",");
    	List<Long>list = new ArrayList<Long>();
    	int count;
    	if(idss.length>0) {
    		for (int i = 0; i < idss.length; i++) {
    			list.add(Long.valueOf(idss[i]));
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
