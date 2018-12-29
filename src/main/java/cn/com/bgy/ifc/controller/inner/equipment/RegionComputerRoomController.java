package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionComputerRoomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author huxin
 * @Date 2018/12/19 9:17
 * @Description 机房信息
 **/
@Controller
@RequestMapping("/equipment/computerRoom")
public class RegionComputerRoomController extends BaseController {

    @Resource
    private RegionComputerRoomService regionComputerRoomService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListComputerRoom( Page<Object> page, RegionAndBrandVO regionAndBrandVO){
        Account user=this.getUser();
        PageInfo pageInfo = regionComputerRoomService.queryListRegionComputerRoom(page,regionAndBrandVO,user);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 15:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "机房信息修改")
    @ResponseBody
    public ResponseVO<Object> updateRegionComputerRoom( RegionComputerRoom regionComputerRoom){
        int count = regionComputerRoomService.updateRegionComputerRoom(regionComputerRoom);
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
    @SystemLogAfterSave(type = 1,description = "机房删除")
    @ResponseBody
    public ResponseVO<Object> deleteRegionComputerRoom( String arr){
        int count = regionComputerRoomService.deleteRegionComputerRoom(arr);
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
    @SystemLogAfterSave(type = 1,description = "机房添加")
    @ResponseBody
    public ResponseVO<Object> addRegionComputerRoom(RegionComputerRoom regionComputerRoom){

       int count =  regionComputerRoomService.insert(regionComputerRoom);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");

    }
}
