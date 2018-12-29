package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspection;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 消防巡检主表单
 * @author lvbingjian
 *2018年12月29日11:31:27
 */
public interface FireInspectionDomain extends BaseDomain<FireInspection> {
	PageInfo<FireInspection>getPageList(Page<FireInspection>page,FireInspection t,Account user);

}
