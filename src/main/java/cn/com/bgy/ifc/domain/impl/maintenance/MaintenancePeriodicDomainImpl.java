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

import cn.com.bgy.ifc.dao.maintenance.MaintenanceOrderDao;
import cn.com.bgy.ifc.dao.maintenance.MaintenancePeriodicDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenancePeriodicDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePeriodic;
/**
 * @Author lvbingjian
 * @Date 22018年12月27日16:27:08
 * @Description 维保周期性任务
 **/
@Service
public class MaintenancePeriodicDomainImpl implements MaintenancePeriodicDomain {
	@Resource
	private MaintenancePeriodicDao maintenancePeriodicDao;
	@Resource
	private MaintenanceOrderDao maintenanceOrderDao;

	@Override
	public List<MaintenancePeriodic> queryListByParam(MaintenancePeriodic t) {
		return maintenancePeriodicDao.queryListByParam(t);
	}

	@Override
	public List<MaintenancePeriodic> queryListByMap(Map<String, Object> map) {
		return maintenancePeriodicDao.queryListByMap(map);
	}

	@Override
	public MaintenancePeriodic findById(Long id) {
		return maintenancePeriodicDao.findById(id);
	}

	@Override
	public int insert(MaintenancePeriodic t) {
		double num =0.0;
		double days = 0.0;
		int times = 0;
		//计算维保时间总天数
		if(t.getStartTime()!=null&&t.getEndTime()!=null) {
			days=(t.getEndTime().getTime()-t.getStartTime().getTime())/(24*60*60*1000);
		}
		//通过总天数和维保周期得出总次数
		if(t.getCycleType()!=null) {
			if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_ONE) {
				num=days/30;
			}else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_TOW) {
				num=days/91;
			}else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_TREE) {
				num=days/182;
			}else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_FOUL) {
				num=days/365;
			}
			else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_FIVE&&t.getCycleDay()!=null) {
				num=days/t.getCycleDay();
			}
		}
		times = (int) Math.floor(num);
		t.setSum(times);
		return maintenancePeriodicDao.insert(t);
	}

	@Override
	public int insertSelective(MaintenancePeriodic t) {
		return maintenancePeriodicDao.insertSelective(t);
	}

	@Override
	public int update(MaintenancePeriodic t) {
		double num =0.0;
		double days = 0.0;
		int times = 0;
		//计算维保时间总天数
		if(t.getStartTime()!=null&&t.getEndTime()!=null) {
			days=(t.getEndTime().getTime()-t.getStartTime().getTime())/(24*60*60*1000);
		}
		//通过总天数和维保周期得出总次数
		if(t.getCycleType()!=null) {
			if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_ONE) {
				num=days/30;
			}else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_TOW) {
				num=days/91;
			}else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_TREE) {
				num=days/182;
			}else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_FOUL) {
				num=days/365;
			}
			else if(t.getCycleType() == MaintenancePeriodic.CYCLETYPE_FIVE&&t.getCycleDay()!=null) {
				num=days/t.getCycleDay();
			}
		}
		times = (int) Math.floor(num);
		t.setSum(times);
		return maintenancePeriodicDao.update(t);
	}

	@Override
	public int updateSelective(MaintenancePeriodic t) {
		return maintenancePeriodicDao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return maintenancePeriodicDao.deleteBatch(ids);
	}

	@Override
	public PageInfo<MaintenancePeriodic> queryListByPage(Page<MaintenancePeriodic> page,
			MaintenancePeriodic maintenancePeriodic) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenancePeriodic>list = maintenancePeriodicDao.queryListByParam(maintenancePeriodic);
		PageInfo<MaintenancePeriodic>info = new PageInfo<>(list);
		return info;
	}

	@Override
	public int saveOrders(MaintenancePeriodic m) {
		List<Map<String,Object>>list = new ArrayList<Map<String,Object>>();
		if(m.getEquipmentId()!=null&&m.getSum()>0) {
			for (int i = 0; i < m.getSum(); i++) {
				//创建工单
				Map<String,Object> map = new HashMap<String,Object>();
				MaintenanceOrder or = new MaintenanceOrder();
				//工单名称
				map.put("periodicId", m.getId());
				map.put("id", Long.valueOf(i+""));
				//维保设备
				map.put("deviceId", m.getEquipmentId());
				//机构ID
				map.put("organizationId", m.getOrganizationId());
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
		return maintenanceOrderDao.insertSelectiveByMap(list);
	}

}
