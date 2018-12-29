package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.entity.po.system.SystemPower;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemPowerVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemPowerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统权限
 * @date: 2018-12-05 11:27
 **/
@RestController
@RequestMapping("/system/power")
public class SystemPowerController {

    @Autowired
    private SystemPowerService systemPowerService;

    /**
     * @author: ZhangCheng
     * @description:分页查询
     * @param: [page, systemPowerVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.system.SystemPower>>
     */
    @GetMapping("queryPage")
    public ResponseVO<PageInfo<SystemPower>> queryList(Page<SystemPower> page, String keywords) {
            PageInfo<SystemPower> pageInfo = systemPowerService.queryListByPage(page, keywords);
            return ResponseVO.<PageInfo<SystemPower>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.system.SystemPower>
     */
    @GetMapping("findById/{id}")
    public ResponseVO<SystemPower> findById(@PathVariable Long id) {
        SystemPower systemPower = systemPowerService.findById(id);
        return ResponseVO.<SystemPower>success().setData(systemPower);
    }

    /**
     * @author: ZhangCheng
     * @description:添加系统权限
     * @param: [systemPowerVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1, description = "添加系统权限")
    public ResponseVO<Object> add(@Validated SystemPowerVo systemPowerVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemPower systemPower = new SystemPower();
        CopyUtil.copyProperties(systemPowerVo, systemPower);
        int result=systemPowerService.insertSelective(systemPower);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:修改系统权限
     * @param: [systemPowerVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(type = 1, description = "修改系统权限")
    public ResponseVO<Object> edit(@Validated SystemPowerVo systemPowerVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemPower systemPower = new SystemPower();
        CopyUtil.copyProperties(systemPowerVo, systemPower);
        int result=systemPowerService.updateSelective(systemPower);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:删除系统权限
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1, description = "删除系统权限")
    public ResponseVO<Object> delete(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = systemPowerService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }
}
