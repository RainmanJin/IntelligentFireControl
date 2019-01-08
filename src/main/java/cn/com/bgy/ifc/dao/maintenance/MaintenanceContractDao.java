package cn.com.bgy.ifc.dao.maintenance;

import java.util.List;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;

/**
 * 
 * @author lvbingjian
 *
 */
public interface MaintenanceContractDao extends BaseDao<MaintenanceContract> {

	/** 维保合同列表查询 */
	/**
	 * 
	 */
	List<MaintenanceContract> queryListByParam(MaintenanceContract record);

	/** 批量删除 */
	/**
	 * 
	 * @param list
	 * @return
	 */
	int delete(List<Long> list);

}