package cn.com.bgy.ifc.domain.interfaces.project;

import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyMachineRoomVo;
import cn.com.bgy.ifc.entity.vo.project.RegionComputerRoomVo;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:机房信息业务
 * @date: 2018-12-20 09:52
 **/
public interface RegionComputerRoomDomain {

    int insert(RegionComputerRoom record);

    int insertSelective(RegionComputerRoom record);

    int updateSelective(RegionComputerRoom record);

    /**
     * 集成平台全量增加机房信息
     * @param list
     * @return
     */
    ResponseVO<Object> saveBgyComputerRoomList(List<BgyMachineRoomVo> list, Long orgId);

    /**
     * 集成平台增量增加机房信息
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> alterBgyComputerRoomList(List<BgyMachineRoomVo> list, Long orgId);

    List<Map<String,Object>> queryListRegionComputerRoom( RegionComputerRoomVo record );


    int updateRegionComputerRoom( RegionComputerRoom record );

    int deleteRegionComputerRoom( List<Long> list );
}
