package cn.com.bgy.ifc.dao.maintenance;

import java.util.List;
import java.util.Map;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
import org.apache.ibatis.annotations.Param;

/**
 * 维保工单
 * @author lvbingjian
 * 2018年12月26日15:22:01
 *
 */
public interface MaintenanceOrderDao extends BaseDao<MaintenanceOrder>{
	/**
	 * 
	 * @param list
	 * @return
	 */
	int insertSelectiveByMap(@Param("list") List<Map<String,Object>> list);
}