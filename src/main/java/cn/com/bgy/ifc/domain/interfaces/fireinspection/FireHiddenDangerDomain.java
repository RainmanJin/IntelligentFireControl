package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 
 * @author 火灾隐患情况记录表
 *
 */
public interface FireHiddenDangerDomain extends BaseDomain<FireHiddenDanger> {
	PageInfo<FireHiddenDanger>getPageList(Page<FireHiddenDanger>page,FireHiddenDanger t,Account user);
}
