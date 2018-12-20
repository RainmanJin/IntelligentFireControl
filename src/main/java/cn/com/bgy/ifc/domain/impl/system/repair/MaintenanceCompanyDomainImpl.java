package cn.com.bgy.ifc.domain.impl.system.repair;

import cn.com.bgy.ifc.dao.system.repair.MaintenanceCompanyDao;
import cn.com.bgy.ifc.domain.interfaces.system.repair.MaintenanceCompanyDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceCompany;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceCompanyVo;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceContractVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author lvbingjian
 * @Date 2018年12月20日
 * @Description 维保公司管理（维保）
 **/
@Service
public class MaintenanceCompanyDomainImpl implements MaintenanceCompanyDomain {
    @Resource
    private MaintenanceCompanyDao dao;

    /**
     * 分页查询
     * @param page
     * @param maintenanceCompany
     * @return
     */
    @Override
    public PageInfo<MaintenanceCompanyVo> queryListByPage(Page<MaintenanceCompanyVo> page, MaintenanceCompanyVo maintenanceCompany) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<MaintenanceCompanyVo> list = dao.queryListByParam(maintenanceCompany);
        PageInfo<MaintenanceCompanyVo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 列表查询
     * @param record
     * @return
     */
    @Override
    public List<MaintenanceCompanyVo> queryListByParam(MaintenanceCompanyVo record) {
        return dao.queryListByParam(record);
    }

    @Override
    public int addMaintenanceCompanyInfo(MaintenanceCompany record) {
        return dao.insert(record);
    }

    @Override
    public int updateMaintenanceCompany(MaintenanceCompany record) {
        return dao.update(record);
    }

    @Override
    public MaintenanceCompanyVo findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int deleteMaintenanceCompanys(String str) {
        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return dao.delete(list);
        }else{
            return 0;
        }
    }
}
