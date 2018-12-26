package cn.com.bgy.ifc.dao.maintenance;


import java.util.List;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceProgram;

public interface MaintenanceProgramDao {

    int insert(MaintenanceProgram record);

    int insertSelective(MaintenanceProgram record);

    /**维保公司列表查询*/
    List<MaintenanceProgram> queryListByParam(MaintenanceProgram record);

    /**维保公司ID查询*/
    MaintenanceProgram findById(Long id);

    /**维保公司修改*/
    int update(MaintenanceProgram record);
    /**批量删除*/
    int delete(List<Long> list);

}