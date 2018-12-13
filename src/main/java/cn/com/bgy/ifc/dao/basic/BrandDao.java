package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Brand;

import java.util.List;

public interface BrandDao {
    List<Brand> searchByWhere(Brand brand);
}
