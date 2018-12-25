package cn.com.bgy.ifc.domain.impl.repair;


import cn.com.bgy.ifc.dao.project.RegionInfoDao;
import cn.com.bgy.ifc.dao.project.RegionProjectDao;
import cn.com.bgy.ifc.dao.repair.MaintenanceContractDao;
import cn.com.bgy.ifc.domain.interfaces.repair.MaintenanceContractDomain;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.project.RegionInfoVo;
import cn.com.bgy.ifc.entity.vo.project.RegionProjectVo;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceContractVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author lvbingjian
 * @Date 2018年12月19日12:02:23
 * @Description 维保合同管理（维保）
 **/
@Service
public class MaintenanceContractDomainImpl implements MaintenanceContractDomain {

    @Resource
    private MaintenanceContractDao dao;
    //区域dao
    @Resource
    private RegionInfoDao regionInfoDao;
    //项目
    @Resource
    private RegionProjectDao regionProjectDao;

    /**
     * 分页查询
     * @param page
     * @param maintenanceContract
     * @return
     */
    @Override
    public PageInfo<MaintenanceContractVo> queryListByPage(Page<MaintenanceContractVo> page, MaintenanceContractVo maintenanceContract) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<MaintenanceContractVo> maintenanceContractList = dao.queryListByParam(maintenanceContract);
        PageInfo<MaintenanceContractVo> pageInfo = new PageInfo<>(maintenanceContractList);
        return pageInfo;
    }

    /**
     * 列表查询
     * @param record
     * @return
     */
    @Override
    public List<MaintenanceContractVo> queryListByParam(MaintenanceContract record) {
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

    /**
     * 通过ID修改合同
     * @param record 合同修改字段
     * @return
     */
    @Override
    public int updateMaintenanceContract(MaintenanceContract record) {
        return dao.update(record);
    }

    /**
     * 同归合同ID查询合同详细信息
     * @param id
     * @return
     */
    @Override
    public MaintenanceContractVo findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public int deleteMaintenanceContracts(String str) {
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

    /**
     * 查询区域下拉框列表不需要传入参数
     * @return
     */
    @Override
    public List<Map<String,Object>> getRegionList() {
        RegionInfoVo regionInfoVo = null;
        return regionInfoDao.queryListRegionInfo(regionInfoVo);
    }

    /**
     * 获取项目下拉框初始值
     * @return
     */
    @Override
    public List<Map<String,Object>> getRegionProjectList() {
        RegionProjectVo regionProjectVo = null;
        return regionProjectDao.queryListRegionProject(regionProjectVo);
    }

}
