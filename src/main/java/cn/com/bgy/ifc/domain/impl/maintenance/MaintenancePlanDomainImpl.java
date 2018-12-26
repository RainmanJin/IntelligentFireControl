package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenancePlanDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePlanDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlan;
/**
 * 
 * @author lvbingjian
 * 维保计划业务
 * 2018年12月25日15:01:32
 *
 */
@Service
public class MaintenancePlanDomainImpl implements MaintenancePlanDomain {
	
	@Resource
	private MaintenancePlanDao dao;	
	/**
	 * 分页查询
	 */
	@Override
	public PageInfo<MaintenancePlan> queryListByPage(Page<MaintenancePlan> page, MaintenancePlan po) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<MaintenancePlan> list = dao.queryListByParam(po);
        PageInfo<MaintenancePlan> pageInfo = new PageInfo<>(list);
        return pageInfo;
	}
	/**
	 * 通过ID查找
	 */
	@Override
	public MaintenancePlan findById(Long id) {
		return dao.findById(id);
	}
	/**
	 * 查询列表
	 */
	@Override
	public List<MaintenancePlan> queryListByParam(MaintenancePlan po) {
		return dao.queryListByParam(po);
	}
	/**
	 * 通过ID修改
	 */
	@Override
	public int update(MaintenancePlan t) {
		return dao.update(t);
	}
	/**
	 * 批量删除
	 */
	@Override
	public int deleteBatch(List<Long> ids) {
		
		return dao.delete(ids);
	}

	@Override
	public int updateSelective(MaintenancePlan t) {
		return dao.updateSelective(t);
	}
	@Override
	public List<MaintenancePlan> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public int insertSelective(MaintenancePlan t) {
		return dao.insertSelective(t);
	}
	/**
	 * 新增
	 */
	@Override
	public int insert(MaintenancePlan t) {
		return dao.insert(t);
	}
	


}
