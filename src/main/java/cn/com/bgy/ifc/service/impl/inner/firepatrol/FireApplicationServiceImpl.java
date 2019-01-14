package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.FireApplicationDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FireApplication;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FireApplicationService;
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
 * @Date 2019/1/8 9:22
 * @Description 动火证申请情况
 **/
@Service
public class FireApplicationServiceImpl implements FireApplicationService {

    @Resource
    private FireApplicationDao fireApplicationDao;

    /**
     * @Author huxin
     * @Description 添加
     * @Date 2019/1/8 9:27
     */
    @Override
    public int addFireApplication( FireApplication fireApplication ) {
        if(fireApplication.getRecordId()!=null && fireApplication.getRecordId()>0){
            FireApplication  f = fireApplicationDao.queryByRecordId(fireApplication.getRecordId());
            if(null==f){
                fireApplication.setCreateTime(new Date());
                fireApplication.setLogicRemove(false);
                return fireApplicationDao.insertSelective(fireApplication);
            }
            return 2;

        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 删除（含批量）
     * @Date 2019/1/8 9:27
     */
    @Override
    public int deleteFireApplication( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return fireApplicationDao.deleteBatch(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2019/1/8 9:27
     */
    @Override
    public int updateFireApplication( FireApplication renovationJunk ) {
        if(renovationJunk.getId() !=null && renovationJunk.getId()>0){
            renovationJunk.setCreateTime(new Date());
            return fireApplicationDao.updateSelective(renovationJunk);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询动火证申请情况列表（含条件查询）
     * @Date 2019/1/8 9:28
     */
    @Override
    public PageInfo listFireApplication( Page<Object> page, String keyword, Long recordId ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map  = new HashMap<>();
        map.put("keyword",keyword);
        map.put("recordId",recordId);
        List<Map<String,Object>> list  = fireApplicationDao.listFireApplication(map);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询
     * @Date 2019/1/8 9:28
     */
    @Override
    public Map<String, Object> getFireApplicationById( Long id ) {
        if(id!=null && id>0){
            return (Map<String, Object>) fireApplicationDao.findById(id);
        }
        return null;
    }
}
