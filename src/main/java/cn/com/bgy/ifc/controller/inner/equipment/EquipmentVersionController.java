package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentVersionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/

@Controller
@RequestMapping("/equipment/version")
public class EquipmentVersionController {

    @Autowired
    private EquipmentVersionService equipmentVersionService;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 18:13
     */
    @GetMapping("query")
    @ResponseBody
    public ResponseVO queryListEquipmentVersion( Page<Object> page,Integer brandID,String keyword, String token){
        PageInfo pageInfo = equipmentVersionService.queryListEquipmentVersion(page,brandID,keyword);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 18:13
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "型号信息添加")
    @ResponseBody
    public ResponseVO<Object> addEquipmentVersion( EquipmentVersion record,String token){
        int count = equipmentVersionService.addEquipmentVersion(record);
        if (count > 0) {
            return ResponseVO.success().setMsg("添加成功");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 18:13
     */
    @PostMapping("update")
    @SystemLogAfterSave(type = 1,description = "型号信息修改")
    @ResponseBody
    public ResponseVO<Object> uopdateEquipmentVersion(EquipmentVersion record,String token){
        int count = equipmentVersionService.updateEquipmentVersion(record);
        if (count == 1) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 18:13
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "型号信息删除")
    @ResponseBody
    public ResponseVO<Object>  deleteEquipmentVersion( String arr,String token ){
        int count = equipmentVersionService.deleteEquipmentVersion(arr);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
    /**
     * @Author huxin
     * @Description 根据品牌id查询所有型号
     * @Date 2018/12/25 9:13
     */
    @GetMapping("queryAllName")
    public ResponseVO<Object> queryEquipmentVersionByBrandId(Long id,String token){
        List<Map<String,Object>> list = equipmentVersionService.queryEquipmentVersionByBrandId(id);
        return ResponseVO.success().setData(list);
    }
}
