package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.ExtinguisherConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.ExtinguisherConfigService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 16:12
 * @Description 灭火器配置情况
 **/
@RestController
@RequestMapping("/firepatrol/extinguisherConfig")
public class ExtinguisherConfigController extends BaseController {

    @Autowired
    private ExtinguisherConfigService extinguisherConfigService;

    /**
     * @Author huxin
     * @Description 增加灭火器配置
     * @Date 2019/1/7 16:14
     */
    @PostMapping("add")
    @SystemLogAfterSave(description = "灭火器配置情况添加")
    public ResponseVO<Object> addExtinguisherConfig( ExtinguisherConfig extinguisherConfig){
        int count = extinguisherConfigService.addExtinguisherConfig(extinguisherConfig);
        if(count==1){
            return ResponseVO.addSuccess();
        }else if(count==2){
            return ResponseVO.addError().setMsg("添加失败，已经存在数据！！");
        }
        return ResponseVO.addError();
    }
    /**
     * @Author huxin
     * @Description 删除灭火器配置情况(含批量)
     * @Date 2019/1/7 16:19
     */
    @PostMapping("delete")
    @SystemLogAfterSave(description = "灭火器配置情况删除")
    public  ResponseVO<Object> deleteExtinguisherConfig(String ids){
        int count =extinguisherConfigService.deleteExtinguisherConfig(ids);
        if(count>=1){
            return ResponseVO.deleteSuccess();
        }
        return ResponseVO.deleteError();
    }
    /**
     * @Author huxin
     * @Description 修改灭火器配置情况
     * @Date 2019/1/7 16:22
     */
    @PostMapping("update")
    @SystemLogAfterSave(description = "灭火器配置情况修改")
    public ResponseVO<Object> updateExtinguisherConfig(ExtinguisherConfig extinguisherConfig){
        int count = extinguisherConfigService.updateExtinguisherConfig(extinguisherConfig);
        if(count==1){
            return ResponseVO.editSuccess();
        }
        return  ResponseVO.editError();
    }
    /**
     * @Author huxin
     * @Description 查询灭火器配置列表
     * @Date 2019/1/7 16:25
     */
    @GetMapping("list")
    public ResponseVO<PageInfo> listExtinguisherConfig( Page<Object> page, String keyword, Long recordId, Date startTime, Date endTime){
        PageInfo pageInfo = extinguisherConfigService.listExtinguisherConfig(page,keyword,recordId,startTime,endTime);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询灭火器配置明细
     * @Date 2019/1/7 16:27
     */
    @GetMapping("find")
    public ResponseVO<Object> getExtinguisherConfigFindById(Long id){
        Map<String,Object> map = extinguisherConfigService.getExtinguisherConfigFindById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
