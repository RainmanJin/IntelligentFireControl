package cn.com.bgy.ifc.service.impl.inner.projects;

import cn.com.bgy.ifc.domain.interfaces.system.project.RegionComputerRoomDomain;
import cn.com.bgy.ifc.entity.po.system.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.vo.system.project.RegionComputerRoomVo;
import cn.com.bgy.ifc.service.interfaces.inner.projects.RegionComputerRoomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 楼栋单元信息
 **/
@Service
public class RegionComputerRoomServiceImpl implements RegionComputerRoomService {

    @Autowired
    private RegionComputerRoomDomain regionComputerRoomDomain;


    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/20 14:42
     */
    @Override
    public PageInfo<RegionComputerRoomVo> queryListRegionComputerRoom( Page<RegionComputerRoomVo> page, RegionComputerRoomVo record ) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RegionComputerRoomVo> list=  regionComputerRoomDomain.queryListRegionComputerRoom(record);
        return  new PageInfo<RegionComputerRoomVo>(list);
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
}
