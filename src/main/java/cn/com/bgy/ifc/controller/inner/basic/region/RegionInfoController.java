package cn.com.bgy.ifc.controller.inner.basic.region;

import cn.com.bgy.ifc.domain.interfaces.basic.region.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.basic.region.RegionInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.region.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        try {
            PageInfo<RegionInfo> pageInfo = regionInfoDomain.queryListRegionInfo(page, regionInfoVo);
            return ResponseVO.<PageInfo<RegionInfo>>success().setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<PageInfo<RegionInfo>>exception();
        }
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
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
    @ResponseBody
    public ResponseVO<Object> deleteRegionInfo( String arr, String token){
        int count = regionInfoDomain.deleteRegionInfo(arr);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }

    
}
