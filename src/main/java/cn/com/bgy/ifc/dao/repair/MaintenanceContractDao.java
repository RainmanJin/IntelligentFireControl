package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceContractPage;

import java.util.List;

/**
 * 维保合同管理（维保） Dao
 */
public interface MaintenanceContractDao {
    int insert(MaintenanceContract record);

    int insertSelective(MaintenanceContract record);

    /**维保合同列表查询*/
    List<MaintenanceContract> queryListByParam(MaintenanceContract record);

    /**维保合同ID查询*/
    MaintenanceContract findById(Long id);

    /**维保合同修改*/
    int update(MaintenanceContract record);

}