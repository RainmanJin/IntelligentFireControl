package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FirePlanTest;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 
 * @author 设施故障检测工作计划（主表）
 *lbj
 *2019年1月3日10:50:36
 */
public interface FirePlanTestDomain extends BaseDomain<FirePlanTest> {
	PageInfo<FirePlanTest>getPageList(Page<FirePlanTest>page,FirePlanTest t,Account user);
}
