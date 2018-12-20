package cn.com.bgy.ifc.domain.impl.system.project;

import cn.com.bgy.ifc.dao.system.project.RegionBuildingDao;
import cn.com.bgy.ifc.dao.system.project.RegionStreetDao;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionStreetDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.system.project.RegionStreetVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:20
 * @Description 区域苑区信息DomainImpl
 **/
@Service
public class RegionStreetDomainImpl implements RegionStreetDomain {

    @Resource
    private RegionStreetDao regionStreetDao;

    @Resource
    private RegionBuildingDao regionBuildingDao;
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/19 15:18
     */
    @Override
    public List<RegionStreetVo> queryListRegionStreet( RegionStreetVo record ) {
        return regionStreetDao.queryListRegionStreet(record);
    }

    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/19 15:18
     */
    @Override
    public int insert( RegionStreet record ) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return regionStreetDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 改
     * @Date 2018/12/19 15:18
     */
    @Override
    public int updateRegionStreet( RegionStreet record ) {
        return regionStreetDao.updateRegionStreet(record);

    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/19 15:32
     */
    @Override
    public int deleteRegionStreet( List<Long> list ) {
        if(list.size()>0){
            regionBuildingDao.deleteRegionProjecBySuperId(list);
            return regionStreetDao.deleteRegionStreet(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 根据父级id查询所有街道名
     * @Date 2018/12/20 18:26
     */
    @Override
    public List<Map<String, Object>> queryRegionStreetNameBySuperId( Long id ) {
        return regionStreetDao.queryRegionStreetNameBySuperId(id);
    }
}
