package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.MaintenanceQualifications;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.MaintenanceQualificationsService;
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
 * @Date 2019/2/12 14:31
 * @Description 自动消防系统委外维修保养资质情况
 **/
@RestController
@RequestMapping("/firepatrol/MaintenanceQualifications")
@RolePermission
public class MaintenanceQualificationsController extends BaseController {

    @Autowired
    private MaintenanceQualificationsService maintenanceQualificationsService;


    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> queryListByPage( Page<Object> page,  Long regionId, String keyword) {

        PageInfo pageInfo = maintenanceQualificationsService.queryListByPage(page,regionId, keyword);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }

    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        Map<String,Object> map = maintenanceQualificationsService.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }

    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "自动消防系统委外维修保养资质情况删除")
    public ResponseVO<Object> deleteData(String ids) {

        int count = maintenanceQualificationsService.deleteData(ids);
        if (count > 0) {
            return ResponseVO.deleteSuccess();
        }
        return  ResponseVO.deleteError();
    }

    @PostMapping("editData")
    @SystemLogAfterSave(description = "自动消防系统委外维修保养资质情况修改")
    public ResponseVO<Object> editData(MaintenanceQualifications maintenanceQualifications ) {
        int count = maintenanceQualificationsService.editData(maintenanceQualifications);
        if (count == 1) {
            return ResponseVO.editSuccess();
        }
        return ResponseVO.editError();
    }

    @PostMapping("createData")
    @SystemLogAfterSave(description = "自动消防系统委外维修保养资质情况添加")
    public ResponseVO<Object> createData( MaintenanceQualifications maintenanceQualifications){
        int count = maintenanceQualificationsService.createData(maintenanceQualifications);
        if (count ==1) {
            return ResponseVO.addSuccess();
        }else{
            return ResponseVO.addError();
        }
    }
}
