package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrderPhoto;

public interface MaintenanceOrderPhotoDomain extends BaseDomain<MaintenanceOrderPhoto> {
	/**
	 * 分页查询
	 * @param page
	 * @param mp
	 * @return
	 */
	PageInfo<MaintenanceOrderPhoto> queryListByPage(Page<MaintenanceOrderPhoto>page,MaintenanceOrderPhoto mp);

}
