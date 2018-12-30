package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireContents;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 
 * @author 检查内容码表
 *lvbingjian
 *2018年12月30日17:15:27
 */
public interface FireContentsDomain extends BaseDomain<FireContents> {
	PageInfo<FireContents>getPageList(Page<FireContents>page,FireContents t);

}
