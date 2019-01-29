package cn.com.bgy.ifc.dao.report;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/29 15:10
 * @Description
 **/

public interface EquipmentReportDao {
    //获取设备总数
    Long getEquipmentCount( Map<String,Object> map);
    //按一级设备分类获取设备分类总数
    List<Map<String,Object>> getEquipmentCountByOneType( Map<String,Object> map);
    //按二级设备分类获取设备分类总数
    List<Map<String,Object>> getEquipmentCountByTwoType( Map<String,Object> map);
    //按一级分类获取对应二级分类对应二级分类设备总数
    List<Map<String,Object>> getEquipmentCountByOneTypeByTwoType( Map<String,Object> map);
}
