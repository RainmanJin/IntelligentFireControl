package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huxin
 * @Date 2019/1/5 17:48
 * @Description 装修备案
 **/
@RestController
@RequestMapping("/firepatrol/RenovationRecord")
public class RenovationRecordController extends BaseController {
    /**
     * @Author huxin
     * @Description 添加装修备案情况
     * @Date 2019/1/5 17:53
     */
    @PostMapping("/add")
    public ResponseVO<Object> addRenovationRecord(){
        return  null;
    }
    /**
     * @Author huxin
     * @Description 修改装修备案情况
     * @Date 2019/1/5 17:53
     */
    @PostMapping("edit")
    public  ResponseVO<Object> editRenovationRecord(){
        return  null;
    }
    /**
     * @Author huxin
     * @Description 删除装修备案情况
     * @Date 2019/1/5 17:53
     */
    @PostMapping("delete")
    public ResponseVO<Object> deleteRenovationRecord(String ids){
        return  null;
    }
    /**
     * @Author huxin
     * @Description 查询装修备案情况
     * @Date 2019/1/5 17:54
     */
    @GetMapping("queryList")
    public  ResponseVO<Object> queryRenovationRecordList(){
        return  null;
    }
    /**
     * @Author huxin
     * @Description 根据ID查询装备案明细
     * @Date 2019/1/5 17:54
     */
    @GetMapping("find")
    public ResponseVO<Object> queryRenovationRecordInfo(Long id){
        return  null;
    }
}
