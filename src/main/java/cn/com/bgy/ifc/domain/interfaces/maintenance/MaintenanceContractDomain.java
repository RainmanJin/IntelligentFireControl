package cn.com.bgy.ifc.domain.interfaces.maintenance;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.BgyMaintenanceContractVo;
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
     *
     * @param page
     * @param maintenanceContract
     * @return
     */
    PageInfo<MaintenanceContract> queryListByPage(Page<MaintenanceContract> page, MaintenanceContract maintenanceContract);

    /**
     * 列表查询
     *
     * @param record
     * @return
     */
    List<MaintenanceContract> queryListByParam(MaintenanceContract record);

    /**
     * 添加
     *
     * @param record set值
     * @return
     */
    int addMaintenanceContractInfo(MaintenanceContract record);

    /**
     * 修改
     *
     * @param record 合同修改字段
     * @return
     */
    int updateMaintenanceContract(MaintenanceContract record);

    /**
     * 通过ID查询
     *
     * @param （合同id）
     * @return
     */
    MaintenanceContract findById(Long id);

    /**
     * 批量删除
     *
     * @param str（id逗号拼接）
     * @return
     */
    int deleteMaintenanceContracts(String str);

    /**
     * h获取区域下拉框初始值
     *
     * @return
     */
    List<Map<String, Object>> getRegionList();


    /**
     * 获取项目下拉框初始值
     *
     * @return
     */
    List<Map<String, Object>> getRegionProjectList();

    /**
     * @author: ZhangCheng
     * @description:集成平台全量获取维保合同信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyMaintenanceContract(List<BgyMaintenanceContractVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量获取维保合同信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyMaintenanceContract(List<BgyMaintenanceContractVo> list, Long orgId);

}
