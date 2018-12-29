package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.RegionCourtVo;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionCourtService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:17
 * @Description 苑区信息
 **/
@Controller
@RequestMapping("/project/regionCourt")
public class RegionCourtController extends BaseController {

    @Resource
    private RegionCourtService regionCourtService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListRegionCourt( Page<Object> page, RegionCourtVo regionCourtVo){
            PageInfo pageInfo = regionCourtService.queryListRegionCourt(page, regionCourtVo);
            return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "苑区信息修改")
    @ResponseBody
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
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "苑区信息删除")
    @ResponseBody
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
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "苑区信息添加")
    @ResponseBody
    public ResponseVO<Object> addRegionCourt(RegionCourt regionCourt){

       int count =  regionCourtService.insert(regionCourt);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author huxin
     * @Description 根据父id查询所有街道信息
     * @Date 2018/12/20 18:24
     */
    @GetMapping("queryAllName")
    @ResponseBody
    public ResponseVO<Object> queryRegionCourtNameBySuperId(Long projectId){
        List<Map<String,Object>> list  = regionCourtService.queryRegionCourtNameBySuperId(projectId);
        return ResponseVO.<Object>success().setData(list);
    }

}
