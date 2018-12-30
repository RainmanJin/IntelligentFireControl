package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDay;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 每日防火巡查记录表
 * @author lvbingjian
 *2018年12月30日11:12:18
 */
public interface FireInspectionDayDomain extends BaseDomain<FireInspectionDay> {
	PageInfo<FireInspectionDay>getPageList(Page<FireInspectionDay>page,FireInspectionDay t,Account user);
}
