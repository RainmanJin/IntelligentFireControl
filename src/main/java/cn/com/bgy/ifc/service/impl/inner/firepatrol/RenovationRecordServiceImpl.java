package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.RenovationRecordDao;
import cn.com.bgy.ifc.domain.interfaces.firepatrol.RenovationRecordDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.RegionByRecord;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationRecord;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.RenovationRecordService;
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
 * @Date 2019/1/7 9:24
 * @Description 装修备案情况
 **/
@Service
public class RenovationRecordServiceImpl implements RenovationRecordService {

    @Autowired
    private RenovationRecordDomain renovationRecordDomain;

    @Resource
    private RenovationRecordDao renovationRecordDao;


    /**
     * @Author 添加装修备案
     * @Description
     * @Date 2019/1/7 9:40
     */
    @Override
    public int addRenovationRecord( RegionByRecord regionByRecord, RenovationRecord renovationRecord ) {
        return renovationRecordDomain.addRenovationRecord(regionByRecord,renovationRecord);
    }
    /**
     * @Author huxin
     * @Description 删除装修备案信息
     * @Date 2019/1/7 11:42
     */
    @Override
    public int deleteRenovationRecord( String ids ) {
        List<Long> list = ListUtil.getListId(ids);
        if(list.size()>0){
            return renovationRecordDomain.deleteRenovationRecord(list);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 修改装修案信息
     * @Date 2019/1/7 14:02
     */
    @Override
    public int updateRenovationRecord( RenovationRecord renovationRecord ) {
        if(renovationRecord.getId() != null || renovationRecord.getId()>0){
            return renovationRecordDomain.updateRenovationRecord(renovationRecord);
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 查询装修备案信息列表（含条件查询）
     * @Date 2019/1/7 15:04
     */
    @Override
    public PageInfo queryRenovationRecordList( Page<Object> page, String keyword, RegionByRecord regionByRecord ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Map<String,Object> map = new HashMap<>();
        map.put("id",regionByRecord.getRecordId());
        map.put("keyword",keyword);
        map.put("regionId",regionByRecord.getRegionId());
        map.put("projectId",regionByRecord.getProjectId());
        map.put("courtId",regionByRecord.getCourtId());
        List<Map<String,Object>> list = renovationRecordDao.queryRenovationRecordList(map);
        return new PageInfo(list);
    }
    /**
     * @Author huxin
     * @Description 根ID查询信息
     * @Date 2019/1/7 15:14
     */
    @Override
    public Map<String, Object> queryRenovationRecordInfo( Long id ) {
        if(id != null || id>0){
            return (Map<String, Object>) renovationRecordDao.findById(id);
        }
        return null;
    }
}
