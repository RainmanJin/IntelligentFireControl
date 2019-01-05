package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Description 区域信息controller
 * @Date 2018/12/18 15:19
 */
@RestController
@RequestMapping("/project/regionInfo")
public class RegionInfoController extends BaseController {


    @Autowired
    private RegionInfoDomain regionInfoDomain;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("query")
//    @RequiresRoles(value={SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ORG_ADMIN,SystemConstant.SYSTEM_ROLES_ORG_USER,
//            SystemConstant.SYSTEM_ROLES_AREA_ADMIN,SystemConstant.SYSTEM_ROLES_AREA_USRE},logical = Logical.OR)
    public ResponseVO<PageInfo> queryListRegionInfo( Page<Object> page, String keyword){
        Account user=this.getUser();
        PageInfo pageInfo = regionInfoDomain.queryListRegionInfo(page, keyword,user);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(description = "区域信息修改")
    public ResponseVO<Object> updateRegionInfo( RegionInfoVo regionInfoVo){

        int count = regionInfoDomain.updateRegionInfo(regionInfoVo);
        if (count == 1) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 15:22
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "区域信息删除")
    public ResponseVO<Object> deleteRegionInfo( String  ids){
        int count = regionInfoDomain.deleteRegionInfo(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
    /**
     * @Author huxin
     * @Description 区域信息添加
     * @Date 2018/12/19 11:44
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "区域信息添加")
    public ResponseVO<Object> insertRegionInfo(RegionInfo regionInfo){
        int count = regionInfoDomain.insert(regionInfo);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }

    /**
     * @Author huxin
     * @Description 查询所有区域名
     * @Date 2018/12/20 18:24
     */
    @GetMapping("queryAllName")
    @ResponseBody
    public ResponseVO<Object> queryRegionInfoName(){
        Account user=this.getUser();
        List<Map<String,Object>> list  = regionInfoDomain.queryRegionInfoName(user);
        return ResponseVO.<Object>success().setData(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询区域信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("find")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionInfoDomain.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
