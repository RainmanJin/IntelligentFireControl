package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.RenovationJunkDao;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationJunk;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.RenovationJunkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 18:05
 * @Description 装修垃圾清理情况
 **/
@Service
public class RenovationJunkServiceImpl implements RenovationJunkService {

    @Resource
    private RenovationJunkDao renovationJunkDao;

    /**
     * @Author huxin
     * @Description 增
     * @Date 2019/1/7 18:13
     */
    @Override
    public int addRenovationJunk( RenovationJunk renovationJunk ) {
        if(renovationJunk.getRecordId()!=null || renovationJunk.getRecordId()>0){
            RenovationJunk  r = renovationJunkDao.queryByRecordId(renovationJunk.getRecordId());
            if(null==r){
                renovationJunk.setCreateTime(new Date());
                renovationJunk.setLogicRemove(false);
                return renovationJunkDao.insertSelective(renovationJunk);
            }
            return 2;
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 删除（含批量）
     * @Date 2019/1/7 18:13
     */
    @Override
    public int deleteaddRenovationJunk( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return renovationJunkDao.deleteBatch(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2019/1/7 18:13
     */
    @Override
    public int updateRenovationJunk( RenovationJunk renovationJunk ) {
        if(renovationJunk.getId()!=null || renovationJunk.getId()>0){
            renovationJunk.setCreateTime(new Date());
            return renovationJunkDao.updateSelective(renovationJunk);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询列表
     * @Date 2019/1/7 18:13
     */
    @Override
    public PageInfo listRenovationJunk( Page<Object> page, String keyword, Long recordId ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("recordId",recordId);
        map.put("keyword",keyword);
        List<Map<String,Object>> list = renovationJunkDao.listRenovationJunk(map);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询明细
     * @Date 2019/1/7 18:14
     */
    @Override
    public Map<String, Object> getRenovationJunkFindById( Long id ) {
        if(id!=null||id>0){
            return (Map<String, Object>) renovationJunkDao.findById(id);
        }
        return null;
    }
}
