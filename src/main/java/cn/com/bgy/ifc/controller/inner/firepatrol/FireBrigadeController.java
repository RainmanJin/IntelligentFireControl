package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FireBrigadeDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade;
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
@RequestMapping("/firepatrol/fireBrigade")
public class FireBrigadeController extends BaseController {
    @Autowired
    private FireBrigadeDomain fireBrigadeDomain;

    /**
     * @description:分页查询义务消防队建设情况
     * @param: [page, fireBrigade]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade>>
     * @auther: chenlie
     * @date: 2019/1/7 17:24
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<FireBrigade>> queryListByPage(Page<FireBrigade> page, FireBrigade fireBrigade,String keyword) {

        PageInfo<FireBrigade> pageInfo = fireBrigadeDomain.queryListByPage(page, fireBrigade);
        return ResponseVO.<PageInfo<FireBrigade>>success().setData(pageInfo);
    }
    /**
     * @description:根据id查询义务消防队建设情况
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @GetMapping("findById")
    public ResponseVO<FireBrigade> findById(Long id) {

        FireBrigade fireBrigade= fireBrigadeDomain.findById(id);
        return ResponseVO.<FireBrigade>success().setData(fireBrigade);
    }



    /**
     * @description:批量逻辑删除
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade>
     * @auther: chenlie
     * @date: 2019/1/8 10:44
     */
    @PostMapping("deleteData")
    public ResponseVO<Object> deleteData(String ids) {
        if(ids==null|| ids.isEmpty() ){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list= ListUtil.getListId(ids);
        int res= fireBrigadeDomain.deleteBatch(list);
        if(res>0){
            return ResponseVO.deleteSuccess();
        } else{
            return ResponseVO.deleteError();
        }
    }

    /**
     * @description:修改
     * @param: [fireBrigade]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @PostMapping("editData")
    public ResponseVO<Object> editData(FireBrigade fireBrigade) {

        FireBrigade  query =fireBrigadeDomain.findById(fireBrigade.getId());
        CopyUtil.copyProperties(fireBrigade,query);
        int res= fireBrigadeDomain.updateSelective(query);
        if(res>0){
            return ResponseVO.editSuccess();
        } else{
            return ResponseVO.editError();
        }
    }


    /**
     * @description:新增
     * @param: [fireBrigade]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/8 11:28
     */
    @PostMapping("createData")
    public ResponseVO<Object> createData(FireBrigade fireBrigade) {

        int res= fireBrigadeDomain.insert(fireBrigade);
        if(res>0){
            return ResponseVO.addSuccess();
        } else{
            return ResponseVO.addError();
        }
    }
}
