package cn.com.bgy.ifc.domain.impl.system.project;

import cn.com.bgy.ifc.dao.system.project.RegionCourtDao;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionCourtDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.system.project.RegionCourtVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/19 9:20
 * @Description 区域苑区信息DomainImpl
 **/
@Service
public class RegionCourtDomainImpl implements RegionCourtDomain {
    @Resource
    private RegionCourtDao regionCourtDao;
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/19 15:18
     */
    @Override
    public List<RegionCourtVo> queryListRegionCourt( RegionCourtVo regionCourtVo ) {
        return regionCourtDao.queryListRegionCourt(regionCourtVo);
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/19 15:18
     */
    @Override
    public int insert( RegionCourt record ) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return regionCourtDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 改
     * @Date 2018/12/19 15:18
     */
    @Override
    public int updateRegionCourt( RegionCourt record ) {
        return regionCourtDao.updateRegionCourt(record);

    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/19 15:32
     */
    @Override
    public int deleteRegionCourt( List<Long> list ) {
        return regionCourtDao.deleteRegionCourt(list);
    }
}
