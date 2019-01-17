package cn.com.bgy.ifc.controller.inner.equipment;


import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentBrandService;
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
 * @Description
 * @Date 2018/12/24 9:12
 */
@RestController
@RequestMapping("/equipment/brand")
public class EquipmentBrandController extends BaseController {

    @Autowired
    private EquipmentBrandService equipmentBrandService;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 18:13
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> queryListEquipmentBrand( Page<Object> page, String keyword){
        PageInfo pageInfo = equipmentBrandService.queryListEquipmentBrand(page,keyword);
        return   ResponseVO.<PageInfo>success().setData(pageInfo);

    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 18:13
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "型号信息添加")
    public ResponseVO<Object> addEEquipmentBrand( EquipmentBrand record){
        int count = equipmentBrandService.addEquipmentBrand(record);
        if (count ==1) {
            return ResponseVO.addSuccess();
        }else{
            return ResponseVO.addError();
        }
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 18:13
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "型号信息修改")
    public ResponseVO<Object> uopdateEquipmentBrand( EquipmentBrand record){
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
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "型号信息删除")
    public ResponseVO<Object>  deleteEquipmentBrand( String ids ){
        int count = equipmentBrandService.deleteEquipmentBrand(ids);
        if (count > 0) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }

    /**
     * @Author huxin
     * @Description 根据ID查询品牌信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id){
        Map<String,Object> map  = equipmentBrandService.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
