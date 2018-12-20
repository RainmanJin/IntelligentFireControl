package cn.com.bgy.ifc.domain.impl.system.project;

import cn.com.bgy.ifc.dao.system.project.RegionProjectDao;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.system.project.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/18 17:18
 * @Description
 **/
@Service
public class RegionProjectDomainImpl  implements RegionProjectDomain {

    @Resource
    private RegionProjectDao regionProjectDao;

    /**
     * @Author huxin
     * @Description 查
     * @Date 2018/12/18 17:31
     */
    @Override
    public PageInfo<RegionProjectVo> queryListRegionProjec( Page<RegionProjectVo> page, RegionProjectVo record ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionProjectVo> list= regionProjectDao.queryListRegionProject(record);
        return  new PageInfo<RegionProjectVo>(list);
    }
    /**
     * @Author huxin
     * @Description 增加
     * @Date 2018/12/18 17:31
     */
    @Override
    public int insert( RegionProject record ) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return regionProjectDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 17:31
     */
    @Transactional
    @Override
    public int updateRegionProjec( RegionProject record ) {
        record.setCreateTime(new Date());
        return regionProjectDao.updateRegionProject(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 17:31
     */
    @Transactional
    @Override
    public int deleteRegionProjec( String str ) {
        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return regionProjectDao.deleteRegionProject(list);
        }
        return 0;
    }
}
