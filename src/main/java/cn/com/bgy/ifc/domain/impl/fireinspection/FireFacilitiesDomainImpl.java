package cn.com.bgy.ifc.domain.impl.fireinspection;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.com.bgy.ifc.dao.fireinspection.FireFacilitiesDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireFacilitiesDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireFacilities;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;

/**
 * 
 * @author 消防设施表码表
 *
 */
@Service
public class FireFacilitiesDomainImpl implements FireFacilitiesDomain {
	@Resource
	private FireFacilitiesDao dao;
	@Override
	public List<FireFacilities> queryListByParam(FireFacilities t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<FireFacilities> queryListByMap(Map<String, Object> map) {
		return dao.queryListByMap(map);
	}

	@Override
	public FireFacilities findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(FireFacilities t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(FireFacilities t) {
		return dao.insertSelective(t);
	}

	@Override
	public int update(FireFacilities t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(FireFacilities t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<FireFacilities> getPageList(Page<FireFacilities> page, FireFacilities t) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
		List<FireFacilities> list = dao.queryListByParam(t);
		PageInfo<FireFacilities>info = new PageInfo<>(list);
		return info;
	}

}
