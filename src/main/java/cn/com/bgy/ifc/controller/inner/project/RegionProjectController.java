package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/18 17:14
 * @Description 区域项目
 **/
@RestController
@RequestMapping("/project/regionProject")
public class RegionProjectController extends BaseController {

    @Autowired
    private RegionProjectDomain regionProjectDomain;


    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 17:21
     */
    @GetMapping("queryPageData")
    @ResponseBody
    public ResponseVO<PageInfo> queryListRegionProject( Page<Object> page,Long regionId , String keyword){
            PageInfo pageInfo = regionProjectDomain.queryListRegionProject(page, regionId,keyword);
            return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "项目信息修改")
    public ResponseVO<Object> updateRegionProject( RegionProject regionProject){

        int count = regionProjectDomain.updateRegionProject(regionProject);
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
    @SystemLogAfterSave(description = "项目信息删除")
    public ResponseVO<Object> deleteRegionProject( String ids){
        int count = regionProjectDomain.deleteRegionProject(ids);
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
    @PostMapping("createData")
    @SystemLogAfterSave(description = "项目信息添加")
    public ResponseVO<Object> insertRegionInfo( RegionProject regionProject){
        int count = regionProjectDomain.insert(regionProject);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }


    /**
     * @Author huxin
     * @Description 根据ID查询当前项目所有信息
     * @Date 2019/1/2 9:29
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionProjectDomain.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
    /**
     * @description:按A-Z首字母顺序查询区域项目
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 15:51
     */
    @GetMapping("queryProjectByCodeSort")
    public ResponseVO<Object> queryProjectByCodeSort(Long id){

        List<Map<String,Object>> list= regionProjectDomain.queryByCodeSort(id);

        return ResponseVO.<Object>success().setData(list);
    }
}
