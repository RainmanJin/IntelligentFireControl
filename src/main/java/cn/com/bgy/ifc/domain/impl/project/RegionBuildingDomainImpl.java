package cn.com.bgy.ifc.domain.impl.project;

import cn.com.bgy.ifc.dao.project.RegionBuildingDao;
import cn.com.bgy.ifc.dao.project.RegionComputerRoomDao;
import cn.com.bgy.ifc.domain.interfaces.project.RegionBuildingDomain;
import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:20
 * @Description 区域苑区信息DomainImpl
 **/
@Service
public class RegionBuildingDomainImpl implements RegionBuildingDomain {

    @Resource
    private RegionBuildingDao regionBuildingDao;

    @Resource
    private RegionComputerRoomDao regionComputerRoomDao;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/20 9:23
     */
    @Override
    public List<Map<String,Object>> queryListRegionBuilding( RegionAndBrandVO regionAndBrandVO ) {
        return regionBuildingDao.queryListRegionBuilding(regionAndBrandVO);
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/20 9:23
     */
    @Override
    public int insert( RegionBuilding record ) {
        Date time = new Date();
        record.setCreateTime(time);
        record.setLogicRemove(false);
        return regionBuildingDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 改
     * @Date 2018/12/20 9:24
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int updateRegionStreet( RegionBuilding record ) {
        if(record.getId()!=null){
            Map<String,Object> map  = new HashMap<>();
            map.put("regionId",record.getRegionId());
            map.put("projectId",record.getProjectId());
            map.put("courtId",record.getCourtId());
            map.put("streetId",record.getStreetId());
            map.put("buildingId",record.getId());
            //修改机房
            regionComputerRoomDao.updateFindByAddressId(map);
            record.setCreateTime(new Date());
            return regionBuildingDao.updateRegionBuilding(record);
        }
        return 0;
    }

    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/19 15:32
     */
    @Override
    public int deleteRegionStreet( List<Long> list ) {
        return regionBuildingDao.deleteRegionBuilding(list);
    }
    /**
     * @Author huxin
     * @Description 根据父级id查询所楼栋单元名
     * @Date 2018/12/20 18:26
     */
    @Override
    public List<Map<String, Object>> queryRegionBuildingtNameBySuperId( Long id ) {
        return regionBuildingDao.queryRegionBuildingtNameBySuperId(id);
    }
}
