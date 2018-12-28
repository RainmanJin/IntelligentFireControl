package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenanceOrderPhotoDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceOrderPhotoDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrderPhoto;
/**
 *维保工单拍照
 * @author lvbingjian
 *2018年12月28日14:09:47
 */
@Service
public class MaintenanceOrderPhotoDomainImpl implements MaintenanceOrderPhotoDomain {
	@Resource
	private MaintenanceOrderPhotoDao dao;
	@Override
	public List<MaintenanceOrderPhoto> queryListByParam(MaintenanceOrderPhoto t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<MaintenanceOrderPhoto> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public MaintenanceOrderPhoto findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(MaintenanceOrderPhoto t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(MaintenanceOrderPhoto t) {
		return dao.insert(t);
	}

	@Override
	public int update(MaintenanceOrderPhoto t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(MaintenanceOrderPhoto t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<MaintenanceOrderPhoto> queryListByPage(Page<MaintenanceOrderPhoto> page, MaintenanceOrderPhoto mp) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<MaintenanceOrderPhoto>list = dao.queryListByParam(mp);
		PageInfo<MaintenanceOrderPhoto> info = new PageInfo<>(list);
		return info;
	}

}
