package cn.com.bgy.ifc.domain.impl.fireinspection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.com.bgy.ifc.dao.fireinspection.FireInspectionDetailDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireInspectionDetailDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDetail;
import cn.com.bgy.ifc.entity.po.system.Account;
/**
 * 消防巡检明细
 * @author Administrator
 *
 */
@Service
public class FireInspectionDetailDomainImpl implements FireInspectionDetailDomain {
	@Resource
	private FireInspectionDetailDao dao;
	@Resource
	private UserGroupItemsDao userDao;
	@Override
	public List<FireInspectionDetail> queryListByParam(FireInspectionDetail t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<FireInspectionDetail> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public FireInspectionDetail findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(FireInspectionDetail t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(FireInspectionDetail t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(FireInspectionDetail t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(FireInspectionDetail t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<FireInspectionDetail> getPageList(Page<FireInspectionDetail> page, FireInspectionDetail t,
			Account user) {
		 List<Long>regionIds = userDao.queryRegionIdByUserId(user.getId());
		 List<Long>projectIds = userDao.queryProjectIdByUserId(user.getId());
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("regionIds", regionIds);
		 map.put("projectIds", projectIds);
		 map.put("bean", t);
		 page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
		 List<FireInspectionDetail>list = dao.queryListByParam(t);//dao.queryListByMap(map);
		 PageInfo<FireInspectionDetail> info= new PageInfo<FireInspectionDetail>(list);
		return info;
	}

}
