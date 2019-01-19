package cn.com.bgy.ifc.controller.inner.fireinspection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireInspectionDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspection;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireInspectionVo;
/**
 * lvbingjian
 * 消防巡检主表单
 * 2018年12月30日
 */
@Controller
@RequestMapping("/fireinspection/fireInspection")
public class FireInspectionController extends BaseController{
	@Autowired
	private FireInspectionDomain fireInspectionDomain;
	/**
     * 分页查询
     *
     * @return
     */
    @GetMapping("queryPageData")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<FireInspection> page, FireInspection po) {
    	//获取当前登录人做角色数据权限过滤
//    	Account user=this.getUser();
        PageInfo<FireInspection> pageInfo = fireInspectionDomain.getPageList(page, po,null);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * 查询全部
     * @return
     */
    @GetMapping("queryAllData")
    @ResponseBody
    public ResponseVO<Object> queryAllList() {
        return ResponseVO.success().setData(fireInspectionDomain.queryListByParam(null));
    }
    /**
     * @Author lvbingjian
     * @Description 新增消防巡检主表单
     * @Date 2018年12月20日09:48:38
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "消防巡检主表单新增")
    @ResponseBody
    public ResponseVO<Object> add(@Validated FireInspectionVo vo, BindingResult error, String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        FireInspection bean = new FireInspection();
        CopyUtil.copyProperties(vo, bean);
        bean.setLogicRemove(false);
        bean.setCreateTime(new Date());
        int count = fireInspectionDomain.insert(bean);
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
    @PostMapping("editData")
    @SystemLogAfterSave(description = "消防巡检主表单修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet(FireInspection po, String token){
        FireInspection bean = fireInspectionDomain.findById(po.getId());
        CopyUtil.copyProperties(po,bean);
        int count = fireInspectionDomain.updateSelective(bean);
        if (count >0) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * 通过ID查看详细信息
     * lbj
     * 2018年12月20日
     * @param id
     * @return
     */
    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<FireInspection> findById( Long id) {
        FireInspection bean = fireInspectionDomain.findById(id);

        return ResponseVO.<FireInspection>success().setData(bean);
    }
    /**
     * @Author lvbingjian
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "消防巡检主表单删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String arr, String token){
    	String []ids = arr.split(",");
    	List<Long>list = new ArrayList<Long>();
    	int count;
    	if(ids.length>0) {
    		for (int i = 0; i < ids.length; i++) {
    			list.add(Long.valueOf(ids[i]));
			}
    		count = fireInspectionDomain.deleteBatch(list);
    	}else {
    		count = 0;
    	}
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
	
}
