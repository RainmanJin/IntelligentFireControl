package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.RegionStreetVo;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionStreetService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:17
 * @Description 苑区信息
 **/
@Controller
@RequestMapping("/basic/regionStreet")
public class RegionStreetController {

    @Resource
    private RegionStreetService regionStreetService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo<RegionStreetVo>> queryListRegionStreet( Page<RegionStreetVo> page, RegionStreetVo regionStreetVo, String token){
        PageInfo<RegionStreetVo> pageInfo = regionStreetService.queryListRegionStreet(page,regionStreetVo);
        return ResponseVO.<PageInfo<RegionStreetVo>>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "街道信息修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionStreet( RegionStreet regionStreet, String token){

        int count = regionStreetService.updateRegionStreet(regionStreet);
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
    @SystemLogAfterSave(type = 1,description = "街道信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionStreet( String arr, String token){
        int count = regionStreetService.deleteRegionStreet(arr);
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
    @SystemLogAfterSave(type = 1,description = "街道信息添加")
    @ResponseBody
    public ResponseVO<Object> addRegionStreet(RegionStreet regionStreet){

       int count =  regionStreetService.insert(regionStreet);
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
    @PostMapping("queryAllName")
    @ResponseBody
    public ResponseVO<Object> queryRegionStreettNameBySuperId(Long id){
        List<Map<String,Object>> list  = regionStreetService.queryRegionStreetNameBySuperId(id);
        return ResponseVO.<Object>success().setData(list);
    }
}