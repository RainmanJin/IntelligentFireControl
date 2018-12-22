package cn.com.bgy.ifc.service.impl.inner.projects;

import cn.com.bgy.ifc.domain.interfaces.project.RegionStreetDomain;
import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.system.project.RegionStreetVo;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionStreetService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/19 10:43
     */
    @Override
    public PageInfo<RegionStreetVo> queryListRegionStreet( Page<RegionStreetVo> page, RegionStreetVo record ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionStreetVo> list=  regionStreetDomain.queryListRegionStreet(record);
        return  new PageInfo<RegionStreetVo>(list);
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

        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
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
        return null;
    }


}
