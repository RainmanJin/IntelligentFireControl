package cn.com.bgy.ifc.service.impl.inner.report;

import cn.com.bgy.ifc.dao.report.EquipmentReportDao;
import cn.com.bgy.ifc.service.interfaces.inner.report.EquipmentReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Author huxin
 * @Date 2019/1/29 11:16
 * @Description 设备报表统计
 **/
@Service
public class EquipmentReportServiceImpl implements EquipmentReportService {

    @Resource
    private EquipmentReportDao equipmentReportDao;
    /*
     * @Author  huxin
     * @Description   获取设备图表数据
     * @param   [regionId, projectId]
     * @retrue  java.util.Map<java.lang.String,java.lang.Object>
     * @Date 2019/1/29 15:12
     */
    @Override
    public Map<String, Object> getEquipmentReportChart( Long regionId, Long projectId ) {
        Map<String,Object> map = new HashMap<>();
        map.put("regionId",regionId);
        map.put("projectId",projectId);
        //获取设备总数
        Long count = equipmentReportDao.getEquipmentCount(map);

        //获取一级设备分类的设备分类总数
        List<Map<String,Object>> oneList = equipmentReportDao.getEquipmentCountByOneType(map);
        List<String> oneTypeName = new ArrayList<>();
        List<Long>  oneTypeCount = new ArrayList<>();
        for (int i = 0; i < oneList.size(); i++) {
            oneTypeName.add((String) oneList.get(i).get("typeName"));
            oneTypeCount.add((Long) oneList.get(i).get("count"));
        }
        Map<String,Object> oneMap = new TreeMap<>();
        oneMap.put("oneList",oneList);
        oneMap.put("oneTypeName",oneTypeName);
        oneMap.put("oneTypeCount",oneTypeCount);

        //获取二级设备分类的设备分类总数
        List<Map<String,Object>> twoList = equipmentReportDao.getEquipmentCountByTwoType(map);
        List<String> twoTypeName = new ArrayList<>();
        List<Long> twoTypeCount = new ArrayList<>();
        for (int i = 0; i < twoList.size(); i++) {
            twoTypeName.add((String) twoList.get(i).get("typeName"));
            twoTypeCount.add((Long) twoList.get(i).get("count"));
        }
        Map<String,Object> twoMap = new TreeMap<>();
        twoMap.put("twoList",twoList);
        twoMap.put("twoTypeName",twoTypeName);
        twoMap.put("twoTypeCount",twoTypeCount);

        //按一级分类获取对应二级分类对应二级分类设备总数
        List<Map<String,Object>> owList = equipmentReportDao.getEquipmentCountByOneTypeByTwoType(map);
        Map<String,Object> owMap = new TreeMap<>();
        Map<String,Object> newmap = null;
        for (int i = 0; i < owList.size(); i++) {
            newmap = new TreeMap<>();
            owMap.put((String) owList.get(i).get("oneTypeName"),newmap.put((String) owList.get(i).get("twoTypeName"),owList.get(i).get("twoCount")));
        }

        Map<String,Object> chastMap = new HashMap<>();
        chastMap.put("count",count);
        chastMap.put("oneMap",oneMap);
        chastMap.put("twoMap",twoMap);
        chastMap.put("owMap",owMap);
        return chastMap;

    }
    /*
     * @Author  huxin
     * @Description 获取设备列表数据
     * @param   [regionId, projectId]
     * @retrue  void
     * @Date 2019/1/29 15:12
     */
    @Override
    public void getEquipmentReportList( Long regionId, Long projectId ) {
        Map<String,Object> map = new HashMap<>();
        map.put("regionId",regionId);
        map.put("projectId",projectId);

    }
}
