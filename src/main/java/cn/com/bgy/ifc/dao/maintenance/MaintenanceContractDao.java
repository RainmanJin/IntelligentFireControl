package cn.com.bgy.ifc.dao.maintenance;



import java.util.List;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;

public interface MaintenanceContractDao {
	
    int insert(MaintenanceContract record);

    int insertSelective(MaintenanceContract record);

    /**维保合同列表查询*/
    List<MaintenanceContract> queryListByParam(MaintenanceContract record);

    /**维保合同ID查询*/
    MaintenanceContract findById(Long id);

    /**维保合同修改*/
    int update(MaintenanceContract record);
    /**批量删除*/
    int delete(List<Long> list);
    
}