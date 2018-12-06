package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.PowerDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.po.basic.SystemPower;
import cn.com.bgy.ifc.entity.po.basic.SystemRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.SystemPowerVo;
import cn.com.bgy.ifc.entity.vo.basic.SystemRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: ZhangCheng
 * @description:系统权限
 * @date: 2018-12-05 11:27
 **/
@Controller
@RequestMapping("/basic/power")
public class PowerController {

    @Autowired
    private PowerDomain powerDomain;

    @GetMapping("queryList")
    @ResponseBody
    public ResponseVO<PageInfo<SystemPower>> queryList(Page<SystemPower> page, SystemPowerVo systemPowerVo) {
        try {
            SystemPower systemPower = new SystemPower();
            CopyUtil.copyProperties(systemPowerVo, systemPower);
            PageInfo<SystemPower> pageInfo = powerDomain.queryListByPage(page, systemPower);
            return ResponseVO.<PageInfo<SystemPower>>success().setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<PageInfo<SystemPower>>exception();
        }
    }

    @GetMapping("queryById/{id}")
    @ResponseBody
    public ResponseVO<SystemPowerVo> queryById(@PathVariable long id) {
        try {
            SystemPower systemPower = powerDomain.findById(id);
            SystemPowerVo systemPowerVo = new SystemPowerVo();
            CopyUtil.copyProperties(systemPower, systemPowerVo);
            return ResponseVO.<SystemPowerVo>success().setData(systemPowerVo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<SystemPowerVo>exception();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:系统权限添加
     * @param: [systemPowerVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("add")
    @ResponseBody
    public ResponseVO<Object> add(@Validated SystemPowerVo systemPowerVo, BindingResult error) {
            //参数校检
            if (error.hasErrors()) {
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemPower systemPower = new SystemPower();
            CopyUtil.copyProperties(systemPowerVo, systemPower);
            int count = powerDomain.insert(systemPower);
            if (count == 1) {
                return ResponseVO.success().setMsg("添加成功！");
            }
            return ResponseVO.error().setMsg("添加失败！");

    }

    /**
     * @author: ZhangCheng
     * @description:系统权限修改
     * @param: [systemPowerVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @ResponseBody
    public ResponseVO<Object> edit(@Validated SystemPowerVo systemPowerVo, BindingResult error) {
            //参数校检
            if (error.hasErrors()) {
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemPower systemPower = new SystemPower();
            CopyUtil.copyProperties(systemPowerVo, systemPower);
            int count = powerDomain.update(systemPower);
            if (count == 1) {
                return ResponseVO.success().setMsg("修改成功");
            }
            return ResponseVO.error().setMsg("修改失败！");
    }


    /**
     * @author: ZhangCheng
     * @description:系统权限删除
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable long id) {
        int count = powerDomain.deleteById(id);
        if (count == 1) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败");

    }
}
