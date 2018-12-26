package cn.com.bgy.ifc.domain.impl.repair;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.repair.MaintenancePlanDao;
import cn.com.bgy.ifc.domain.interfaces.repair.MaintenancePlanDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenancePlan;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceContractVo;
import cn.com.bgy.ifc.entity.vo.repair.MaintenancePlanVo;
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
	public PageInfo<MaintenancePlanVo> queryListByPage(Page<MaintenancePlanVo> page, MaintenancePlanVo vo) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<MaintenancePlanVo> list = dao.queryListByParam(vo);
        PageInfo<MaintenancePlanVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
	}
	/**
	 * 通过ID查找
	 */
	@Override
	public MaintenancePlanVo findById(Long id) {
		return dao.findById(id);
	}
	/**
	 * 查询列表
	 */
	@Override
	public List<MaintenancePlanVo> queryListByParam(MaintenancePlanVo vo) {
		return dao.queryListByParam(vo);
	}
	/**
	 * 通过ID修改
	 */
	@Override
	public int update(MaintenancePlanVo t) {
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
	public int updateSelective(MaintenancePlanVo t) {
		return dao.updateSelective(t);
	}
	@Override
	public List<MaintenancePlanVo> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public int insertSelective(MaintenancePlanVo t) {
		return dao.insertSelective(t);
	}
	/**
	 * 新增
	 */
	@Override
	public int insert(MaintenancePlanVo t) {
		return dao.insert(t);
	}
	


}
