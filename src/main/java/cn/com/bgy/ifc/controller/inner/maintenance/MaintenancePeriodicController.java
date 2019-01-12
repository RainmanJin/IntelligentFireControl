package cn.com.bgy.ifc.controller.inner.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePeriodicDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePeriodic;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenancePeriodicVo;
/**
 * lvbingjian
 * 维保周期性计划
 * 2018年12月27日16:41:05+
 */
@Controller
@RequestMapping("/maintenance/maintenancePeriodic")
public class MaintenancePeriodicController extends BaseController {
	@Autowired
	private MaintenancePeriodicDomain domain;

	/**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenancePeriodic> page, MaintenancePeriodic po, String token) {
        PageInfo<MaintenancePeriodic> pageInfo = domain.queryListByPage(page, po);
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
     * @Description 新增
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "维保周期性计划新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenancePeriodicVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenancePeriodic po = new MaintenancePeriodic();

        CopyUtil.copyProperties(vo, po);
        Account user= this.getUser();
        //默认登录人的机构
        po.setOrganizationId(user.getOrganizationId());
        //当前系统时间为新建时间
        po.setCreateTime(new Date());
        //默认是false删除后设为true
        po.setLogicRemove(false);
        int count = domain.insert(po);
        if (count == 1) {
        	int num = domain.saveOrders(po);
        	if(num==po.getSum()) {
        		return ResponseVO.success().setMsg("添加成功！");
        	}else {
        		return ResponseVO.error().setMsg("添加失败,维保工单新增失败！");
        	}
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author lvbingjian
     * @Description 修改
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("update")
    @SystemLogAfterSave(description = "维保周期性计划修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenancePeriodic po, String token){
        int resout = 1;
      //当前系统时间为新建时间
        po.setCreateTime(new Date());
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
    public ResponseVO<MaintenancePeriodic> queryById( long id, String token) {
    	MaintenancePeriodic bean = domain.findById(id);

        return ResponseVO.<MaintenancePeriodic>success().setData(bean);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "维保周期性计划删除")
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
