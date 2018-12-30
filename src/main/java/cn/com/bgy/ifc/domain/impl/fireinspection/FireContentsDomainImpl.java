package cn.com.bgy.ifc.domain.impl.fireinspection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.fireinspection.FireContentsDao;
import cn.com.bgy.ifc.domain.interfaces.fireinspection.FireContentsDomain;
import cn.com.bgy.ifc.entity.po.fireinspection.FireContents;
import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;
/**
 * 
 * @author 检查内容码表
 *lvbingjian
 *2018年12月30日17:15:27
 */
@Service
public class FireContentsDomainImpl implements FireContentsDomain {
	@Resource
	private FireContentsDao dao;
	@Override
	public List<FireContents> queryListByParam(FireContents t) {
		return dao.queryListByParam(t);
	}

	@Override
	public List<FireContents> queryListByMap(Map<String, Object> map) {
		return null;
	}

	@Override
	public FireContents findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public int insert(FireContents t) {
		return dao.insert(t);
	}

	@Override
	public int insertSelective(FireContents t) {
		return dao.insert(t);
	}

	@Override
	public int update(FireContents t) {
		return dao.update(t);
	}

	@Override
	public int updateSelective(FireContents t) {
		return dao.updateSelective(t);
	}

	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}

	@Override
	public PageInfo<FireContents> getPageList(Page<FireContents> page, FireContents t) {
		 page = PageHelper.startPage(page.getPageNum(), page.getPages(), page.getOrderBy());
		 List<FireContents>list = dao.queryListByParam(t);//dao.queryListByMap(map);
		 PageInfo<FireContents> info= new PageInfo<FireContents>(list);
		return info;
	}

}
