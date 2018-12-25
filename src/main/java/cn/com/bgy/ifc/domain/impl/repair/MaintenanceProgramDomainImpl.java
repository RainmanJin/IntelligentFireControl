package cn.com.bgy.ifc.domain.impl.repair;

import cn.com.bgy.ifc.dao.repair.MaintenanceProgramDao;
import cn.com.bgy.ifc.domain.interfaces.repair.MaintenanceProgramDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceProgram;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceProgramVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class MaintenanceProgramDomainImpl implements MaintenanceProgramDomain {
    @Resource
    private MaintenanceProgramDao dao ;

    @Override
    public PageInfo<MaintenanceProgramVo> queryListByPage(Page<MaintenanceProgramVo> page, MaintenanceProgramVo record) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        //List<MaintenanceProgramVo> maintenanceContractList = dao.queryListByParam(record);
        List<MaintenanceProgramVo> maintenanceContractList =null;
        PageInfo<MaintenanceProgramVo> pageInfo = new PageInfo<>(maintenanceContractList);
        return pageInfo;
    }

    @Override
    public List<MaintenanceProgramVo> queryListByParam(MaintenanceProgramVo record) {
        //return dao.queryListByParam(record);
        return null;
    }

    @Override
    public int addMaintenanceProgramInfo(MaintenanceProgramVo record) {
        //return dao.insert(record);
        return 0;
    }

    @Override
    public int updateMaintenanceProgram(MaintenanceProgramVo record) {
        //return dao.update(record);
        return 0;
    }

    @Override
    public MaintenanceProgramVo findById(Long id) {
        //return dao.findById(id);
        return null;
    }

    @Override
    public int deleteMaintenancePrograms(String str) {
        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return dao.deleteBatch(list);
        }else{
            return 0;
        }
    }
}
