package cn.com.bgy.ifc.controller.inner.firepatrol;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FundsDudgetService;
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
 * @Date 2019/2/12 14:08
 * @Description 年度消防经费预算
 **/
@RestController
@RequestMapping("/firepatrol/fundsDudget")
@RolePermission
public class FundsDudgetController extends BaseController {

    @Autowired
    private FundsDudgetService fundsDudgetService;

    /*
     * @Author  huxin
     * @Description 年度消防经费预算分页条件查询（区域、关键字）
     * @param   [page, fundsDudget, keyword]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget>>
     * @Date 2019/2/12 14:13
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo> queryListByPage( Page<Object> page, Long regionId, String keyword) {

        PageInfo pageInfo = fundsDudgetService.queryListByPage(page,regionId,keyword);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
    /*
     * @Author  huxin
     * @Description 根据ID查询明细
     * @param   [id]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget>
     * @Date 2019/2/12 14:14
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {

        Map<String,Object> map= fundsDudgetService.findById(id);
        return ResponseVO.<Object>success().setData(map);
    }
    /*
     * @Author  huxin
     * @Description 批量删除
     * @param   [ids]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/2/12 14:14
     */
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "年度消防经费预算删除")
    public ResponseVO<Object> deleteData(String ids) {

        int count = fundsDudgetService.deleteData(ids);
        if (count > 0) {
            return ResponseVO.deleteSuccess();
        }
        return  ResponseVO.deleteError();
    }
    /*
     * @Author  huxin
     * @Description 年度消防经费预算单条修改
     * @param   [fundsDudget]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/2/12 14:24
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "年度消防经费预算修改")
    public ResponseVO<Object> editData(FundsDudget fundsDudget) {
        int count = fundsDudgetService.editData(fundsDudget);
        if (count == 1) {
            return ResponseVO.editSuccess();
        }
        return ResponseVO.editError();
    }
    /*
     * @Author  huxin
     * @Description 年度消防经费预算新增
     * @param   [fundsDudget]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/2/12 14:24
     */
    @PostMapping("createData")
    @SystemLogAfterSave(description = "年度消防经费预算添加")
    public ResponseVO<Object> createData( FundsDudget fundsDudget){
        int count = fundsDudgetService.createData(fundsDudget);
        if (count ==1) {
            return ResponseVO.addSuccess();
        }else{
            return ResponseVO.addError();
        }
    }
}
