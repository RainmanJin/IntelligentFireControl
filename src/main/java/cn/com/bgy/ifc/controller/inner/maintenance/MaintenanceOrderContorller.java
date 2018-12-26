package cn.com.bgy.ifc.controller.inner.maintenance;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

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
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceContractDomain;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceOrderDomain;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceProgramDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenanceOrderVo;

/**
 * lvbingjian
 * 维保工单控制
 * 2018年12月26日15:35:25
 */
@Controller
@RequestMapping("/basic/maintenanceOrder")
public class MaintenanceOrderContorller {
	
	@Resource 
	private MaintenanceOrderDomain domain;
	@Autowired
    private MaintenanceContractDomain maintenanceContractDomain;
	@Autowired
    private MaintenanceProgramDomain maintenanceProgramDomain;
	
	/**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenanceOrder> page, MaintenanceOrder po, String token) {
        //关键只查询暂时默认为维保项目名称的模糊查询
        PageInfo<MaintenanceOrder> pageInfo = domain.queryListByPage(page, po);
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
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "维保工单新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenanceOrderVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenanceOrder po = new MaintenanceOrder();
        //默认是false删除后设为true
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, po);
        int count = domain.insert(po);
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
    @SystemLogAfterSave(type = 1,description = "维保工单修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenanceOrder po, String token){
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
    public ResponseVO<MaintenanceOrder> queryById(@PathVariable long id, String token) {
    	MaintenanceOrder bean = domain.findById(id);

        return ResponseVO.<MaintenanceOrder>success().setData(bean);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "维保工单删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String arr, String token){
    	List<Long> list = new ArrayList<>();
    	String[]str = arr.split(",");
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
    /**
     * 获取区域下拉框初始化
     * @return
     */
    @GetMapping("queryRegionList")
    @ResponseBody
    public ResponseVO<Object> queryRegionList() {
        return ResponseVO.success().setData(maintenanceContractDomain.getRegionList());
    }
    /**
     * 获取设备类型下拉框初始化
     * @return
     */
    @GetMapping("queryListEquipmentType")
    @ResponseBody
    public ResponseVO<Object> queryListEquipmentType() {
        return ResponseVO.success().setData(maintenanceProgramDomain.queryListEquipmentType());
    }
    /**
     * 项目下拉框初始化
     * @return
     */
    @GetMapping("queryRegionProjectList")
    @ResponseBody
    public ResponseVO<Object> queryRegionProjectList() {
        return ResponseVO.success().setData(maintenanceContractDomain.getRegionProjectList());
    }

}
