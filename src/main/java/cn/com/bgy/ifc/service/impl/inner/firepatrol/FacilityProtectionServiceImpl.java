package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FacilityProtection;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FacilityProtectionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/7 18:56
 * @Description 消防设施保护情况
 **/
@Service
public class FacilityProtectionServiceImpl implements FacilityProtectionService {
    /**
     * @Author huxin
     * @Description 增
     * @Date 2019/1/7 18:58
     */
    @Override
    public int addFacilityProtection( FacilityProtection facilityProtection ) {
        return 0;
    }

    /**
     * @Author huxin
     * @Description 删除（含批量）
     * @Date 2019/1/7 18:58
     */
    @Override
    public int deleteFacilityProtection( String ids ) {
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2019/1/7 18:59
     */
    @Override
    public int updateFacilityProtection( FacilityProtection facilityProtection ) {
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询消防设施保护情况（含条件查询）
     * @Date 2019/1/7 19:00
     */
    @Override
    public PageInfo listFacilityProtection( Page<Object> page, String keyword, Long recordId, Date startTime, Date endTime ) {
        return null;
    }
    /**
     * @Author huxin
     * @Description 根据ID查询消防设施保护情况明细
     * @Date 2019/1/7 19:00
     */
    @Override
    public Map<String, Object> getFacilityProtectionFindById( Long id ) {
        return null;
    }
}
