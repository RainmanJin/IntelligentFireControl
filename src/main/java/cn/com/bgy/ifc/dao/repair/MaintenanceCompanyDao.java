package cn.com.bgy.ifc.dao.repair;


import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceCompany;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceCompanyVo;

import java.util.List;

public interface MaintenanceCompanyDao {
    int insert(MaintenanceCompany record);

    int insertSelective(MaintenanceCompany record);

    int updateSelective(MaintenanceCompany record);

    /**维保公司列表查询*/
    List<MaintenanceCompanyVo> queryListByParam(MaintenanceCompanyVo record);

    /**维保公司ID查询*/
    MaintenanceCompanyVo findById(Long id);

    /**维保公司修改*/
    int update(MaintenanceCompany record);
    /**批量删除*/
    int delete(List<Long> list);
}