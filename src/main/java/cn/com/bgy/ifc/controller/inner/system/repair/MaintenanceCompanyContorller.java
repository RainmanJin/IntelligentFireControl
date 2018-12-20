package cn.com.bgy.ifc.controller.inner.system.repair;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.repair.MaintenanceCompanyDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceCompany;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceCompanyVo;
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

/**
 * lvbingjian
 * 维保公司控制层
 * 2018年12月20日
 */
@Controller
@RequestMapping("/basic/maintenanceCompany")
public class MaintenanceCompanyContorller {
    @Autowired
    private MaintenanceCompanyDomain domain;

    /**
     * 分页查询
     *
     * @param maintenanceContract
     * @return
     */
    @GetMapping("queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<MaintenanceCompanyVo> page, MaintenanceCompanyVo maintenanceContract) {
        //关键只查询暂时默认为合同名称的模糊查询
        PageInfo<MaintenanceCompanyVo> pageInfo = domain.queryListByPage(page, maintenanceContract);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * @Author lvbingjian
     * @Description 新增委办合同
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "维保公司新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated MaintenanceCompanyVo maintenanceCompanyVo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }

        MaintenanceCompany maintenanceCompany = new MaintenanceCompany();
        //默认是false删除后设为true
        maintenanceCompanyVo.setLogicRemove(false);
        CopyUtil.copyProperties(maintenanceCompanyVo, maintenanceCompany);
        int count = domain.addMaintenanceCompanyInfo(maintenanceCompany);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功！");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
}
