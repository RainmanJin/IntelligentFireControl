package cn.com.bgy.ifc.domain.impl.system.repair;

import cn.com.bgy.ifc.dao.repair.MaintenanceContractDao;
import cn.com.bgy.ifc.domain.interfaces.system.repair.MaintenanceContractDomain;
import cn.com.bgy.ifc.entity.po.equipment.quipment.Brand;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceContractPage;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author lvbingjian
 * @Date 2018年12月19日12:02:23
 * @Description 维保合同管理（维保）
 **/
@Service
public class MaintenanceContractDomainImpl implements MaintenanceContractDomain {

    @Resource
    private MaintenanceContractDao dao;

    /**
     * 分页查询
     * @param page
     * @param maintenanceContract
     * @return
     */
    @Override
    public PageInfo<MaintenanceContract> queryListByPage(Page<MaintenanceContract> page, MaintenanceContract maintenanceContract) {
        List<MaintenanceContract> maintenanceContractList = dao.queryListByParam(maintenanceContract);
        PageInfo<MaintenanceContract> pageInfo = new PageInfo<>(maintenanceContractList);
        return pageInfo;
    }

    /**
     * 列表查询
     * @param record
     * @return
     */
    @Override
    public List<MaintenanceContract> queryListByParam(MaintenanceContract record) {
        return null;
    }
    /**
     * 添加
     * @param record
     * @return
     */
    @Override
    public int addMaintenanceContractInfo(MaintenanceContract record) {
        return dao.insert(record);
    }


}
