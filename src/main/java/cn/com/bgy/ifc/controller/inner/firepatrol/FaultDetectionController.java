package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FaultDetectionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/12 10:50
 * @Description 设施故障检测内容
 **/
@RestController
@RequestMapping("/firepatrol/faultDetection")
public class FaultDetectionController extends BaseController {

    @Autowired
    private FaultDetectionService faultDetectionService;

    /**
     * @Author huxin
     * @Description 添加设施故障检测
     * @Date 2019/1/12 10:57
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "消防设施故障检测添加")
    public ResponseVO<Object> addFaultDetection( RecordTable recordTable,String recordContent ){
        int count = faultDetectionService.addFaultDetection(recordTable,recordContent);
        if(count==1){
            return ResponseVO.<Object>addSuccess();
        }
        return ResponseVO.<Object>addError();
    }
    /**
     * @Author huxin
     * @Description 修改设施故障检测
     * @Date 2019/1/12 10:57
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "消防设施故障检测修改")
    public ResponseVO<Object> editFaultDetection(RecordTable recordTable,String recordContent){
        int count = faultDetectionService.editFaultDetection(recordTable,recordContent);
        if(count==1){
            return ResponseVO.<Object>editSuccess();
        }
        return ResponseVO.<Object>editError();

    }
    /**
     * @Author huxin
     * @Description 删除设置故障检测
     * @Date 2019/1/12 11:00
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "消防设施故障检测删除")
    public ResponseVO<Object> deleteFaultDetection(String ids){
        int count = faultDetectionService.deleteFaultDetection(ids);
        if(count>=1){
            return ResponseVO.<Object>deleteSuccess();
        }
        return ResponseVO.<Object>deleteError();

    }
    /**
     * @Author huxin
     * @Description 查询设施故障列表
     * @Date 2019/1/12 10:58
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> listFaultDetection( Page<Object> page,String keyword,Long equipmentTypeId,Integer situation,Integer type ){
        PageInfo pageInfo = faultDetectionService.listFaultDetection(page,keyword,equipmentTypeId,situation,type);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询设施故障明细
     * @Date 2019/1/12 11:02
     */
    @GetMapping("findById")
    public ResponseVO<Object> getFaultDetectionFindByID( Long id){
        Map<String,Object> map = faultDetectionService.getFaultDetectionFindByID(id);
        return ResponseVO.<Object>success().setData(map);
    }
    /*
     * @Author  huxin
     * @Description 根据设备ID获取故障检测内容下拉列表       
     * @param   [equipmentId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/1/15 14:26
     */
    @GetMapping("dropDownData")
    public ResponseVO<Object> dropDownDataFindByEquipmentId(Long equipmentId){
        List<RecordTable> list = faultDetectionService.dropDownDataFindByEquipmentId(equipmentId);
        return ResponseVO.<Object>success().setData(list);
    }
}
