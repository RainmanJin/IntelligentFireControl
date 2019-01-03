package cn.com.bgy.ifc.domain.interfaces.fireinspection;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireFacilities;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;

public interface FireFacilitiesDomain extends BaseDomain<FireFacilities> {
	PageInfo<FireFacilities>getPageList(Page<FireFacilities>page,FireFacilities t);
}
