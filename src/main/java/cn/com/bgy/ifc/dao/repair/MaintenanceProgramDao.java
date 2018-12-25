package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceProgram;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceProgramVo;

import java.util.List;

public interface MaintenanceProgramDao {

    int insert(MaintenanceProgramVo record);

    int insertSelective(MaintenanceProgramVo record);

    /**维保公司列表查询*/
    List<MaintenanceProgramVo> queryListByParam(MaintenanceProgramVo record);

    /**维保公司ID查询*/
    MaintenanceProgramVo findById(Long id);

    /**维保公司修改*/
    int update(MaintenanceProgramVo record);
    /**批量删除*/
    int delete(List<Long> list);

}