package cn.com.bgy.ifc.service.impl.inner.projects;

import cn.com.bgy.ifc.dao.project.RegionComputerRoomDao;
import cn.com.bgy.ifc.dao.system.UserGroupItemsDao;
import cn.com.bgy.ifc.domain.interfaces.project.RegionComputerRoomDomain;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import cn.com.bgy.ifc.service.interfaces.inner.project.RegionComputerRoomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 楼栋单元信息
 **/
@Service
public class RegionComputerRoomServiceImpl implements RegionComputerRoomService {

    @Autowired
    private RegionComputerRoomDomain regionComputerRoomDomain;

    @Resource
    private RegionComputerRoomDao regionComputerRoomDao;

    @Resource
    private UserGroupItemsDao userGroupItemsDao;

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/20 14:42
     */
    @Override
    public PageInfo queryListRegionComputerRoom( Page page, RegionAndBrandVO record,Account user) {
//        UserGroupItems userGroupItems =  userGroupItemsDao.findByUserId(user.getId());
        //根据用户的权限判定查询的范围
//        record.setRegionId(userGroupItems.getRegionId());
//        record.setProjectId(userGroupItems.getProjectId());

        page = PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Map<String,Object>> list=  regionComputerRoomDomain.queryListRegionComputerRoom(record);
        return  new PageInfo(list);

    }
    /**
     * @Author huxin
     * @Description 新增
     * @Date 2018/12/20 14:42
     */
    @Override
    public int insert( RegionComputerRoom record ) {
        return regionComputerRoomDomain.insert(record);
    }
    /**
     * @Author huxin
     * @Description 改
     * @Date 2018/12/20 14:42
     */
    @Override
    public int updateRegionComputerRoom( RegionComputerRoom record ) {
        return regionComputerRoomDomain.updateRegionComputerRoom(record);
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/20 14:42
     */
    @Override
    public int deleteRegionComputerRoom( String str ) {
        List<Long> list = new ArrayList<>();
        String arr[] = str.split(",");
        if(arr.length>0){
            for (int i = 0; i <arr.length ; i++) {
                list.add(Long.valueOf(arr[i]));
            }
            return regionComputerRoomDomain.deleteRegionComputerRoom(list);
        }
        return 0;
    }

    @Override
    public Map<String, Object> findById( Long id ) {
        if(id != null ||id >0){
            return (Map<String, Object>) regionComputerRoomDao.findById(id);
        }
        return null;
    }
}
