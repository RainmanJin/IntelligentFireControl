package cn.com.bgy.ifc.domain.impl.maintenance;

import cn.com.bgy.ifc.dao.equipment.EquipmentTypeDao;
import cn.com.bgy.ifc.dao.maintenance.MaintenanceProgramDao;
import cn.com.bgy.ifc.domain.interfaces.maintenance.MaintenanceProgramDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceProgram;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenanceProgramVo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MaintenanceProgramDomainImpl implements MaintenanceProgramDomain {
    @Resource
    private MaintenanceProgramDao dao ;

    @Resource
    private EquipmentTypeDao equipmentTypeDao ;

    @Override
    public PageInfo<MaintenanceProgram> queryListByPage(Page<MaintenanceProgram> page, MaintenanceProgram record) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<MaintenanceProgram> maintenanceContractList = dao.queryListByParam(record);
        PageInfo<MaintenanceProgram> pageInfo = new PageInfo<>(maintenanceContractList);
        return pageInfo;
    }

    @Override
    public List<MaintenanceProgram> queryListByParam(MaintenanceProgram record) {
        return dao.queryListByParam(record);
    }

    @Override
    public int addMaintenanceProgramInfo(MaintenanceProgram record) {
        return dao.insert(record);
    }

    @Override
    public int updateMaintenanceProgram(MaintenanceProgram record) {
        return dao.update(record);
    }

    @Override
    public MaintenanceProgramVo findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int deleteMaintenancePrograms(String str) {
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

    @Override
    public List<Map<String, Object>> queryListEquipmentType() {
        String keyword = null;
        return equipmentTypeDao.queryListEquipmentType(keyword);
    }
}
