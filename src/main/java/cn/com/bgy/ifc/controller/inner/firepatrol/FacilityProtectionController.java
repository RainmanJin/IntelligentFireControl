package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.FacilityProtection;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FacilityProtectionService;
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
 * @Date 2019/1/7 18:51
 * @Description 消防设施保护情况
 **/
@RestController
@RequestMapping("/firepatrol/facilityProtection")
public class FacilityProtectionController extends BaseController {

    @Autowired
    private FacilityProtectionService facilityProtectionService;

    /**
     * @Author huxin
     * @Description 增加消防设施保护情况
     * @Date 2019/1/7 16:14
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "消防设施保护情况添加")
    public ResponseVO<Object> addFacilityProtection( FacilityProtection facilityProtection){
        int count = facilityProtectionService.addFacilityProtection(facilityProtection);
        if(count==1){
            return ResponseVO.addSuccess();
        }else if(count==2){
            return ResponseVO.addError().setMsg("添加失败，已经存在数据！！");
        }
        return ResponseVO.addError();
    }
    /**
     * @Author huxin
     * @Description 删除消防设施保护情况(含批量)
     * @Date 2019/1/7 16:19
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "消防设施保护情况删除")
    public  ResponseVO<Object> deleteFacilityProtection(String ids){
        int count =facilityProtectionService.deleteFacilityProtection(ids);
        if(count>=1){
            return ResponseVO.deleteSuccess();
        }
        return ResponseVO.deleteError();
    }
    /**
     * @Author huxin
     * @Description 修改消防设施保护情况
     * @Date 2019/1/7 16:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(description = "消防设施保护情况修改")
    public ResponseVO<Object> updateFacilityProtection( FacilityProtection facilityProtection){
        int count = facilityProtectionService.updateFacilityProtection(facilityProtection);
        if(count==1){
            return ResponseVO.editSuccess();
        }
        return  ResponseVO.editError();
    }
    /**
     * @Author huxin
     * @Description 查询消防设施保护情况列表
     * @Date 2019/1/7 16:25
     */
    @GetMapping("list")
    public ResponseVO<PageInfo> listFacilityProtection( Page<Object> page, String keyword, Long recordId,Integer state){
        PageInfo pageInfo = facilityProtectionService.listFacilityProtection(page,keyword,recordId,state);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询消防设施保护情况明细
     * @Date 2019/1/7 16:27
     */
    @GetMapping("find")
    public ResponseVO<Object> getFacilityProtectionFindById(Long id){
        Map<String,Object> map = facilityProtectionService.getFacilityProtectionFindById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
