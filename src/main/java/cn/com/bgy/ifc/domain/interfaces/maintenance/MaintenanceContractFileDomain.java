package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile;
/**
 * @Author lvbingjian
 * @Date 2018年12月19日12:02:23
 * @Description 维保合同管理附件
 **/
public interface MaintenanceContractFileDomain extends BaseDomain<MaintenanceContractFile> {
	 /**
     * 分页查询
     * @param page
     * @param maintenanceContract
     * @return
     */
    PageInfo<MaintenanceContractFile> queryListByPage(Page<MaintenanceContractFile> page, MaintenanceContractFile maintenanceContractFile);

}
