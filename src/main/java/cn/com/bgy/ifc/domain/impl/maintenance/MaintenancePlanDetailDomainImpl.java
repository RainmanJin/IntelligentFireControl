package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenancePlanDetailDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePlanDetailDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlanDetail;
/**
 * 维保计划明细
 * 2018年12月27日13:57:02
 * @author lvbingjian
 *
 */
@Service
public class MaintenancePlanDetailDomainImpl implements MaintenancePlanDetailDomain {

	@Resource
	private MaintenancePlanDetailDao dao;
	/**
	 * 查询列表
	 * lbj
	 */
	@Override
	public List<MaintenancePlanDetail> queryListByParam(MaintenancePlanDetail t) {
		return dao.queryListByParam(t);
	}
	/**
	 * 查询列表
	 * lbj
	 */
	@Override
	public List<MaintenancePlanDetail> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}
	/**
	 * 按ID查询
	 */
	@Override
	public MaintenancePlanDetail findById(Long id) {
		return dao.findById(id);
	}
	/**
	 * 新增
	 * lvbingjian
	 */
	@Override
	public int insert(MaintenancePlanDetail t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(MaintenancePlanDetail t) {
		// TODO Auto-generated method stub
		return dao.insertSelective(t);
	}
	/**
	 * 通过ID修改数据
	 */
	@Override
	public int update(MaintenancePlanDetail t) {
		return dao.update(t);
	}
	/**
	 * 
	 */
	@Override
	public int updateSelective(MaintenancePlanDetail t) {
		return dao.updateSelective(t);
	}
	/**
	 * 批量删除
	 */
	@Override
	public int deleteBatch(List<Long> ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageInfo<MaintenancePlanDetail> queryListByPage(Page<MaintenancePlanDetail> page,
			MaintenancePlanDetail aintenancePlanDetail) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenancePlanDetail> list = dao.queryListByParam(aintenancePlanDetail);
		PageInfo<MaintenancePlanDetail>info = new  PageInfo<>(list);
		return info;
	}

}
