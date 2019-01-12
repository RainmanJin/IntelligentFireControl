package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.RecordTableDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.FaultDetectionDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.FaultDetectionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public int editFaultDetection( RecordTable recordTable ) {
        if(recordTable.getId()!=null && recordTable.getId()>0){
            recordTable.setCreateTime(new Date());
            return recordTableDao.updateSelective(recordTable);
        }
        return 0;
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
}
