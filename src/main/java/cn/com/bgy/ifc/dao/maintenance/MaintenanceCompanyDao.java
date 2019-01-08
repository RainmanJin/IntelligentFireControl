package cn.com.bgy.ifc.dao.maintenance;

import java.util.List;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceCompany;

/**
 * 
 * @author lvbingjian
 *
 */
public interface MaintenanceCompanyDao {
	/**
	 * 
	 * @param record 传入公司
	 * @return int 返回新增个数
	 */
	int insert(MaintenanceCompany record);

	/**
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(MaintenanceCompany record);

	/**
	 * 
	 * @param record
	 * @return
	 */
	int updateSelective(MaintenanceCompany record);

	/**
	 * 
	 */
	/** 维保公司列表查询 */
	/**
	 * 
	 * @param record
	 * @return
	 */
	List<MaintenanceCompany> queryListByParam(MaintenanceCompany record);

	/** 维保公司ID查询 */
	/**
	 * 
	 * @param id
	 * @return
	 */
	MaintenanceCompany findById(Long id);

	/** 维保公司修改 */
	/**
	 * 
	 * @param record
	 * @return
	 */
	int update(MaintenanceCompany record);

	/** 批量删除 */
	/**
	 * 
	 * @param list
	 * @return
	 */
	int delete(List<Long> list);
}