package cn.com.bgy.ifc.controller.inner.fireinspection;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskTrainVo;
import cn.com.bgy.ifc.service.interfaces.inner.fireinspection.FireTaskTrainService;
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

/**
 * @author: ZhangCheng
 * @description:消防培训任务
 * @date: 2019-01-04 12:04
 **/
@RestController
@RequestMapping("/fireInspection/fireTaskTrain")
public class FireTaskTrainController {

    @Autowired
    private FireTaskTrainService fireTaskTrainService;


    /**
     * @author: ZhangCheng
     * @description:消防培训任务分页查询
     * @param: [page, fireTaskTrainVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo       <       cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<FireTaskTrain>> searchPage(Page<FireTaskTrain> page, FireTaskTrainVo fireTaskTrainVo) {
        PageInfo<FireTaskTrain> pageInfo = fireTaskTrainService.queryListByPage(page, fireTaskTrainVo);
        return ResponseVO.<PageInfo<FireTaskTrain>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:消防培训任务ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        FireTaskTrain fireTaskTrain = fireTaskTrainService.findById(id);
        return ResponseVO.success().setData(fireTaskTrain);
    }

    /**
     * @author: ZhangCheng
     * @description:添加消防培训任务
     * @param: [fireTaskTrainVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "添加消防培训任务")
    public ResponseVO<Object> add(@Validated FireTaskTrainVo fireTaskTrainVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        FireTaskTrain fireTaskTrain = new FireTaskTrain();
        CopyUtil.copyProperties(fireTaskTrainVo, fireTaskTrain);
        int result = fireTaskTrainService.insertSelective(fireTaskTrain);
        if (result == 1) {
            return ResponseVO.addSuccess();
        } else {
            return ResponseVO.addError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:修改消防培训任务
     * @param: [fireTaskTrainVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "修改消防培训任务")
    public ResponseVO<Object> edit(@Validated FireTaskTrainVo fireTaskTrainVo, BindingResult error) {
        //做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        FireTaskTrain fireTaskTrain = new FireTaskTrain();
        CopyUtil.copyProperties(fireTaskTrainVo, fireTaskTrain);
        int result = fireTaskTrainService.updateSelective(fireTaskTrain);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:删除消防培训任务
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "删除消防培训任务")
    public ResponseVO<Object> deleteBatch(String ids) {
        if (ids.length() == 0) {
            return ResponseVO.deleteError();
        }
        List<Long> list = ListUtil.getListId(ids);
        int resultCount = fireTaskTrainService.deleteBatch(list);
        if (resultCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }

}
