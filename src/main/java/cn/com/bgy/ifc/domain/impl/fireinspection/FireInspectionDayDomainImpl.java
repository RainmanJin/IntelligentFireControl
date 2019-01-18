package cn.com.bgy.ifc.domain.impl.fireinspection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDay;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.fireinspection.FireInspectionDayDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireInspectionDayDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
@Service
public class FireInspectionDayDomainImpl implements FireInspectionDayDomain {
	@Resource
	private FireInspectionDayDao dao;
	@Resource
	private UserGroupItemsDao userDao;
	@Override
	public List<FireInspectionDay> queryListByParam(FireInspectionDay t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<FireInspectionDay> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public FireInspectionDay findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(FireInspectionDay t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(FireInspectionDay t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(FireInspectionDay t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(FireInspectionDay t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<FireInspectionDay> getPageList(Page<FireInspectionDay> page, FireInspectionDay t, Account user) {
		if(user!=null) {
			List<Long>regionIds = userDao.queryRegionIdByUserId(user.getId());
			List<Long>projectIds = userDao.queryProjectIdByUserId(user.getId());
			page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regionIds", regionIds);
			map.put("projectIds", projectIds);
			map.put("bean", t);
		}
		 List<FireInspectionDay>list = dao.queryListByParam(t);//dao.queryListByMap(map);
		 PageInfo<FireInspectionDay> info= new PageInfo<FireInspectionDay>(list);
		return info;
	}

}
