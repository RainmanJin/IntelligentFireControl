package cn.com.bgy.ifc.controller.inner.firepatrol;

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

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/12 10:50
 * @Description 设施故障检测内容
 **/
@RestController
@RequestMapping("/firepatrol/FaultDetection")
public class FaultDetectionController extends BaseController {

    @Autowired
    private FaultDetectionService faultDetectionService;

    /**
     * @Author huxin
     * @Description 添加设施故障检测
     * @Date 2019/1/12 10:57
     */
    @PostMapping("createData")
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
    public ResponseVO<Object> editFaultDetection(RecordTable recordTable){
        int count = faultDetectionService.editFaultDetection(recordTable);
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
    public ResponseVO<Object> deleteFaultDetection(String ids){
        int count = faultDetectionService.deleteFaultDetection(ids);
        if(count==1){
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
    public ResponseVO<PageInfo> listFaultDetection( Page<Object> page,String keyword,Long equipmentTypeId,Integer situation ){
        PageInfo pageInfo = faultDetectionService.listFaultDetection(page,keyword,equipmentTypeId,situation);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询设施故障明细
     * @Date 2019/1/12 11:02
     */
    @GetMapping("find")
    public ResponseVO<Object> getFaultDetectionFindByID( Long id){
        Map<String,Object> map = faultDetectionService.getFaultDetectionFindByID(id);
        return ResponseVO.<Object>success().setData(map);
    }
}