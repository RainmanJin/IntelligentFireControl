package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.RegionInfoDao;
import cn.com.bgy.ifc.domain.interfaces.basic.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.basic.RegionInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RegionInfoDomainImpl implements RegionInfoDomain {
    @Resource
    private RegionInfoDao regionInfoDao;
    @Override
    public PageInfo<RegionInfo> searchByPage(Page page, RegionInfo regionInfo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionInfo> regionInfoList = regionInfoDao.searchByWhere(regionInfo);
        PageInfo<RegionInfo> pageInfo = new PageInfo<>(regionInfoList);
        return pageInfo;
    }
}
