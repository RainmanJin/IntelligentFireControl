package cn.com.bgy.ifc.domain.interfaces.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenanceProgram;
import cn.com.bgy.ifc.entity.vo.repair.MaintenanceProgramVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
    PageInfo<MaintenanceProgramVo> queryListByPage(Page<MaintenanceProgramVo> page, MaintenanceProgramVo MaintenanceProgram);

    /**
     * 列表查询
     * @param record
     * @return
     */
    List<MaintenanceProgramVo> queryListByParam(MaintenanceProgramVo record);

    /**
     * 添加
     * @param record set值
     * @return
     */
    int addMaintenanceProgramInfo(MaintenanceProgramVo record);

    /**
     * 修改
     * @param record
     * @return
     */
    int updateMaintenanceProgram( MaintenanceProgramVo record );

    /**
     *通过ID查询
     * @param （
     * @return
     */
    MaintenanceProgramVo findById(Long id);

    /**
     * 批量删除
     * @param str（id逗号拼接）
     * @return
     */
    int deleteMaintenancePrograms(String str);
}
