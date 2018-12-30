package cn.com.bgy.ifc.domain.impl.fireinspection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.fireinspection.FireInspectionDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireInspectionDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspection;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 消防巡检主表单
 * @author lvbingjian
 *2018年12月29日11:42:13
 */
@Service
public class FireInspectionDomainImpl implements FireInspectionDomain {
	@Resource
	private FireInspectionDao dao;
	@Resource
	private UserGroupItemsDao userDao;
	
	@Override
	public List<FireInspection> queryListByParam(FireInspection t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<FireInspection> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public FireInspection findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(FireInspection t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(FireInspection t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(FireInspection t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(FireInspection t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}
	@Override
	public PageInfo<FireInspection> getPageList(Page<FireInspection> page, FireInspection t, Account user) {
		 
		 List<Long>regionIds = userDao.queryRegionIdByUserId(user.getId());
		 List<Long>projectIds = userDao.queryProjectIdByUserId(user.getId());
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("regionIds", regionIds);
		 map.put("projectIds", projectIds);
		 map.put("bean", t);
		 page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
		 List<FireInspection>list = dao.queryListByParam(t);//dao.queryListByMap(map);
		 PageInfo<FireInspection> info= new PageInfo<FireInspection>(list);
		return info;
	}

}
