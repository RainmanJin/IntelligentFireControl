package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationJunk;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.RenovationJunkService;
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
 * @Date 2019/1/7 18:02
 * @Description 装修垃圾清理情况
 **/
@RestController
@RequestMapping("/firepatrol/renovationJunk")
public class RenovationJunkController extends BaseController {

    @Autowired

    private RenovationJunkService renovationJunkService;

    /**
     * @Author huxin
     * @Description 增加装修垃圾清理情况
     * @Date 2019/1/7 16:14
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "装修垃圾清理情况添加")
    public ResponseVO<Object> addRenovationJunk( RenovationJunk renovationJunk){
        int count = renovationJunkService.addRenovationJunk(renovationJunk);
        if(count==1){
            return ResponseVO.addSuccess();
        }else if(count==2){
            return ResponseVO.addError().setMsg("添加失败，已经存在数据！！");
        }
        return ResponseVO.addError();
    }
    /**
     * @Author huxin
     * @Description 删除装修垃圾清理情况(含批量)
     * @Date 2019/1/7 16:19
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "装修垃圾清理情况删除")
    public  ResponseVO<Object> deleteaddRenovationJunk(String ids){
        int count =renovationJunkService.deleteaddRenovationJunk(ids);
        if(count>=1){
            return ResponseVO.deleteSuccess();
        }
        return ResponseVO.deleteError();
    }
    /**
     * @Author huxin
     * @Description 修改装修垃圾清理情况
     * @Date 2019/1/7 16:22
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "装修垃圾清理情况修改")
    public ResponseVO<Object> updateRenovationJunk( RenovationJunk renovationJunk){
        int count = renovationJunkService.updateRenovationJunk(renovationJunk);
        if(count==1){
            return ResponseVO.editSuccess();
        }
        return  ResponseVO.editError();
    }
    /**
     * @Author huxin
     * @Description 查询装修垃圾清理情况列表
     * @Date 2019/1/7 16:25
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> listRenovationJunk( Page<Object> page, String keyword, Long recordId){
        PageInfo pageInfo = renovationJunkService.listRenovationJunk(page,keyword,recordId);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询装修垃圾清理情况明细
     * @Date 2019/1/7 16:27
     */
    @GetMapping("findById")
    public ResponseVO<Object> getRenovationJunkFindById(Long id){
        Map<String,Object> map = renovationJunkService.getRenovationJunkFindById(id);
        return ResponseVO.<Object>success().setData(map);
    }
}
