package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.project.RegionInfoVo;
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
 * @Description 区域信息controller
 * @Date 2018/12/18 15:19
 */
@Controller
@RequestMapping("/basic/regionInfo")
public class RegionInfoController {


    @Autowired
    private RegionInfoDomain regionInfoDomain;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo<RegionInfo>> queryListRegionInfo( Page<RegionInfo> page, RegionInfoVo regionInfoVo, String token){

            PageInfo<RegionInfo> pageInfo = regionInfoDomain.queryListRegionInfo(page, regionInfoVo);
            return ResponseVO.<PageInfo<RegionInfo>>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "区域信息修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionInfo( RegionInfoVo regionInfoVo, String token){

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
    @SystemLogAfterSave(type = 1,description = "区域信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionInfo( String arr, String token){
        int count = regionInfoDomain.deleteRegionInfo(arr);
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
    @SystemLogAfterSave(type = 1,description = "区域信息添加")
    @ResponseBody
    public ResponseVO<Object> insertRegionInfo(RegionInfo regionInfo,String token){
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
    @PostMapping("queryAllName")
    @ResponseBody
    public ResponseVO<Object> queryRegionInfoName(){
        List<Map<String,Object>> list  = regionInfoDomain.queryRegionInfoName();
        return ResponseVO.<Object>success().setData(list);
    }
}
