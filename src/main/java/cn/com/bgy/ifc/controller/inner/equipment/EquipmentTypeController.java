package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
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
 * @Description 设备类型
 **/

@Controller
@RequestMapping("/equipment/type")
public class EquipmentTypeController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 18:13
     */
    @GetMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListEquipmentType( Page<Object> page, String keyword,String token){
        PageInfo pageInfo = equipmentTypeService.queryListEquipmentType(page,keyword);
        return   ResponseVO.<PageInfo>success().setData(pageInfo);

    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 18:13
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "类型信息添加")
    @ResponseBody
    public ResponseVO<Object> addEEquipmentType( EquipmentType record,String token){
        int count = equipmentTypeService.addEquipmentType(record);
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
    @SystemLogAfterSave(type = 1,description = "类型信息修改")
    @ResponseBody
    public ResponseVO<Object> uopdateEquipmentType(EquipmentType record,String token){
        int count = equipmentTypeService.updateEquipmentType(record);
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
    @SystemLogAfterSave(type = 1,description = "类型信息删除")
    @ResponseBody
    public ResponseVO<Object>  deleteEquipmentType( String arr,String token ){
        int count = equipmentTypeService.deleteEquipmentType(arr);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
    /**
     * @Author huxin
     * @Description 根据父级id查询下级所有节点
     * @Date 2018/12/24 16:33
     */
    @PostMapping("queryBySuperId")
    @ResponseBody
    public ResponseVO<Object> queryEquipmentTypeBySuperId( Long id,String token){
        List<Map<String,Object>> list = equipmentTypeService.queryEquipmentTypeBySuperId(id);
        if(list.size()>0){
            return ResponseVO.success().setData(list);
        }
        return ResponseVO.success().setMsg("没有下级节点");

    }
}
