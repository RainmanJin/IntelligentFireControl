package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.FundsDudgetDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FundsDudgetService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/2/12 14:28
 * @Description 年度消防经费预算Service
 **/
@Service
public class FundsDudgetServiceImpl implements FundsDudgetService{

    @Resource
    private FundsDudgetDao fundsDudgetDao;
    /*
     * @Author  huxin
     * @Description 分页查询
     * @param   [page, regionId, projectId, keyword]
     * @retrue  com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget>
     * @Date 2019/2/12 14:58
     */
    @Override
    public PageInfo queryListByPage( Page<Object> page, Long regionId ,String keyword) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map  = new HashMap<>();
        map.put("regionId",regionId);
        map.put("keyword",keyword);
        List<Map<String,Object>> list = fundsDudgetDao.queryListByPage(map);
        return new PageInfo(list);
    }
    /*
     * @Author  huxin
     * @Description 根据ID查询明细
     * @param   [id]
     * @retrue  cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget
     * @Date 2019/2/12 14:59
     */
    @Override
    public Map<String,Object> findById( Long id ) {
        if(id!=null || id>0){
            return (Map<String, Object>) fundsDudgetDao.findById(id);
        }
        return null;
    }
    /*
     * @Author  huxin
     * @Description 批量删除
     * @param   [ids]
     * @retrue  int
     * @Date 2019/2/12 14:59
     */
    @Override
    public int deleteData( String ids ) {
        if(ids!=null || ids.length()>0){
            List<Long> list = ListUtil.getListId(ids);
            if(list.size()>0){
                return fundsDudgetDao.deleteBatch(list);
            }
        }
        return 0;
    }
    /*
     * @Author  huxin
     * @Description    修改
     * @param   [fundsDudget]
     * @retrue  int
     * @Date 2019/2/12 14:59
     */
    @Override
    public int editData( FundsDudget fundsDudget ) {
        if(fundsDudget.getId()!=null || fundsDudget.getId()>0){
            return fundsDudgetDao.updateSelective(fundsDudget);
        }
        return 0;
    }
    /*
     * @Author  huxin
     * @Description 新增
     * @param   [fundsDudget]
     * @retrue  int
     * @Date 2019/2/12 15:00
     */
    @Override
    public int createData( FundsDudget fundsDudget ) {
        fundsDudget.setLogicRemove(false);
        return fundsDudgetDao.insertSelective(fundsDudget);
    }
}
