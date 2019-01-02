package cn.com.bgy.ifc.domain.impl.fireinspection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.fireinspection.FireHiddenDangerDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireHiddenDangerDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDay;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * @Author lvbingjian
 * @Date 2018年12月30日15:42:41
 * @Description 火灾隐患情况记录表
 **/
@Service
public class FireHiddenDangerDomainImpl implements FireHiddenDangerDomain {
	@Resource
	private FireHiddenDangerDao dao;
	@Resource
	private UserGroupItemsDao userDao;
	@Override
	public List<FireHiddenDanger> queryListByParam(FireHiddenDanger t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<FireHiddenDanger> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public FireHiddenDanger findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(FireHiddenDanger t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(FireHiddenDanger t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(FireHiddenDanger t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(FireHiddenDanger t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<FireHiddenDanger> getPageList(Page<FireHiddenDanger> page, FireHiddenDanger t, Account user) {
		if(user!=null) {
			List<Long>regionIds = userDao.queryRegionIdByUserId(user.getId());
			List<Long>projectIds = userDao.queryProjectIdByUserId(user.getId());
			page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regionIds", regionIds);
			map.put("projectIds", projectIds);
			map.put("bean", t);
		}
		 List<FireHiddenDanger>list = dao.queryListByParam(t);//dao.queryListByMap(map);
		 PageInfo<FireHiddenDanger> info= new PageInfo<FireHiddenDanger>(list);
		return info;
	}

}
