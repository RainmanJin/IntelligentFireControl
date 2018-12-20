package cn.com.bgy.ifc.domain.impl.system.project;

import cn.com.bgy.ifc.dao.system.project.RegionInfoDao;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Description 区域信息
 * @Date 2018/12/18 15:19
 */
@Service
public class RegionInfoDomainImpl  implements RegionInfoDomain {
    @Resource
    private RegionInfoDao regionInfoDao;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/18 16:26
     */
    @Override
    public PageInfo<RegionInfo> queryListRegionInfo( Page<RegionInfo> page, RegionInfoVo systemRoleVo ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionInfo> list= regionInfoDao.queryListRegionInfo(systemRoleVo);
        return  new PageInfo<RegionInfo>(list);
    }
    /**
     * @Author huxin
     * @Description 添加
     * @Date 2018/12/18 16:26
     */
    @Override
    public int insert( RegionInfo record ) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return regionInfoDao.insert(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/18 16:26
     */
    @Transactional
    @Override
    public int updateRegionInfo( RegionInfoVo record ) {
        record.setCreateTime(new Date());
        return regionInfoDao.updateRegionInfo(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/18 16:26
     */
    @Transactional
    @Override
    public int deleteRegionInfo( String str ) {
        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return regionInfoDao.deleteRegionInfo(list);
        }
        return 0;

    }
    /**
     * @Author huxin
     * @Description 查询所有区域名
     * @Date 2018/12/20 18:26
     */
    @Override
    public List<Map<String, Object>> queryRegionInfoName() {
        return regionInfoDao.queryRegionInfoName();
    }
}
