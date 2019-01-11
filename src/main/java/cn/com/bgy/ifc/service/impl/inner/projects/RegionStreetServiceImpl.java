package cn.com.bgy.ifc.service.impl.inner.projects;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.project.RegionStreetDao;
import cn.com.bgy.ifc.domain.interfaces.project.RegionStreetDomain;
import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.project.RegionStreetVo;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionStreetService;
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
 * @Description 街道信息
 **/
@Service
public class RegionStreetServiceImpl implements RegionStreetService {

    @Autowired
    private RegionStreetDomain regionStreetDomain;

    @Resource
    private RegionStreetDao regionStreetDao;
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/19 10:43
     */
    @Override
    public PageInfo queryListRegionStreet( Page page, RegionStreetVo record ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Map<String,Object>> list=  regionStreetDomain.queryListRegionStreet(record);
        return  new PageInfo(list);
    }

    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/19 10:43
     */
    @Override
    public int insert( RegionStreet record ) {
        return regionStreetDomain.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/19 10:43
     */
    @Override
    public int updateRegionStreet( RegionStreet record ) {
        record.setCreateTime(new Date());
        return regionStreetDomain.updateRegionStreet(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/19 10:43
     */
    @Override
    public int deleteRegionStreet( String str ) {

        List<Long> list = ListUtil.getListId(str);

        if(list.size()>0){
            return regionStreetDomain.deleteRegionStreet(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 根据父id查询所有街道名
     * @Date 2018/12/20 19:34
     */
    @Override
    public List<Map<String, Object>> queryRegionStreetNameBySuperId( Long id ) {
        return regionStreetDomain.queryRegionStreetNameBySuperId(id);
    }
    /**
     * @Author huxin
     * @Description 根据id查询
     * @Date 2019/1/2 9:58
     */
    @Override
    public Map<String, Object> findById( Long id ) {

        if(id != null || id>0){
            return (Map<String, Object>) regionStreetDao.findById(id);
        }
        return null;
    }


}
