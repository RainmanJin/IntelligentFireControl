package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.ExtinguisherConfigDao;
import cn.com.bgy.ifc.entity.po.firepatrol.ExtinguisherConfig;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.ExtinguisherConfigService;
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
 * @Date 2019/1/7 16:17
 * @Description 灭火器配置情况
 **/
@Service
public class ExtinguisherConfigServiceImpl implements ExtinguisherConfigService {

    @Resource
    private ExtinguisherConfigDao extinguisherConfigDao;

    /**
     * @Author huxin
     * @Description 添加灭火器配置情况
     * @Date 2019/1/7 16:41
     */
    @Override
    public int addExtinguisherConfig( ExtinguisherConfig extinguisherConfig ) {
        if(extinguisherConfig.getRecordId() != null && extinguisherConfig.getRecordId()>0){
            return extinguisherConfigDao.insert(extinguisherConfig);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 删除灭火器配置情况（含批量）
     * @Date 2019/1/7 16:42
     */
    @Override
    public int deleteExtinguisherConfig( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return extinguisherConfigDao.deleteBatch(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改灭火器配置情况
     * @Date 2019/1/7 16:42
     */
    @Override
    public int updateExtinguisherConfig( ExtinguisherConfig extinguisherConfig ) {
        if(extinguisherConfig.getId()!=null || extinguisherConfig.getId()>0){
            extinguisherConfig.setCreateTime(new Date());
            return extinguisherConfigDao.updateSelective(extinguisherConfig);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询灭火器配置情况列表
     * @Date 2019/1/7 16:43
     */
    @Override
    public PageInfo listExtinguisherConfig( Page<Object> page,String keyword, Long recordId, Date startTime, Date endTime) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        map.put("recordId",recordId);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        List<Map<String,Object>> list = extinguisherConfigDao.listExtinguisherConfig(map);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description
     * @Date 2019/1/7 16:43
     */
    @Override
    public Map<String, Object> getExtinguisherConfigFindById( Long id ) {
        if(id != null || id>0){
            return (Map<String, Object>) extinguisherConfigDao.findById(id);
        }
        return null;
    }
}
