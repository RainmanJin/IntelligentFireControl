package cn.com.bgy.ifc.controller.inner.maintenance;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePlanDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlan;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenancePlanVo;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * lvbingjian
 * 维保计划
 * 2018年12月20日
 */
@Controller
@RequestMapping("/maintenance/maintenancePlan")
@RolePermission
public class MaintenancePlanController extends BaseController{
	
	@Autowired
	
	private MaintenancePlanDomain domain;
	
	/**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenancePlan> page, MaintenancePlan po, String token) {
        //关键只查询暂时默认为维保项目名称的模糊查询
        PageInfo<MaintenancePlan> pageInfo = domain.queryListByPage(page, po);
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
     * @Description 新增维保项目
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "维保计划新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenancePlanVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenancePlan po = new MaintenancePlan();
        //默认是false删除后设为true
        Account user= this.getUser();
        //默认登录人的机构
        vo.setOrganizationId(user.getOrganizationId());
        //当前系统时间为新建时间
        vo.setCreateTime(new Date());
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, po);
        int count = domain.insert(po);
        if (count == 1) {
        	domain.saveOrders(po);
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
    @SystemLogAfterSave(description = "维保计划修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenancePlan vo, String token){
        int resout = 1;
       //当前系统时间为新建时间
        vo.setCreateTime(new Date());
        int count = domain.update(vo);
        
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
    public ResponseVO<MaintenancePlan> queryById( long id, String token) {
    	MaintenancePlan bean = domain.findById(id);

        return ResponseVO.<MaintenancePlan>success().setData(bean);
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "维保计划删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String ids, String token){
    	ids = ids.replace("[", "") ;
    	ids = ids.replace("]", "") ;
    	List<Long> list = new ArrayList<>();
    	String[]str = ids.split(",");
    	int count  ;
    	   if(str.length>0){
               for (int i = 0; i <str.length ; i++) {
                   list.add(Long.valueOf(str[i]));
               }
               count =  domain.deleteBatch(list);
           }else{
                count=0;
           }
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
}
