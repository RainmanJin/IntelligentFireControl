package cn.com.bgy.ifc.service.impl.inner.projects;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.project.RegionBuildingDao;
import cn.com.bgy.ifc.domain.interfaces.project.RegionBuildingDomain;
import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionBuildingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 楼栋单元信息
 **/
@Service
public class RegionBuildingServiceImpl implements RegionBuildingService {

    @Autowired
    private RegionBuildingDomain regionBuildingDomain;

    @Resource
    private RegionBuildingDao regionBuildingDao;
    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/20 9:28
     */

    @Override
    public PageInfo queryListRegionBuilding( Page page, RegionAndBrandVO regionAndBrandVO ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Map<String,Object>> list=  regionBuildingDomain.queryListRegionBuilding(regionAndBrandVO);
        return  new PageInfo(list);
    }

    /**
     * @Author huxin
     * @Description 增加楼栋单元信息
     * @Date 2018/12/20 9:30
     */
    @Override
    public int insert( RegionBuilding record ) {
        return regionBuildingDomain.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改楼栋单元信息
     * @Date 2018/12/20 9:30
     */
    @Override
    public int updateRegionBuilding( RegionBuilding record ) {
        record.setCreateTime(new Date());
        return regionBuildingDomain.updateRegionStreet(record);
    }

    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/19 10:43
     */
    @Override
    public int deleteRegionBuilding( String str ) {

        List<Long> list = ListUtil.getListId(str);

        if(list.size()>0){
            return regionBuildingDomain.deleteRegionStreet(list);
        }
        return 0;


    }
    /**
     * @Author huxin
     * @Description 根据父id查询所有街道名
     * @Date 2018/12/20 19:34
     */
    @Override
    public List<Map<String, Object>> queryRegionBuildingNameBySuperId( Long id ) {
        return regionBuildingDomain.queryRegionBuildingtNameBySuperId(id);
    }

    @Override
    public Map<String, Object> findById( Long id ) {
        if(id != null||id>0){
           return (Map<String, Object>) regionBuildingDao.findById(id );
        }
        return null;
    }


}
