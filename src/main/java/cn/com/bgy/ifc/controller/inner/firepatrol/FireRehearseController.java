package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireRehearseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse;
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
@RequestMapping("/firepatrol/fireRehearse")
public class FireRehearseController extends BaseController {
    @Autowired
    private FireRehearseDomain fireRehearseDomain;

    /**
     * @description:分页查询消防演练及宣传情况
     * @param: [page, fireRehearse]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse>>
     * @auther: chenlie
     * @date: 2019/1/7 17:24
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<FireRehearse>> queryListByPage(Page<FireRehearse> page, FireRehearse fireRehearse,String keyword) {

        PageInfo<FireRehearse> pageInfo = fireRehearseDomain.queryListByPage(page, fireRehearse);
        return ResponseVO.<PageInfo<FireRehearse>>success().setData(pageInfo);
    }
    /**
     * @description:根据id查询消防演练及宣传情况
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @GetMapping("findById")
    public ResponseVO<FireRehearse> findById(Long id) {

        FireRehearse fireRehearse= fireRehearseDomain.findById(id);
        return ResponseVO.<FireRehearse>success().setData(fireRehearse);
    }



    /**
     * @description:批量逻辑删除
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @PostMapping("deleteData")
    public ResponseVO<Object> deleteData(String ids) {
        if(ids==null|| ids.isEmpty() ){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list= ListUtil.getListId(ids);
        int res= fireRehearseDomain.deleteBatch(list);
        if(res>0){
            return ResponseVO.deleteSuccess();
        } else{
            return ResponseVO.deleteError();
        }
    }

    /**
     * @description:修改
     * @param: [fireRehearse]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @PostMapping("editData")
    public ResponseVO<Object> editData(FireRehearse fireRehearse) {

        FireRehearse  query =fireRehearseDomain.findById(fireRehearse.getId());
        CopyUtil.copyProperties(fireRehearse,query);
        int res= fireRehearseDomain.update(query);
        if(res>0){
            return ResponseVO.editSuccess();
        } else{
            return ResponseVO.editError();
        }
    }


    /**
     * @description:新增
     * @param: [fireRehearse]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @PostMapping("createData")
    public ResponseVO<Object> createData(FireRehearse fireRehearse) {

        int res= fireRehearseDomain.insert(fireRehearse);
        if(res>0){
            return ResponseVO.addSuccess();
        } else{
            return ResponseVO.addError();
        }
    }
}
