package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.domain.interfaces.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/18 17:14
 * @Description 区域项目
 **/
@Controller
@RequestMapping("/basic/regionProject")
public class RegionProjectController {

    @Autowired
    private RegionProjectDomain regionProjectDomain;


    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 17:21
     */
    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo<RegionProjectVo>> queryListRegionProject( Page<RegionProjectVo> page, RegionProjectVo regionInfoVo, String token){
            PageInfo<RegionProjectVo> pageInfo = regionProjectDomain.queryListRegionProjec(page, regionInfoVo);
            return ResponseVO.<PageInfo<RegionProjectVo>>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "项目信息修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionProject( RegionProject regionProject, String token){

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
    @SystemLogAfterSave(type = 1,description = "项目信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionProject( String arr, String token){
        int count = regionProjectDomain.deleteRegionProjec(arr);
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
    @SystemLogAfterSave(type = 1,description = "项目信息添加")
    @ResponseBody
    public ResponseVO<Object> insertRegionInfo( RegionProject regionProject, String token){
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
    @PostMapping("queryAllName")
    @ResponseBody
    public ResponseVO<Object> queryRegionProjectName(Long id){
        List<Map<String,Object>> list  = regionProjectDomain.queryRegionProjectNameBySuperId(id);
        return ResponseVO.<Object>success().setData(list);
    }
}