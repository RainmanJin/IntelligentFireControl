package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenancePeriodicDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePeriodicDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePeriodic;
/**
 * @Author lvbingjian
 * @Date 22018年12月27日16:27:08
 * @Description 维保周期性任务
 **/
@Service
public class MaintenancePeriodicDomainImpl implements MaintenancePeriodicDomain {
	@Resource
	private MaintenancePeriodicDao dao;

	@Override
	public List<MaintenancePeriodic> queryListByParam(MaintenancePeriodic t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<MaintenancePeriodic> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public MaintenancePeriodic findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(MaintenancePeriodic t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(MaintenancePeriodic t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(MaintenancePeriodic t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(MaintenancePeriodic t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<MaintenancePeriodic> queryListByPage(Page<MaintenancePeriodic> page,
			MaintenancePeriodic maintenancePeriodic) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenancePeriodic>list = dao.queryListByParam(maintenancePeriodic);
		PageInfo<MaintenancePeriodic>info = new PageInfo<>(list);
		return info;
	}

}
