package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenanceOrderDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceOrderDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceCompany;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
/**
 * @Author lvbingjian
 * @Date 2018年12月26日15:25:08
 * @Description 维保工单
 **/
@Service
public class MaintenanceOrderDomainImpl implements MaintenanceOrderDomain {

	@Autowired
	private MaintenanceOrderDao dao;
	/**
	 * 通过ID查询
	 */
	@Override
	public MaintenanceOrder findById(Long id) {
		return dao.findById(id);
	}
	/**
	 * 添加
	 */
	@Override
	public int insert(MaintenanceOrder t) {
		return dao.insert(t);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(MaintenanceOrder t) {
		return dao.update(t);
	}
	/**
	 * 批量删除
	 */
	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageInfo<MaintenanceOrder> queryListByPage(Page<MaintenanceOrder> page,
			MaintenanceOrder maintenanceOrder) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenanceOrder> list = dao.queryListByParam(maintenanceOrder);
		PageInfo<MaintenanceOrder> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	/**
	 * 查询全部
	 */
	@Override
	public List<MaintenanceOrder> queryListByParam(MaintenanceOrder t) {
		return dao.queryListByParam(t);
	}

	@Override
	public int updateSelective(MaintenanceOrder t) {
		return 0;
	}
	
	@Override
	public List<MaintenanceOrder> queryListByMap(Map<String, Object> map) {
		return null;
	}
	@Override
	public int insertSelective(MaintenanceOrder t) {
		return 0;
	}

}
