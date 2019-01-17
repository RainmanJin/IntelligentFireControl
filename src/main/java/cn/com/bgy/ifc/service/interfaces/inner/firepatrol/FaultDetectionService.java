package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/12 11:05
 * @Description 设施故障检测
 **/

public interface FaultDetectionService {
    //新增
    int addFaultDetection( RecordTable recordTable,String recordContent );
    //修改
    int editFaultDetection( RecordTable recordTable ,String recordContent);
    //删除
    int deleteFaultDetection( String ids );
    //列表查询（含条件查询）
    PageInfo listFaultDetection( Page<Object> page, String keyword, Long equipmentTypeId, Integer situation,Integer type );
    //根据ID查询明细
    Map<String,Object> getFaultDetectionFindByID( Long id );
    //根据设备ID获取故障检测内容下拉列表
    List<RecordTable> dropDownDataFindByEquipmentId( Long equipmentId );
}
