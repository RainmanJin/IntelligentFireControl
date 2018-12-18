package cn.com.bgy.ifc.controller.inner.basic.region;

import cn.com.bgy.ifc.domain.interfaces.basic.region.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.basic.region.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.region.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResponseVO<PageInfo<RegionProject>> queryListRegionProject( Page<RegionProject> page, RegionProjectVo regionInfoVo, String token){
        try {
            PageInfo<RegionProject> pageInfo = regionProjectDomain.queryListRegionProjec(page, regionInfoVo);
            return ResponseVO.<PageInfo<RegionProject>>success().setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<PageInfo<RegionProject>>exception();
        }
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
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
    @ResponseBody
    public ResponseVO<Object> deleteRegionProject( String arr, String token){
        int count = regionProjectDomain.deleteRegionProjec(arr);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
}
