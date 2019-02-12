package cn.com.bgy.ifc.service.impl.inner.firepatrol;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.dao.firepatrol.MaintenanceQualificationsDao;
import cn.com.bgy.ifc.entity.po.firepatrol.MaintenanceQualifications;
import cn.com.bgy.ifc.service.interfaces.inner.firepatrol.MaintenanceQualificationsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/2/12 14:37
 * @Description
 **/
@Service
public class MaintenanceQualificationsServiceImpl implements MaintenanceQualificationsService {

    @Resource
    private MaintenanceQualificationsDao maintenanceQualificationsDao;
    /*
     * @Author  huxin
     * @Description 分页条件查询       
     * @param   [page, regionId, keyword]
     * @retrue  com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.firepatrol.MaintenanceQualifications>
     * @Date 2019/2/12 15:41
     */
    @Override
    public PageInfo queryListByPage( Page<Object> page, Long regionId, String keyword ) {
        Map<String,Object> map  = new HashMap<>();
        map.put("regionId",regionId);
        map.put("keyword",keyword);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Map<String,Object>> list = maintenanceQualificationsDao.queryListByPage(map);
        return new PageInfo(list);
    }
    /*
     * @Author  huxin
     * @Description 根据ID查询明细       
     * @param   [id]
     * @retrue  cn.com.bgy.ifc.entity.po.firepatrol.MaintenanceQualifications
     * @Date 2019/2/12 15:41
     */
    @Override
    public Map<String,Object> findById( Long id ) {
        if(id!=null || id>0){
            return (Map<String, Object>) maintenanceQualificationsDao.findById(id);
        }
        return null;
    }
    /*
     * @Author  huxin
     * @Description 批量删除       
     * @param   [ids]
     * @retrue  int
     * @Date 2019/2/12 15:41
     */
    @Override
    public int deleteData( String ids ) {
        if(ids!=null || ids.length()>0){
            List<Long> list = ListUtil.getListId(ids);
            if(list.size()>0){
                return maintenanceQualificationsDao.deleteBatch(list);
            }
        }
        return 0;
    }
    /*
     * @Author  huxin
     * @Description    修改    
     * @param   [maintenanceQualifications]
     * @retrue  int
     * @Date 2019/2/12 15:41
     */
    @Override
    public int editData( MaintenanceQualifications maintenanceQualifications ) {
        if(maintenanceQualifications.getId()!=null || maintenanceQualifications.getId()>0){
            return maintenanceQualificationsDao.updateSelective(maintenanceQualifications);
        }
        return 0;
    }
    /*
     * @Author  huxin
     * @Description 新增
     * @param   [maintenanceQualifications]
     * @retrue  int
     * @Date 2019/2/12 15:41
     */
    @Override
    public int createData( MaintenanceQualifications maintenanceQualifications ) {
        maintenanceQualifications.setLogicRemove(false);
        return maintenanceQualificationsDao.insertSelective(maintenanceQualifications);
    }
}
