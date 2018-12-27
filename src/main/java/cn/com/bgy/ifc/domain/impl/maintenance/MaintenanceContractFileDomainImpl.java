package cn.com.bgy.ifc.domain.impl.maintenance;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.dao.maintenance.MaintenanceContractFileDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceContractFileDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile;
/**
 * @Author lvbingjian
 * @Date 2018年12月27日09:05:02
 * @Description 维保合同管理（维保）附件业务
 **/
@Service
public class MaintenanceContractFileDomainImpl implements MaintenanceContractFileDomain {
	@Resource
	private MaintenanceContractFileDao dao;
	/**
	 * 列表查询
	 * lbj
	 * 备注：一般是通过合同ID查询下面的附件列表
	 */
	@Override
	public List<MaintenanceContractFile> queryListByParam(MaintenanceContractFile t) {
		
		return dao.queryListByParam(t);
	}
	/**
	 * 分页查询
	 * 备注：一般是通过合同ID查询下面的附件列表
	 */
	@Override
	public PageInfo<MaintenanceContractFile> queryListByPage(Page<MaintenanceContractFile> page,
			MaintenanceContractFile maintenanceContractFile) {
		page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getCountColumn());
		List<MaintenanceContractFile>list = dao.queryListByParam(maintenanceContractFile);
		PageInfo<MaintenanceContractFile> info = new PageInfo<>(list);
		return info;
	}
	@Override
	public List<MaintenanceContractFile> queryListByMap(Map<String, Object> map) {
		return null;
	}
	/**
	 * 通过ID查询附件
	 */
	@Override
	public MaintenanceContractFile findById(Long id) {
		return dao.findById(id);
	}
	/**
	 * 新建
	 */
	@Override
	public int insert(MaintenanceContractFile t) {
		return dao.insert(t);
	}
	/**
	 * 新建
	 */
	@Override
	public int insertSelective(MaintenanceContractFile t) {
		return dao.insertSelective(t);
	}
	/**
	 * 修改
	 */

	@Override
	public int update(MaintenanceContractFile t) {
		return dao.update(t);
	}
	/**
	 * 修改
	 */
	@Override
	public int updateSelective(MaintenanceContractFile t) {
		return dao.update(t);
	}
/**
 * 批量删除
 */
	@Override
	public int deleteBatch(List<Long> ids) {
		return dao.deleteBatch(ids);
	}


}
