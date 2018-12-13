package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Brand;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface BrandDomain {
    /**
     * 分页
     * @param brand
     * @return
     */
    PageInfo<Brand> searchByPage(Page page, Brand brand);
}
