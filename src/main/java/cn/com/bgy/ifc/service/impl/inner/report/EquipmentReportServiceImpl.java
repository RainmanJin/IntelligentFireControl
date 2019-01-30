package cn.com.bgy.ifc.service.impl.inner.report;

import cn.com.bgy.ifc.dao.report.EquipmentReportDao;
import cn.com.bgy.ifc.service.interfaces.inner.report.EquipmentReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        Map<String,Object> oneMap = new HashMap<>();
        oneMap.put("oneList",oneList);


        //获取二级设备分类的设备分类总数
        List<Map<String,Object>> twoList = equipmentReportDao.getEquipmentCountByTwoType(map);
        List<String> twoTypeName = new ArrayList<>();
        List<Long> twoTypeCount = new ArrayList<>();
        for (int i = 0; i < twoList.size(); i++) {
            twoTypeName.add((String) twoList.get(i).get("name"));
            twoTypeCount.add((Long) twoList.get(i).get("value"));
        }
        Map<String,Object> twoMap = new HashMap<>();
        twoMap.put("twoTypeName",twoTypeName);
        twoMap.put("twoTypeCount",twoTypeCount);

        //按一级分类获取对应二级分类对应二级分类设备总数
        List<Map<String,Object>> owList = equipmentReportDao.getEquipmentCountByOneTypeByTwoType(map);
        Map<Object, Object> owMap = new HashMap<>();
        List<String> typeNameList = new ArrayList<>();
        List<Map<String,Object>> valueList = new ArrayList<>();
        Map<String,Object> listMap;
        Map<String,Object> newMap;
        List<Object> list;
        Set<String> set  = new HashSet<>();
        for (int i = 0; i < owList.size(); i++) {
            set.add((String) owList.get(i).get("oneTypeName"));
        }
        for (String s:set) {
            list = new ArrayList<>();
            listMap = new HashMap<>();
            for (int i = 0; i <owList.size() ; i++) {
                if(s.equals(owList.get(i).get("oneTypeName"))){
                    newMap = new HashMap<>();
                    newMap.put("name",owList.get(i).get("name"));
                    newMap.put("value",owList.get(i).get("value"));
                    list.add(newMap);
                }
            }
            typeNameList.add(s);
            listMap.put("list",list);
            valueList.add(listMap);
        }

        owMap.put("typeName",typeNameList);
        owMap.put("valueList", valueList);
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
    public PageInfo getEquipmentReportList( Page<Object> page, Long regionId, Long projectId ) {
        Map<String,Object> map = new HashMap<>();
        map.put("regionId",regionId);
        map.put("projectId",projectId);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Map<String,Object>> owList = equipmentReportDao.getEquipmentCountByOneTypeByTwoType(map);
        return new PageInfo(owList);
    }
}
