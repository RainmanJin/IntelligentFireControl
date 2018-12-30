package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDetail;
import cn.com.bgy.ifc.entity.po.system.Account;

public interface FireInspectionDetailDomain extends BaseDomain<FireInspectionDetail> {
	/**
	 * 分页查询
	 * @param page  分页参数
	 * @param t 查询参数
	 * @param user 当前登录人
	 * @return 分页集合
	 */
	PageInfo<FireInspectionDetail>getPageList(Page<FireInspectionDetail>page,FireInspectionDetail t,Account user);

}
