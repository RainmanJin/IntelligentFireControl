package cn.com.bgy.ifc.dao.maintenance;



import java.util.List;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceCompany;

public interface MaintenanceCompanyDao {
    int insert(MaintenanceCompany record);
	
    int insertSelective(MaintenanceCompany record);

    int updateSelective(MaintenanceCompany record);

    /**维保公司列表查询*/
    List<MaintenanceCompany> queryListByParam(MaintenanceCompany record);

    /**维保公司ID查询*/
    MaintenanceCompany findById(Long id);

    /**维保公司修改*/
    int update(MaintenanceCompany record);
    /**批量删除*/
    int delete(List<Long> list);
}