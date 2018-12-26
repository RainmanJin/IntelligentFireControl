package cn.com.bgy.ifc.domain.interfaces.repair;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenancePlan;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.repair.MaintenancePlanVo;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;

public interface MaintenancePlanDomain extends BaseDomain<MaintenancePlanVo> {
	PageInfo<MaintenancePlanVo> queryListByPage(Page<MaintenancePlanVo> page,MaintenancePlanVo vo);
	

}
