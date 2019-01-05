package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentInfoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 11:04
 * @Description 设备信息
 **/
@Controller
@RequestMapping("/equipment/index")
public class EquipmentInfoController {

    @Autowired
    private EquipmentInfoService equipmentInfoService;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/21 11:08
     */
    @GetMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListEquipmentInfo( Page<Object> page, RegionAndBrandVO regionAndBrandVO){
        PageInfo pageInfo = equipmentInfoService.queryListEquipmentInfo(page,regionAndBrandVO);
        return  ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**e
     * @Author huxin
     * @Description 增加
     * @Date 2018/12/21 11:09
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "设备信息添加")
    @ResponseBody
    public ResponseVO<Object> addEquipmentInfo( EquipmentInfo equipmentInfo){
        int count = equipmentInfoService.addEquipmentInfo(equipmentInfo);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 11:10
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "设备信息修改")
    @ResponseBody
    public ResponseVO<Object> updateEquipmentInfo(EquipmentInfo equipmentInfo){
        int count = equipmentInfoService.updateEquipmentInfo(equipmentInfo);
        if (count == 1) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 11:10
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "设备信息删除")
    @ResponseBody
    public ResponseVO<Object> deleteEquipmentInfo(String ids){

        int count = equipmentInfoService.deleteEquipmentInfo(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }

    /**
     * @Author huxin
     * @Description 根据一个设备id查询设备数据
     * @Date 2018/12/24 15:52
     */
    @GetMapping("find")
    @ResponseBody
    public ResponseVO<Object> queryEquipmentInfoById(Long id){

        Map<String,Object> map = equipmentInfoService.queryEquipmentInfoById(id);
        return ResponseVO.success().setData(map);
    }

}
