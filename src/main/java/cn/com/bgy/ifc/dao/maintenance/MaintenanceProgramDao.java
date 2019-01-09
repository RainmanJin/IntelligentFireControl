package cn.com.bgy.ifc.dao.maintenance;

/**
 * 
 * @author lvbingjian
 *
 */
import java.util.List;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceProgram;

public interface MaintenanceProgramDao {
	/**
	 * 
	 * @param record
	 * @return
	 */
	int insert(MaintenanceProgram record);

	/**
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(MaintenanceProgram record);

	/** 维保公司列表查询 */
	/**
	 * 
	 * @param record
	 * @return
	 */
	List<MaintenanceProgram> queryListByParam(MaintenanceProgram record);

	/** 维保公司ID查询 */
	/**
	 * 
	 * @param id
	 * @return
	 */
	MaintenanceProgram findById(Long id);

	/** 维保公司修改 */
	/**
	 * 
	 * @param record
	 * @return
	 */
	int update(MaintenanceProgram record);

	/** 批量删除 */
	/**
	 * 
	 * @param list
	 * @return
	 */
	int delete(List<Long> list);

}