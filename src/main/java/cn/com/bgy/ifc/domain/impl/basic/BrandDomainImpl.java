package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.BrandDao;
import cn.com.bgy.ifc.domain.interfaces.basic.BrandDomain;
import cn.com.bgy.ifc.entity.po.basic.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandDomainImpl implements BrandDomain {
    @Resource
    private BrandDao brandDao;
    @Override
    public PageInfo<Brand> searchByPage(Page page, Brand brand) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Brand> brandList = brandDao.searchByWhere(brand);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }
}
