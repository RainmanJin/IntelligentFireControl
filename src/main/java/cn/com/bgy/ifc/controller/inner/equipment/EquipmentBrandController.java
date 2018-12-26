package cn.com.bgy.ifc.controller.inner.equipment;


import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentBrandService;
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
 * @Description
 * @Date 2018/12/24 9:12
 */
@Controller
@RequestMapping("/basic/brand")
public class EquipmentBrandController {

    @Autowired
    private EquipmentBrandService equipmentBrandService;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 18:13
     */
    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo> queryListEquipmentBrand( Page<Object> page, String keyword,String token){
        PageInfo pageInfo = equipmentBrandService.queryListEquipmentBrand(page,keyword);
        return   ResponseVO.<PageInfo>success().setData(pageInfo);

    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 18:13
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "型号信息添加")
    @ResponseBody
    public ResponseVO<Object> addEEquipmentBrand( EquipmentBrand record, String token){
        int count = equipmentBrandService.addEquipmentBrand(record);
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
    public ResponseVO<Object> uopdateEquipmentBrand( EquipmentBrand record, String token){
        int count = equipmentBrandService.updateEquipmentBrand(record);
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
    public ResponseVO<Object>  deleteEquipmentBrand( String arr,String token ){
        int count = equipmentBrandService.deleteEquipmentBrand(arr);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }
    /**
     * @Author huxin
     * @Description 查询所有设备品牌
     * @Date 2018/12/24 10:27
     */
    @PostMapping("queryAllBrand")
    @ResponseBody
    public ResponseVO<Object> queryAllEquipmentBrand(String token ){
        List<Map<String,Object>> list =  equipmentBrandService.queryAllEquipmentBrand();
        return ResponseVO.success().setData(list);
    }
}
