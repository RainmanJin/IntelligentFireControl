package cn.com.bgy.ifc.domain.interfaces.repair;
import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.project.RegionProjectVo;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceContractVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author lvbingjian
 * @Date 2018年12月19日12:02:23
 * @Description 维保合同管理（维保）
 **/
public interface MaintenanceContractDomain {
    /**
     * 分页查询
     * @param page
     * @param maintenanceContract
     * @return
     */
    PageInfo<MaintenanceContractVo> queryListByPage(Page<MaintenanceContractVo> page, MaintenanceContractVo maintenanceContract);

    /**
     * 列表查询
     * @param record
     * @return
     */
    List<MaintenanceContractVo> queryListByParam(MaintenanceContract record);

    /**
     * 添加
     * @param record set值
     * @return
     */
    int addMaintenanceContractInfo(MaintenanceContract record);

    /**
     * 修改
     * @param record 合同修改字段
     * @return
     */
    int updateMaintenanceContract( MaintenanceContract record );

    /**
     *通过ID查询
     * @param （合同id）
     * @return
     */
    MaintenanceContractVo findById(Long id);

    /**
     * 批量删除
     * @param str（id逗号拼接）
     * @return
     */
    int deleteMaintenanceContracts(String str);

    /**
     * h获取区域下拉框初始值
     * @return
     */
    List<Map<String,Object>> getRegionList();


    /**
     * 获取项目下拉框初始值
     * @return
     */
    List<Map<String,Object>> getRegionProjectList();

}
