package cn.com.bgy.ifc.controller.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentTypeVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备类型
 **/

@RestController
@RequestMapping("/equipment/type")
public class EquipmentTypeController extends BaseController {

    @Autowired
    private EquipmentTypeService equipmentTypeService;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/21 18:13
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentType>> queryListEquipmentType(Page<EquipmentType> page, EquipmentTypeVo equipmentTypeVo){
        PageInfo<EquipmentType> pageInfo = equipmentTypeService.queryListByPage(page,equipmentTypeVo);
        return   ResponseVO.<PageInfo<EquipmentType>>success().setData(pageInfo);

    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/21 18:13
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "设备类型信息添加")
    public ResponseVO<Object> createData(@Validated EquipmentTypeVo equipmentTypeVo, BindingResult error){
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentType equipmentType=new EquipmentType();
        CopyUtil.copyProperties(equipmentTypeVo,equipmentType);
        int count = equipmentTypeService.insertSelective(equipmentType);
        if (count == 1) {
            return ResponseVO.addSuccess();
        }
        return ResponseVO.addError();
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/21 18:13
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "设备类型信息修改")
    public ResponseVO<Object> editData(@Validated EquipmentTypeVo equipmentTypeVo, BindingResult error){
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        EquipmentType equipmentType=new EquipmentType();
        CopyUtil.copyProperties(equipmentTypeVo,equipmentType);
        int count=equipmentTypeService.updateSelective(equipmentType);
        if (count == 1) {
            return ResponseVO.editSuccess();
        }
        return ResponseVO.editError();
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/21 18:13
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "设备类型信息删除")
    public ResponseVO<Object>  deleteEquipmentType(String ids){
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = equipmentTypeService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        }
        return ResponseVO.deleteError();
    }

    /**
     * @author: ZhangCheng
     * @description:设备类型启用操作
     * @param: [equipmentTypeVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("forbidden")
    @SystemLogAfterSave(description = "设备类型启用操作")
    public ResponseVO<Object> forbidden(EquipmentTypeVo equipmentTypeVo) {
        EquipmentType equipmentType=new EquipmentType();
        CopyUtil.copyProperties(equipmentTypeVo,equipmentType);
        int count=equipmentTypeService.updateSelective(equipmentType);
        if (count == 1) {
            return ResponseVO.success().setMsg("操作成功");
        }
        return ResponseVO.error().setMsg("操作失败！");
    }

    /**
     * @Author huxin
     * @Description 根据父级id查询下级所有节点
     * @Date 2018/12/24 16:33
     */
    @GetMapping("queryBySuperId")
    public ResponseVO<Object> queryEquipmentTypeBySuperId( Long id){
        List<Map<String,Object>> list = equipmentTypeService.queryEquipmentTypeBySuperId(id);
        if(list.size()>0){
            return ResponseVO.success().setData(list);
        }
        return ResponseVO.success().setMsg("没有下级节点");

    }
    /**
     * @Author huxin
     * @Description 根据ID查询类型信息
     * @Date 2019/1/2 9:44
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id){
        EquipmentType equipmentType  = equipmentTypeService.findById(id);
        return ResponseVO.<Object>success().setData(equipmentType);
    }


}
