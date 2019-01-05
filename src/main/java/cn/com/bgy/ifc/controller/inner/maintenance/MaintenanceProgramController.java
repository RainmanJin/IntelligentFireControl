package cn.com.bgy.ifc.controller.inner.maintenance;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceContractDomain;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceProgramDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceProgram;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenanceProgramVo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * lvbingjian
 * 维保项目库
 * 22018年12月25日
 */
@Controller
@RequestMapping("/maintenance/maintenanceProgram")
public class MaintenanceProgramController extends BaseController{

    @Autowired
    private MaintenanceProgramDomain domain;
    @Autowired
    private MaintenanceContractDomain maintenanceContractDomain;

    /**
     * 分页查询
     *
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenanceProgram> page, MaintenanceProgram po, String token) {
        //关键只查询暂时默认为维保项目名称的模糊查询
        PageInfo<MaintenanceProgram> pageInfo = domain.queryListByPage(page, po);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 分页查询
     *
     * @return
     */
    @GetMapping("queryAllList")
    @ResponseBody
    public ResponseVO<Object> queryAllList(String token) {
    	return ResponseVO.success().setData(domain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增维保项目
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "维保项目新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenanceProgramVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenanceProgram po = new MaintenanceProgram();
        Account user= this.getUser();
        //默认登录人的机构
        vo.setOrganizationId(user.getOrganizationId());
        //当前系统时间为新建时间
        vo.setCreateTime(new Date());
        //默认是false删除后设为true
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(vo, po);
        int count = domain.addMaintenanceProgramInfo(po);
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
    @SystemLogAfterSave(description = "维保项目修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenanceProgram po, String token){
        int resout = 1;
        //当前系统时间为新建时间
        po.setCreateTime(new Date());
        int count = domain.updateMaintenanceProgram(po);
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
    public ResponseVO<MaintenanceProgram> queryById( long id, String token) {
        MaintenanceProgram bean = domain.findById(id);

        return ResponseVO.<MaintenanceProgram>success().setData(bean);
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018年12月26日15:36:00
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "维保项目删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String ids, String token){
    	ids = ids.replace("[", "") ;
    	ids = ids.replace("]", "") ;
        int count = domain.deleteMaintenancePrograms(ids);
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
        return ResponseVO.success().setData(domain.queryListEquipmentType());
    }
}
