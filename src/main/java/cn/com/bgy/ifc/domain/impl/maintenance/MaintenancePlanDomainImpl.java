package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.bgy.utils.StringUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.dao.maintenance.MaintenancePlanDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePlanDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlan;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
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
	@Resource
	private EquipmentInfoDao equipmentInfoDao;	
	
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
	@Override
	public int saveOrders(MaintenancePlan t) {
		//获取设备类型ID
		List<Map<String,Object>> ids = this.ordIds(t);
		double num =0.0;
		double days = 0.0;
		int times = 0;
		int saveNum = 0;
		if(t.getBeginDate()!=null&&t.getEndDate()!=null) {
			days=(t.getEndDate().getTime()-t.getBeginDate().getTime())/(24*60*60*1000);  
		}
		if(ids!=null&&t.getProjectType()!=null) {
			if(t.getProjectType() == 1) {
				num=days/15;
			}else if(t.getProjectType() == 2) {
				num=days/91;
			}else if(t.getProjectType() == 3) {
				num=days/182;
			}else if(t.getProjectType() == 4) {
				num=days/365;
			}
		}
		times = (int) Math.floor(num);
		
		//生成工单
		if(times>0&&ids!=null&&ids.size()>0) {
			List<Map<String,Object>>list = new ArrayList<Map<String,Object>>();
			for (int i = 0; i < times; i++) {
				for (int j = 0; j < ids.size(); j++) {
				//创建工单
				Map<String,Object> map = new HashMap<String,Object>();
				MaintenanceOrder or = new MaintenanceOrder();
				map.put("id", or.getId());
				//工单名称
				map.put("planId", t.getId());
				//维保设备
				map.put("deviceId", ids.get(j).get("id"));
				//机构ID
				map.put("organizationId", t.getOrganizationId());
				//工单状态
				map.put("orderState", 1);
				//创建时间
				map.put("createTime", new Date());
				//是否逻辑删除
				map.put("logicRemove", false);
				//是否周期任务
				map.put("cycle", false);
				list.add(map);
				}
			}
			saveNum = dao.insertSelectiveByMap(list);
		}
		return saveNum;
	}
	/**
	 * 通过设备类型id取出所有的设备
	 */
	@Override
	public List<Map<String,Object>>  ordIds(MaintenancePlan t) {
		//通过计划的区域ID设备类型ID项目ID取出
		RegionAndBrandVO regionAndBrandVO = new RegionAndBrandVO();
		//设备类型
		regionAndBrandVO.setTypeId(t.getProjectType());
		//区域ID
		regionAndBrandVO.setRegionId(t.getRegionId());
		//项目ID
		regionAndBrandVO.setProjectId(t.getProjectId());
		List<Map<String,Object>> loist= equipmentInfoDao.queryListEquipmentInfo(regionAndBrandVO);
		return loist;
	}

}
