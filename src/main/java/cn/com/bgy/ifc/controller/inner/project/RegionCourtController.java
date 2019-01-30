package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.RegionCourtVo;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionCourtService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:17
 * @Description 苑区信息
 **/
@RestController
@RequestMapping("/project/regionCourt")
@RolePermission
public class RegionCourtController extends BaseController {

    @Resource
    private RegionCourtService regionCourtService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> queryListRegionCourt( Page<Object> page, RegionCourtVo regionCourtVo){
            PageInfo pageInfo = regionCourtService.queryListRegionCourt(page, regionCourtVo);
            return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "苑区信息修改")
    public ResponseVO<Object> updateRegionCourt( RegionCourt regionCourt){

        int count =  regionCourtService.updateRegionCourt(regionCourt);
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
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "苑区信息删除")
    public ResponseVO<Object> deleteRegionCourt( String ids){
        int count = regionCourtService.deleteRegionCourt(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
    /**
     * @Author huxin
     * @Description 增加
     * @Date 2018/12/19 17:00
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "苑区信息添加")
    public ResponseVO<Object> addRegionCourt(RegionCourt regionCourt){

       int count =  regionCourtService.insert(regionCourt);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author huxin
     * @Description 根据父id查询所有苑区信息
     * @Date 2018/12/20 18:24
     */
    @GetMapping("queryAllName")
    public ResponseVO<Object> queryRegionCourtNameBySuperId(Long projectId){
        List<Map<String,Object>> list  = regionCourtService.queryRegionCourtNameBySuperId(projectId);
        return ResponseVO.<Object>success().setData(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询所有苑区信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionCourtService.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
