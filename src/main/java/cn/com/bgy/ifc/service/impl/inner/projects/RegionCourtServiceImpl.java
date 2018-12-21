package cn.com.bgy.ifc.service.impl.inner.projects;

import cn.com.bgy.ifc.domain.interfaces.system.project.RegionCourtDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.system.project.RegionCourtVo;
import cn.com.bgy.ifc.service.interfaces.inner.projects.RegionCourtService;
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
 * @Description 苑区信息
 **/
@Service
public class RegionCourtServiceImpl implements RegionCourtService {
    @Autowired
    private RegionCourtDomain regionCourtDomain;
    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/19 10:43
     */
    @Override
    public PageInfo<RegionCourtVo> queryListRegionCourt( Page<RegionCourtVo> page, RegionCourtVo record ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionCourtVo> list=  regionCourtDomain.queryListRegionCourt(record);
        return  new PageInfo<RegionCourtVo>(list);
    }
    /**
     * @Author huxin
     * @Description 增
     * @Date 2018/12/19 10:43
     */
    @Override
    public int insert( RegionCourt record ) {
        return regionCourtDomain.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/19 10:43
     */
    @Override
    public int updateRegionCourt( RegionCourt record ) {
        record.setCreateTime(new Date());
        return regionCourtDomain.updateRegionCourt(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/19 10:43
     */
    @Override
    public int deleteRegionCourt( String str ) {
        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return regionCourtDomain.deleteRegionCourt(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 根据父id查询所有苑区名
     * @Date 2018/12/20 19:34
     */
    @Override
    public List<Map<String, Object>> queryRegionCourtNameBySuperId( Long id ) {
        return null;
    }

}
