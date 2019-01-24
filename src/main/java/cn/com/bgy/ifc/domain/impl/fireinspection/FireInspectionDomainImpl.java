package cn.com.bgy.ifc.domain.impl.fireinspection;

import cn.com.bgy.ifc.dao.fireinspection.FireInspectionDao;
import cn.com.bgy.ifc.dao.fireinspection.FireInspectionDetailDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireInspectionDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspection;
import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDetail;
import cn.com.bgy.ifc.entity.po.system.Account;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 消防巡检主表单
 * @author lvbingjian
 *2018年12月29日11:42:13
 */
@Service
public class FireInspectionDomainImpl implements FireInspectionDomain {
	@Resource
	private FireInspectionDao fireInspectionDao;
	@Resource
	private FireInspectionDetailDao fireInspectionDetailDao;
	@Resource
	private UserGroupItemsDao userGroupItemsDao;
	
	@Override
	public List<FireInspection> queryListByParam(FireInspection t) {
		return fireInspectionDao.queryListByParam(t);
	}

	@Override
	public List<FireInspection> queryListByMap(Map<String, Object> map) {
		return fireInspectionDao.queryListByMap(map);
	}

	@Override
	public FireInspection findById(Long id) {
		FireInspectionDetail t=new FireInspectionDetail();
		t.setFireInspeId(id);
		List<FireInspectionDetail> list = fireInspectionDetailDao.queryListByParam(t);
		FireInspection fireInspection = fireInspectionDao.findById(id);
		fireInspection.setFireInspectionDetailList(list);
		return  fireInspection;
	}

	@Override
	public int insert(FireInspection t) {
		int res=fireInspectionDao.insert(t);
		List<FireInspectionDetail> list = t.getFireInspectionDetailList();
		if(list!=null&&list.size()>0){
			for (FireInspectionDetail fireInspectionDetail:list){
				fireInspectionDetail.setFireInspeId(t.getId());
				fireInspectionDetailDao.insert(fireInspectionDetail);
			}
		}
		return res;
	}

	@Override
	public int insertSelective(FireInspection t) {
		return fireInspectionDao.insertSelective(t);
	}

	@Override
	public int update(FireInspection t) {
		return fireInspectionDao.update(t);
	}

	@Override
	public int updateSelective(FireInspection t) {
		return fireInspectionDao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return fireInspectionDao.deleteBatch(ids);
	}
	@Override
	public PageInfo<FireInspection> getPageList(Page<FireInspection> page, FireInspection t, Account user) {
		if(user!=null) {
			List<Long>regionIds = userGroupItemsDao.queryRegionIdByUserId(user.getId());
			List<Long>projectIds = userGroupItemsDao.queryProjectIdByUserId(user.getId());
			page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regionIds", regionIds);
			map.put("projectIds", projectIds);
			map.put("bean", t);
		}
		 page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
		 List<FireInspection>list = fireInspectionDao.queryListByParam(t);
		 PageInfo<FireInspection> info= new PageInfo<FireInspection>(list);
		return info;
	}

}
