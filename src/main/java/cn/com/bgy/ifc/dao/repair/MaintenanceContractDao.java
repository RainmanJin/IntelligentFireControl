package cn.com.bgy.ifc.dao.repair;


import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceContractVo;

import java.util.List;

public interface MaintenanceContractDao {
    int insert(MaintenanceContract record);

    int insertSelective(MaintenanceContract record);

    /**维保合同列表查询*/
    List<MaintenanceContractVo> queryListByParam(MaintenanceContractVo record);

    /**维保合同ID查询*/
    MaintenanceContractVo findById(Long id);

    /**维保合同修改*/
    int update(MaintenanceContract record);
    /**批量删除*/
    int delete(List<Long> list);
}