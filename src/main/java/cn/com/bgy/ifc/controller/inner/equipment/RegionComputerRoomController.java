package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyMachineRoomService;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionComputerRoomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:17
 * @Description 机房信息
 **/
@RestController
@RequestMapping("/equipment/computerRoom")
@RolePermission
public class RegionComputerRoomController extends BaseController {

    @Autowired
    private RegionComputerRoomService regionComputerRoomService;

    @Autowired
    private BgyMachineRoomService bgyMachineRoomService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 15:22
     */
    @GetMapping("queryPageData")
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
    @PostMapping("editData")
    @SystemLogAfterSave(description = "机房信息修改")
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
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "机房删除")
    public ResponseVO<Object> deleteRegionComputerRoom( String ids){
        int count = regionComputerRoomService.deleteRegionComputerRoom(ids);
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
    @SystemLogAfterSave(description = "机房添加")
    public ResponseVO<Object> addRegionComputerRoom(RegionComputerRoom regionComputerRoom){

       int count =  regionComputerRoomService.insert(regionComputerRoom);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");

    }

    /**
     * @Author huxin
     * @Description 根据ID查询所有机房信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = regionComputerRoomService.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }

    /**
     * @author: ZhangCheng
     * @description:同步机房数据
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
       return bgyMachineRoomService.baseObtainBgyMachineRoom(1, 1000);
    }
}
