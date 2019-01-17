package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionBuildingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:17
 * @Description 楼栋信息
 **/
@RestController
@RequestMapping("/project/regionBuilding")
public class RegionBuildingController extends BaseController {

    @Resource
    private RegionBuildingService regionBuildingService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("queryPageData")
    @ResponseBody
    public ResponseVO<PageInfo> queryListRegionBuilding( Page<Object> page, RegionAndBrandVO regionAndBrandVO){
        PageInfo pageInfo = regionBuildingService.queryListRegionBuilding(page,regionAndBrandVO);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "楼栋单元信息修改")
    public ResponseVO<Object> updateRegionBuilding( RegionBuilding regionBuilding){

        int count = regionBuildingService.updateRegionBuilding(regionBuilding);
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
    @SystemLogAfterSave(description = "街道信息删除")
    public ResponseVO<Object> deleteRegionBuilding( String ids){
        int count = regionBuildingService.deleteRegionBuilding(ids);
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
    @SystemLogAfterSave(description = "街道信息添加")
    public ResponseVO<Object> addRegionBuilding(RegionBuilding regionBuilding){

       int count =  regionBuildingService.insert(regionBuilding);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");

    }



    /**
     * @Author huxin
     * @Description 根据ID查询楼栋单元信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionBuildingService.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
