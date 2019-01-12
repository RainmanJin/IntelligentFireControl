package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.BgyMaintenanceWorkOrderVo;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenanceOrderDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceOrderDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;

import javax.annotation.Resource;

/**
 * @Author lvbingjian
 * @Date 2018年12月26日15:25:08
 * @Description 维保工单
 **/
@Service
public class MaintenanceOrderDomainImpl implements MaintenanceOrderDomain {

	@Resource
	private MaintenanceOrderDao maintenanceOrderDao;
	/**
	 * 通过ID查询
	 */
	@Override
	public MaintenanceOrder findById(Long id) {
		return maintenanceOrderDao.findById(id);
	}
	/**
	 * 添加
	 */
	@Override
	public int insert(MaintenanceOrder t) {
		return maintenanceOrderDao.insert(t);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(MaintenanceOrder t) {
		return maintenanceOrderDao.update(t);
	}
	/**
	 * 批量删除
	 */
	@Override
	public int deleteBatch(List<Long> ids) {
		return maintenanceOrderDao.deleteBatch(ids);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageInfo<MaintenanceOrder> queryListByPage(Page<MaintenanceOrder> page,
			MaintenanceOrder maintenanceOrder) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenanceOrder> list = maintenanceOrderDao.queryListByParam(maintenanceOrder);
		PageInfo<MaintenanceOrder> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	/**
	 * @author: ZhangCheng
	 * @description:
	 * @param: [list, orgId]
	 * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
	 */
	@Override
	public ResponseVO<Object> saveBgyMaintenanceWorkOrder(List<BgyMaintenanceWorkOrderVo> list, Long orgId) {
		return null;
	}

	/**
	 * @author: ZhangCheng
	 * @description:
	 * @param: [list, orgId]
	 * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
	 */
	@Override
	public ResponseVO<Object> alterBgyMaintenanceWorkOrder(List<BgyMaintenanceWorkOrderVo> list, Long orgId) {
		return null;
	}

	/**
	 * 查询全部
	 */
	@Override
	public List<MaintenanceOrder> queryListByParam(MaintenanceOrder t) {
		return maintenanceOrderDao.queryListByParam(t);
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
