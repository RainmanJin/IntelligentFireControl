package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireAccidentDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireAccident;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/firepatrol/fireAccident")
public class FireAccidentController extends BaseController {
    @Autowired
    private FireAccidentDomain fireAccidentDomain;

    /**
     * @description:分页查询火灾事故情况
     * @param: [page, fireAccident]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>>
     * @auther: chenlie
     * @date: 2019/1/7 17:24
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<FireAccident>> queryListByPage(Page<FireAccident> page, FireAccident fireAccident,String keyword) {

        PageInfo<FireAccident> pageInfo = fireAccidentDomain.queryListByPage(page, fireAccident);
        return ResponseVO.<PageInfo<FireAccident>>success().setData(pageInfo);
    }
    /**
     * @description:根据id查询火灾事故情况
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @GetMapping("findById")
    public ResponseVO<FireAccident> findById(Long id) {

        FireAccident fireAccident= fireAccidentDomain.findById(id);
        return ResponseVO.<FireAccident>success().setData(fireAccident);
    }



    /**
     * @description:批量逻辑删除
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FireAccident>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @PostMapping("deleteData")
    public ResponseVO<Object> deleteData(String ids) {
        if(ids==null|| ids.isEmpty() ){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list= ListUtil.getListId(ids);
        int res= fireAccidentDomain.deleteBatch(list);
        if(res>0){
            return ResponseVO.deleteSuccess();
        } else{
            return ResponseVO.deleteError();
        }
    }

    /**
     * @description:修改火灾事故情况
     * @param: [fireAccident]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @PostMapping("editData")
    public ResponseVO<Object> editData(FireAccident fireAccident) {

        FireAccident  query =fireAccidentDomain.findById(fireAccident.getId());
        CopyUtil.copyProperties(fireAccident,query);
        int res= fireAccidentDomain.update(query);
        if(res>0){
            return ResponseVO.editSuccess();
        } else{
            return ResponseVO.editError();
        }
    }


    /**
     * @description:新增火灾事故情况
     * @param: [fireAccident]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @PostMapping("createData")
    public ResponseVO<Object> createData(FireAccident fireAccident) {

        int res= fireAccidentDomain.insert(fireAccident);
        if(res>0){
            return ResponseVO.addSuccess();
        } else{
            return ResponseVO.addError();
        }
    }
}
