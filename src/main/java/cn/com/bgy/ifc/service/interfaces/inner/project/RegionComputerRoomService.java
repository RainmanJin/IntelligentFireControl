package cn.com.bgy.ifc.service.interfaces.inner.project;

import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 楼栋单元信息
 **/

public interface RegionComputerRoomService {

    PageInfo queryListRegionComputerRoom( Page page, RegionAndBrandVO regionAndBrandVO );

    int insert( RegionComputerRoom record );

    int updateRegionComputerRoom( RegionComputerRoom record );

    int deleteRegionComputerRoom( String str );
}
