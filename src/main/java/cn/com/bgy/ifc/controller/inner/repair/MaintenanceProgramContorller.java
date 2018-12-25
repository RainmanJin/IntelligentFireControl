package cn.com.bgy.ifc.controller.inner.repair;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.repair.MaintenanceContractDomain;
import cn.com.bgy.ifc.domain.interfaces.repair.MaintenanceProgramDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceProgram;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceProgramVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
@RequestMapping("/basic/maintenanceProgram")
public class MaintenanceProgramContorller {

    @Autowired
    private MaintenanceProgramDomain domain;
    @Autowired
    private MaintenanceContractDomain maintenanceContractDomain;

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenanceProgramVo> page, MaintenanceProgramVo vo, String token) {
        //关键只查询暂时默认为维保项目名称的模糊查询
        PageInfo<MaintenanceProgramVo> pageInfo = domain.queryListByPage(page, vo);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * @Author lvbingjian
     * @Description 新增维保项目
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "维保项目新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenanceProgramVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenanceProgram po = new MaintenanceProgram();
        //默认是false删除后设为true
        vo.setLogicRemove(false);
        CopyUtil.copyProperties(po, vo);
        int count = domain.addMaintenanceProgramInfo(vo);
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
    @SystemLogAfterSave(type = 1,description = "维保公司修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(MaintenanceProgramVo vo, String token){
        int resout = 1;
        int count = domain.updateMaintenanceProgram(vo);
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
    public ResponseVO<MaintenanceProgramVo> queryById(@PathVariable long id, String token) {
        MaintenanceProgramVo bean = domain.findById(id);

        return ResponseVO.<MaintenanceProgramVo>success().setData(bean);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "维保公司删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String arr, String token){
        int count = domain.deleteMaintenancePrograms(arr);
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
