package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/18 17:14
 * @Description 区域项目
 **/
@Controller
@RequestMapping("/project/regionProject")
public class RegionProjectController extends BaseController {

    @Autowired
    private RegionProjectDomain regionProjectDomain;


    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 17:21
     */
    @GetMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListRegionProject( Page<Object> page,Long regionId , String keyword){
            PageInfo pageInfo = regionProjectDomain.queryListRegionProjec(page, regionId,keyword);
            return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(description = "项目信息修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionProject( RegionProject regionProject){

        int count = regionProjectDomain.updateRegionProjec(regionProject);
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
    @SystemLogAfterSave(description = "项目信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionProject( String ids){
        int count = regionProjectDomain.deleteRegionProjec(ids);
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
    @SystemLogAfterSave(description = "项目信息添加")
    @ResponseBody
    public ResponseVO<Object> insertRegionInfo( RegionProject regionProject){
        int count = regionProjectDomain.insert(regionProject);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }

    /**
     * @Author huxin
     * @Description 根据父id查询所有项目名
     * @Date 2018/12/20 18:24
     */
    @GetMapping("queryAllName")
    @ResponseBody
    public ResponseVO<Object> queryRegionProjectName(Long regionId){
        List<Map<String,Object>> list  = regionProjectDomain.queryRegionProjectNameBySuperId(regionId);
        return ResponseVO.<Object>success().setData(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询当前项目所有信息
     * @Date 2019/1/2 9:29
     */
    @GetMapping("find")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionProjectDomain.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
