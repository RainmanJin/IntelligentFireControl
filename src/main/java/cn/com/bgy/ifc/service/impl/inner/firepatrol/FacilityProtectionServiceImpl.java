package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.FacilityProtectionDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FacilityProtection;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FacilityProtectionService;
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
 * @Date 2019/1/7 18:56
 * @Description 消防设施保护情况
 **/
@Service
public class FacilityProtectionServiceImpl implements FacilityProtectionService {

    @Resource
    private FacilityProtectionDao facilityProtectionDao;
    /**
     * @Author huxin
     * @Description 增
     * @Date 2019/1/7 18:58
     */
    @Override
    public int addFacilityProtection( FacilityProtection facilityProtection ) {
        if(facilityProtection.getRecordId()!=null && facilityProtection.getRecordId()>0){
            FacilityProtection f = facilityProtectionDao.queryByRecordId(facilityProtection.getRecordId());
            if(null==f){
                facilityProtection.setCreateTime(new Date());
                facilityProtection.setLogicRemove(false);
                return facilityProtectionDao.insertSelective(facilityProtection);
            }
            return 2;
        }
        return 0;
    }

    /**
     * @Author huxin
     * @Description 删除（含批量）
     * @Date 2019/1/7 18:58
     */
    @Override
    public int deleteFacilityProtection( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return facilityProtectionDao.deleteBatch(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2019/1/7 18:59
     */
    @Override
    public int updateFacilityProtection( FacilityProtection facilityProtection ) {
        if(facilityProtection.getId()!=null && facilityProtection.getId()>0){
            facilityProtection.setCreateTime(new Date());
            return facilityProtectionDao.updateSelective(facilityProtection);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询消防设施保护情况（含条件查询）
     * @Date 2019/1/7 19:00
     */
    @Override
    public PageInfo listFacilityProtection( Page<Object> page, String keyword, Long recordId,Integer state ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        map.put("recordId",recordId);
        map.put("state",state);
        List<Map<String,Object>> list = facilityProtectionDao.listFacilityProtection(map);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询消防设施保护情况明细
     * @Date 2019/1/7 19:00
     */
    @Override
    public Map<String, Object> getFacilityProtectionFindById( Long id ) {
        if(id!=null && id>0){
            return (Map<String, Object>) facilityProtectionDao.findById(id);
        }
        return null;
    }
}
