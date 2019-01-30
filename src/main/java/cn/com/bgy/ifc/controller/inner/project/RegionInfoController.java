package cn.com.bgy.ifc.controller.inner.project;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.RegionInfoVo;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyRegionInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Description 区域信息controller
 * @Date 2018/12/18 15:19
 */
@RestController
@RequestMapping("/project/regionInfo")
@RolePermission
public class RegionInfoController extends BaseController {

    @Autowired
    private BgyRegionInfoService bgyRegionInfoService;

    @Autowired
    private RegionInfoDomain regionInfoDomain;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> queryListRegionInfo( Page<Object> page, String keyword){
        Account user=this.getUser();
        PageInfo pageInfo = regionInfoDomain.queryListRegionInfo(page, keyword,user);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "区域信息修改")
    public ResponseVO<Object> updateRegionInfo( RegionInfoVo regionInfoVo){

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
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "区域信息删除")
    public ResponseVO<Object> deleteRegionInfo( String  ids){
        int count = regionInfoDomain.deleteRegionInfo(ids);
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
    @SystemLogAfterSave(description = "区域信息添加")
    public ResponseVO<Object> insertRegionInfo(RegionInfo regionInfo){
        int count = regionInfoDomain.insert(regionInfo);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }


    /**
     * @Author huxin
     * @Description 根据ID查询区域信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionInfoDomain.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }

    /**
     * @description:按A-Z首字母顺序查询区域
     * @param: [page, keyword]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo>
     * @auther: chenlie
     * @date: 2019/1/8 15:00
     */
    @GetMapping("queryByCodeSort")
    public ResponseVO<Object> queryByCodeSort( Page<Object> page, String keyword){

        Account user=this.getUser();
        List<Map<String,Object>> list= regionInfoDomain.queryByCodeSort(user);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: ZhangCheng
     * @description:同步区域信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData(){
        Account user=this.getUser();
        Long orgId=user.getOrganizationId();
        return bgyRegionInfoService.baseObtainBgyRegionInfo(1, 100, orgId);
    }

    }
