package cn.com.bgy.ifc.controller.inner.maintenance;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceCompanyDomain;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceContractDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenanceContractVo;

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
 * 维保合同
 * 2018年12月20日
 */
@Controller
@RequestMapping("/maintenance/maintenanceContract")
public class MaintenanceContractController extends BaseController{
    @Autowired
    private MaintenanceContractDomain maintenanceContractDomain;

    @Autowired
    private MaintenanceCompanyDomain maintenanceCompanyDomain;
    /**
     * 分页查询
     *
     * @param maintenanceContract
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenanceContract> page, MaintenanceContract maintenanceContract) {
        //关键只查询暂时默认为合同名称的模糊查询
        PageInfo<MaintenanceContract> pageInfo = maintenanceContractDomain.queryListByPage(page, maintenanceContract);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAllList")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
       return ResponseVO.success().setData(maintenanceContractDomain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增维保合同
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "维保合同新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenanceContractVo maintenanceContractVo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenanceContract maintenanceContract = new MaintenanceContract();
        Account user= this.getUser();
        //默认登录人的机构
        maintenanceContractVo.setOrgId(user.getOrganizationId());
        //当前系统时间为新建时间
        maintenanceContractVo.setCreateTime(new Date());
        //默认是false删除后设为true
        maintenanceContractVo.setLogicRemove(false);
        CopyUtil.copyProperties(maintenanceContractVo, maintenanceContract);
        int count = maintenanceContractDomain.addMaintenanceContractInfo(maintenanceContract);
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
    @SystemLogAfterSave(description = "维保合同修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenanceContract maintenanceContract, String token){
        int resout = 1;
        int count = maintenanceContractDomain.updateMaintenanceContract(maintenanceContract);
        if (count == resout) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * 通过ID查看合同详细信息
     * lbj
     * 2018年12月20日
     * @param id
     * @param token
     * @return
     */
    @GetMapping("queryById")
    
    @ResponseBody
    public ResponseVO<MaintenanceContract> queryById( long id, String token) {
        MaintenanceContract bean = maintenanceContractDomain.findById(id);

        return ResponseVO.<MaintenanceContract>success().setData(bean);
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
     * 项目下拉框初始化
     * @return
     */
    @GetMapping("queryRegionProjectList")
    @ResponseBody
    public ResponseVO<Object> queryRegionProjectList() {
        return ResponseVO.success().setData(maintenanceContractDomain.getRegionProjectList());
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018年12月24日15:06:02
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "维保合同删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String ids, String token){
    	ids = ids.replace("[", "") ;
    	ids = ids.replace("]", "") ;
        int count = maintenanceContractDomain.deleteMaintenanceContracts(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
    /**
     * 维保公司下拉框初始化
     * @return
     */
    @GetMapping("querymaintenanceCompanyList")
    @ResponseBody
    public ResponseVO<Object> queryMaintenanceCompanyList() {
        return ResponseVO.success().setData(maintenanceCompanyDomain.queryListByParam(null));
    }

}

