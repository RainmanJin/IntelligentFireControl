package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.MaintenanceQualifications;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;


/**
 * @Author huxin
 * @Date 2019/2/12 14:37
 * @Description 自动消防系统委外维修保养资质情况
 **/

public interface MaintenanceQualificationsService{
    //分页查询
    PageInfo queryListByPage( Page<Object> page, Long regionId, String keyword );
    //根据ID查询明细
    Map<String,Object> findById( Long id );
    //批量删除
    int deleteData( String ids );
    //修改
    int editData( MaintenanceQualifications maintenanceQualifications );
    //新增
    int createData( MaintenanceQualifications maintenanceQualifications );
}
