package cn.com.bgy.ifc.domain.impl.system.project;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.dao.system.project.RegionComputerRoomDao;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionComputerRoomDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.po.system.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyMachineRoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-20 09:54
 **/
@Service
public class RegionComputerRoomDomainImpl implements RegionComputerRoomDomain {

    @Resource
    private RegionComputerRoomDao regionComputerRoomDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public int insert(RegionComputerRoom record) {
        return regionComputerRoomDao.insert(record);
    }

    @Override
    public int insertSelective(RegionComputerRoom record) {
        return regionComputerRoomDao.insertSelective(record);
    }

    @Override
    public int updateSelective(RegionComputerRoom record) {
        return regionComputerRoomDao.updateSelective(record);
    }

    @Override
    public ResponseVO<Object> saveBgyComputerRoomList(List<BgyMachineRoomVo> list, Long orgId) {
        try {
            List<RegionComputerRoom> roomList = new ArrayList<>();
            Date createTime=new Date();
            for (BgyMachineRoomVo bgyMachineRoomVo : list) {
                RegionComputerRoom room=new RegionComputerRoom();
                room.setId(bgyMachineRoomVo.getId());
                room.setOrganizationId(orgId);
                room.setRegionId(bgyMachineRoomVo.getAreaId());
                room.setProjectId(bgyMachineRoomVo.getProjectId());
                room.setCourtId(bgyMachineRoomVo.getDistrictId());
                room.setBuildingId(bgyMachineRoomVo.getBuildingId());
                room.setProjectId(bgyMachineRoomVo.getProjectId());
                room.setName(bgyMachineRoomVo.getName());
                room.setCode(bgyMachineRoomVo.getCode());
                room.setDescription(bgyMachineRoomVo.getDescription());
                room.setCreateTime(createTime);
                room.setLogicRemove(false);
                roomList.add(room);
            }
            int totalCount = DBUtil.insertByList("account", roomList);
            if (totalCount != roomList.size()) {
                return ResponseVO.error().setMsg("同步集成平台机房异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId,ExternalConstant.MsgTypeValue.BGY_MOTOR_ROOM_OBTAIN.getValue(),totalCount);
                return ResponseVO.success().setMsg("同步集成平台机房总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            return ResponseVO.error().setMsg("同步集成平台机房异常");
        }
    }

    @Override
    public ResponseVO<Object> alterBgyComputerRoomList(List<BgyMachineRoomVo> list, Long orgId) {
        return null;
    }
}
