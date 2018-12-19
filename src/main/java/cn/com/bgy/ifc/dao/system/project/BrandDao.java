package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.equipment.quipment.Brand;

import java.util.List;

public interface BrandDao {
    List<Brand> searchByWhere(Brand brand);
}
