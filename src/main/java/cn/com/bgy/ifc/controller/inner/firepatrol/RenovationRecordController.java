package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.RegionByRecord;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationRecord;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.RenovationRecordService;
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
 * @Date 2019/1/5 17:48
 * @Description 装修备案
 **/
@RestController
@RequestMapping("/firepatrol/renovationRecord")
public class RenovationRecordController extends BaseController {

    @Autowired
    private RenovationRecordService renovationRecordService;

    /**
     * @Author huxin
     * @Description 添加装修备案情况
     * @Date 2019/1/5 17:53
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加装修备案")
    public ResponseVO<Object> addRenovationRecord( RegionByRecord regionByRecord, RenovationRecord renovationRecord ){
        int count =renovationRecordService.addRenovationRecord(regionByRecord,renovationRecord);
        if(count==1){
            return  ResponseVO.addSuccess();
        }
        return  ResponseVO.addError();
    }
    /**
     * @Author huxin
     * @Description 修改装修备案情况
     * @Date 2019/1/5 17:53
     */
    @PostMapping("editData")
    public  ResponseVO<Object> updateRenovationRecord(RenovationRecord renovationRecord){
        int count = renovationRecordService.updateRenovationRecord(renovationRecord);
        if(count>0){
            return ResponseVO.editSuccess();
        }
        return  ResponseVO.editError();
    }
    /**
     * @Author huxin
     * @Description 删除装修备案情况
     * @Date 2019/1/5 17:53
     */
    @PostMapping("deleteData")
    public ResponseVO<Object> deleteRenovationRecord(String ids){
       int count = renovationRecordService.deleteRenovationRecord(ids);
       if(count>0){
           return ResponseVO.deleteSuccess();
       }
        return  ResponseVO.deleteError();
    }
    /**
     * @Author huxin
     * @Description 查询装修备案情况
     * @Date 2019/1/5 17:54
     */
    @GetMapping("queryPageData")
    public  ResponseVO<PageInfo> queryRenovationRecordList( Page<Object> page, String keyword, RegionByRecord regionByRecord){
        PageInfo pageInfo = renovationRecordService.queryRenovationRecordList(page,keyword,regionByRecord);
        return  ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询装备案明细
     * @Date 2019/1/5 17:54
     */
    @GetMapping("findById")
    public ResponseVO<Object> queryRenovationRecordInfo(Long id){
        Map<String,Object> map = renovationRecordService.queryRenovationRecordInfo(id);
        return  ResponseVO.<Object>success().setData(map);
    }
}
