package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.RecordTableDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FaultDetectionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/12 11:05
 * @Description 设施故障检测
 **/
@Service
public class FaultDetectionServiceImpl implements FaultDetectionService {

    @Autowired
    private FaultDetectionDomain faultDetectionDomain;

    @Resource
    private RecordTableDao recordTableDao;



    /**
     * @Author huxin
     * @Description 添加
     * @Date 2019/1/12 11:29
     */
    @Override
    public int addFaultDetection( RecordTable recordTable ,String recordContent) {

        return faultDetectionDomain.addFaultDetection(recordTable,recordContent);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2019/1/12 11:30
     */
    @Override
    public int editFaultDetection( RecordTable recordTable ,String recordContent) {
        return faultDetectionDomain.editFaultDetection(recordTable,recordContent);

    }
    /**
     * @Author huxin
     * @Description 删除（批量）
     * @Date 2019/1/12 11:30
     */
    @Override
    public int deleteFaultDetection( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return recordTableDao.deleteBatch(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询列表
     * @Date 2019/1/12 11:30
     */
    @Override
    public PageInfo listFaultDetection( Page<Object> page, String keyword, Long equipmentTypeId, Integer situation ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("keyword",keyword);
        map.put("equipmentTypeId",equipmentTypeId);
        map.put("situation",situation);
        List<Map<String,Object>> list = recordTableDao.listFaultDetection(map);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 根据ID查询明细
     * @Date 2019/1/12 11:30
     */
    @Override
    public Map<String, Object> getFaultDetectionFindByID( Long id ) {
        if(id != null && id>0){
            return (Map<String, Object>) recordTableDao.findById(id);
        }
        return null;
    }
    /*
     * @Author  huxin
     * @Description 根据设备ID获取故障检测内容下拉列表
     * @param   [equipmentId]
     * @retrue  java.util.List<cn.com.bgy.ifc.entity.po.firepatrol.RecordTable>
     * @Date 2019/1/15 14:25
     */
    @Override
    public List<RecordTable> dropDownDataFindByEquipmentId( Long equipmentId ) {
        if(equipmentId != null && equipmentId>0){
            Map<String,Object> map= new HashMap<>();
            //故障检测类型的记录内容
            map.put("type",3);
            map.put("equipmentId",equipmentId);
            return recordTableDao.dropDownDataFindByEquipmentId(equipmentId);
        }
        return null;
    }
}
