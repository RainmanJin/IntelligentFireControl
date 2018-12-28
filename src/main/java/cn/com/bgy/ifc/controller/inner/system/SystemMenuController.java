package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemMenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author huxin
 * @Date 2018/12/5 9:52
 * @Description 系统主页面菜单
 **/
@RestController
@RequestMapping(value = "/system/menu")
public class SystemMenuController extends BaseController {

    @Autowired
    private SystemMenuService systemMenuService;

    /**
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     * @Author huxin
     * @Description 分页查询所有菜单信息
     * @Date 2018/12/5 10:04
     * @Param []
     */
    @GetMapping(value = "/queryAllSystemMenuInfo")
    public ResponseVO<Object> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord) {
        PageInfo<SystemMenuVo> pageInfo = systemMenuService.queryAllSystemMenuInfo(page, keyWord);
        return ResponseVO.success().setData(pageInfo);
    }

    /**
     * @return cn.com.bgy.ifc.entity.vo.ResponseVO
     * @Author chenlie
     * @Description根据上级菜单获取二三级菜单
     * @Date 2018/12/5 18:34
     * @Param [list]
     */
    @GetMapping(value = "/findMenuTreeByType")
    public ResponseVO<Object> findMenuTreeByType(int type) {
        Account user = this.getUser();
        return ResponseVO.success().setData(systemMenuService.findMenuTreeByType(type, user.getId()));
    }

    /**
     * @author: ZhangCheng
     * @description:ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.system.SystemMenu>
     */
    @GetMapping(value = "/findById")
    public ResponseVO<SystemMenu> findById(Long id) {
        SystemMenu systemMenu = systemMenuService.findById(id);
        return ResponseVO.<SystemMenu>success().setData(systemMenu);
    }

    /**
     * @author: ZhangCheng
     * @description:添加系统菜单
     * @param: [systemMenuVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO
     */
    @PostMapping(value = "/add")
    @SystemLogAfterSave(type = 1, description = "添加系统菜单")
    public ResponseVO<Object> add(@Validated SystemMenuVo systemMenuVo, BindingResult error) {
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemMenu systemMenu = new SystemMenu();
        CopyUtil.copyProperties(systemMenuVo, systemMenu);
        int result = systemMenuService.insertSelective(systemMenu);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:修改系统菜单
     * @param: [systemMenuVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(type = 1, description = "修改系统菜单")
    public ResponseVO<Object> edit(@Validated SystemMenuVo systemMenuVo, BindingResult error) {
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemMenu systemMenu = new SystemMenu();
        CopyUtil.copyProperties(systemMenuVo, systemMenu);
        int result = systemMenuService.updateSelective(systemMenu);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:删除系统菜单
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1, description = "删除系统菜单")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = systemMenuService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }

}
