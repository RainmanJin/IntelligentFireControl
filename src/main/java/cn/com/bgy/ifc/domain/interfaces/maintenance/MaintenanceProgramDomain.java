package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceProgram;
import cn.com.bgy.ifc.entity.vo.maintenance.MaintenanceProgramVo;

import java.util.List;
import java.util.Map;

/**
 * @Author lvbingjian
 * @Date 2018年12月24日18:08:20
 * @Description 维保项目库
 **/
public interface MaintenanceProgramDomain {
    /**
     * 分页查询
     * @param page
     * @param MaintenanceProgram
     * @return
     */
    PageInfo<MaintenanceProgram> queryListByPage(Page<MaintenanceProgram> page, MaintenanceProgram MaintenanceProgram);

    /**
     * 列表查询
     * @param record
     * @return
     */
    List<MaintenanceProgram> queryListByParam(MaintenanceProgram record);

    /**
     * 添加
     * @param record set值
     * @return
     */
    int addMaintenanceProgramInfo(MaintenanceProgram record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateMaintenanceProgram( MaintenanceProgram record );

    /**
     *通过ID查询
     * @param （
     * @return
     */
    MaintenanceProgram findById(Long id);

    /**
     * 批量删除
     * @param str（id逗号拼接）
     * @return
     */
    int deleteMaintenancePrograms(String str);

    /**
     * 获取设备类型下拉框
     * 2018年12月25日11:39:39
     * lbj
     * @return
     */
    List<Map<String,Object>>  queryListEquipmentType();
}
