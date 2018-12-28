package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenanceOrderItemDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceOrderItemDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrderItem;
/**
 * 维保工单项目结果表
 * @author lvbingjian
 *2018年12月28日11:20:58
 */
@Service
public class MaintenanceOrderItemDomainImpl implements MaintenanceOrderItemDomain {
	@Resource
	private MaintenanceOrderItemDao dao;
	@Override
	public List<MaintenanceOrderItem> queryListByParam(MaintenanceOrderItem t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<MaintenanceOrderItem> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public MaintenanceOrderItem findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(MaintenanceOrderItem t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(MaintenanceOrderItem t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(MaintenanceOrderItem t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(MaintenanceOrderItem t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<MaintenanceOrderItem> queryListByPage(Page<MaintenanceOrderItem> page,
			MaintenanceOrderItem aintenanceOrderItem) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenanceOrderItem>list = dao.queryListByParam(aintenanceOrderItem);
		PageInfo<MaintenanceOrderItem>info = new PageInfo<>(list);
		return info;
	}

}
