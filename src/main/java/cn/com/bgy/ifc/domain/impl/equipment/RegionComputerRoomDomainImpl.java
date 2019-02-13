package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.project.RegionComputerRoomDao;
import cn.com.bgy.ifc.domain.interfaces.project.RegionComputerRoomDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.synchro.BgyRegionBuilding;
import cn.com.bgy.ifc.entity.po.synchro.BgyRegionComputerRoom;
import cn.com.bgy.ifc.entity.po.synchro.BgyRegionCourt;
import cn.com.bgy.ifc.entity.po.synchro.BgyRegionStreet;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyMachineRoomVo;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:设备机房
 * @date: 2018-12-20 09:54
 **/
@Service
public class RegionComputerRoomDomainImpl implements RegionComputerRoomDomain {

    private static Logger logger = LoggerFactory.getLogger(RegionComputerRoomDomainImpl.class);

    @Resource
    private RegionComputerRoomDao regionComputerRoomDao;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public int insert(RegionComputerRoom record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
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

    /**
     * @author: ZhangCheng
     * @description:同步集成平台机房数据（包含苑区街道楼栋单元）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> saveBgyComputerRoomList(List<BgyMachineRoomVo> list, Long orgId) {
        try {
            int courtValue = ExternalConstant.MsgTypeValue.BGY_COURT_OBTAIN.getValue();
            int streetValue = ExternalConstant.MsgTypeValue.BGY_STREET_OBTAIN.getValue();
            int buildingValue = ExternalConstant.MsgTypeValue.BGY_BUILDING_OBTAIN.getValue();
            List<ExternalInterfaceMsg> courtMsg = externalInterfaceMsgDomain.queryBgyInterfaceMsg(courtValue, orgId);
            List<ExternalInterfaceMsg> streetMsg = externalInterfaceMsgDomain.queryBgyInterfaceMsg(streetValue, orgId);
            List<ExternalInterfaceMsg> buildingMsg = externalInterfaceMsgDomain.queryBgyInterfaceMsg(buildingValue, orgId);
            List<BgyRegionComputerRoom> roomList = new ArrayList<>();
            //街道
            List<BgyRegionStreet> streetList = new ArrayList<>();
            //苑区
            List<BgyRegionCourt> courtList = new ArrayList<>();
            //楼栋单元
            List<BgyRegionBuilding> buildingList = new ArrayList<>();
            Date createTime = new Date();
            for (BgyMachineRoomVo bgyMachineRoomVo : list) {
                BgyRegionComputerRoom room = new BgyRegionComputerRoom();
                //区域ID
                Long areaId = bgyMachineRoomVo.getAreaId();
                //项目ID
                Long projectId = bgyMachineRoomVo.getProjectId();
                //苑区id
                Long districtId = bgyMachineRoomVo.getDistrictId();
                //街道id
                Long streetId = bgyMachineRoomVo.getStreetId();
                //楼栋id
                Long buildingId = bgyMachineRoomVo.getBuildingId();
                String description = bgyMachineRoomVo.getDescription();
                if (districtId > 0 && courtMsg.size() == 0) {
                    BgyRegionCourt court = new BgyRegionCourt();
                    String name = ResponseUtil.getDescriptionName(description, districtId, streetId, buildingId, 1);
                    court.setOrganizationId(orgId);
                    court.setName(name);
                    court.setRegionId(areaId);
                    court.setProjectId(projectId);
                    court.setId(districtId);
                    court.setCreateTime(createTime);
                    court.setLogicRemove(false);
                    courtList.add(court);
                }

                if (streetId > 0 && streetMsg.size() == 0) {
                    BgyRegionStreet street = new BgyRegionStreet();
                    String name = ResponseUtil.getDescriptionName(description, districtId, streetId, buildingId, 2);
                    street.setOrganizationId(orgId);
                    street.setName(name);
                    street.setRegionId(areaId);
                    if (districtId > 0) {
                        street.setCourtId(districtId);
                    }
                    street.setProjectId(projectId);
                    street.setId(streetId);
                    street.setCreateTime(createTime);
                    street.setLogicRemove(false);
                    streetList.add(street);
                }

                if (buildingId > 0 && buildingMsg.size() == 0) {
                    BgyRegionBuilding building = new BgyRegionBuilding();
                    String name = ResponseUtil.getDescriptionName(description, districtId, streetId, buildingId, 3);
                    building.setOrganizationId(orgId);
                    building.setName(name);
                    building.setRegionId(areaId);
                    building.setProjectId(projectId);
                    if (districtId > 0) {
                        building.setCourtId(districtId);
                    }
                    if (streetId > 0) {
                        building.setStreetId(streetId);
                    }
                    building.setId(buildingId);
                    building.setCreateTime(createTime);
                    building.setLogicRemove(false);
                    buildingList.add(building);
                }
                room.setId(bgyMachineRoomVo.getId());
                room.setOrganizationId(orgId);
                room.setRegionId(areaId);
                room.setProjectId(projectId);
                if (districtId > 0) {
                    room.setCourtId(districtId);
                }
                if (streetId > 0) {
                    room.setStreetId(streetId);
                }
                if (buildingId > 0) {
                    room.setBuildingId(buildingId);
                }
                room.setName(bgyMachineRoomVo.getName());
                room.setCode(bgyMachineRoomVo.getCode());
                room.setDescription(bgyMachineRoomVo.getDescription());
                room.setCreateTime(createTime);
                room.setLogicRemove(false);
                roomList.add(room);
            }
            if (courtList.size() > 0) {
                //苑区数据去重
                List<BgyRegionCourt> courtList2 = new ArrayList<>();
                for (BgyRegionCourt court : courtList) {
                    boolean bool = courtList2.stream().anyMatch(u -> u.getId().equals(court.getId()));
                    if (!bool) {
                        courtList2.add(court);
                    }
                }
                int totalCount = DbUtil.insertByList("region_court", courtList2);
                if (totalCount != courtList2.size()) {
                    return ResponseVO.error().setMsg("同步集成平台苑区异常");
                } else {
                    externalInterfaceMsgDomain.successInterfaceMsg(orgId, courtValue, totalCount);
                }
            }
            if (streetList.size() > 0) {
                //街道数据去重
                List<BgyRegionStreet> streetList2 = new ArrayList<>();
                for (BgyRegionStreet street : streetList) {
                    boolean bool = streetList2.stream().anyMatch(u -> u.getId().equals(street.getId()));
                    if (!bool) {
                        streetList2.add(street);
                    }
                }
                int totalCount = DbUtil.insertByList("region_street", streetList2);
                if (totalCount != streetList2.size()) {
                    return ResponseVO.error().setMsg("同步集成平台街道异常");
                } else {
                    externalInterfaceMsgDomain.successInterfaceMsg(orgId, streetValue, totalCount);
                }
            }
            if (buildingList.size() > 0) {
                //楼栋单元数据去重
                List<BgyRegionBuilding> buildingList2 = new ArrayList<>();
                for (BgyRegionBuilding building : buildingList) {
                    boolean bool = buildingList2.stream().anyMatch(u -> u.getId().equals(building.getId()));
                    if (!bool) {
                        buildingList2.add(building);
                    }
                }
                int totalCount = DbUtil.insertByList("region_building", buildingList2);
                if (totalCount != buildingList2.size()) {
                    return ResponseVO.error().setMsg("同步集成平台楼栋单元异常");
                } else {
                    externalInterfaceMsgDomain.successInterfaceMsg(orgId, buildingValue, totalCount);
                }
            }
            int totalCount = DbUtil.insertByList("region_computer_room", roomList);
            if (totalCount != roomList.size()) {
                return ResponseVO.error().setMsg("同步集成平台机房异常");
            } else {
                externalInterfaceMsgDomain.successInterfaceMsg(orgId, ExternalConstant.MsgTypeValue.BGY_MOTOR_ROOM_OBTAIN.getValue(), totalCount);
                return ResponseVO.success().setMsg("同步集成平台机房总条数：" + totalCount + "，新增条数：" + totalCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("机房同步异常" + e);
            return ResponseVO.error().setMsg("同步集成平台机房异常");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:同步设备机房增量数据
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public ResponseVO<Object> alterBgyComputerRoomList(List<BgyMachineRoomVo> list, Long orgId) {
        int addType = ExternalConstant.OperationType.ADD.getValue();
        int updateType = ExternalConstant.OperationType.UPDATE.getValue();
        int deleteType = ExternalConstant.OperationType.DELETE.getValue();
        int totalCount = list.size();
        int addCount = 0;
        int updateCount = 0;
        int deleteCount = 0;
        Date createTime = new Date();
        for (BgyMachineRoomVo bgyMachineRoomVo : list) {
            RegionComputerRoom room = new RegionComputerRoom();
            room.setId(bgyMachineRoomVo.getId());
            room.setOrganizationId(orgId);
            room.setRegionId(bgyMachineRoomVo.getAreaId());
            room.setProjectId(bgyMachineRoomVo.getProjectId());
            //苑区id
            Long districtId = bgyMachineRoomVo.getDistrictId();
            //街道id
            Long streetId = bgyMachineRoomVo.getStreetId();
            //楼栋id
            Long buildingId = bgyMachineRoomVo.getBuildingId();
            if (districtId > 0) {
                room.setCourtId(districtId);
            }
            if (streetId > 0) {
                room.setStreetId(streetId);
            }
            if (buildingId > 0) {
                room.setBuildingId(buildingId);
            }
            room.setName(bgyMachineRoomVo.getName());
            room.setCode(bgyMachineRoomVo.getCode());
            room.setDescription(bgyMachineRoomVo.getDescription());
            room.setCreateTime(createTime);
            room.setLogicRemove(false);
            int operType = bgyMachineRoomVo.getOperType();
            //新增
            if (operType == addType) {
                int count = regionComputerRoomDao.insertSelective(room);
                if (count == 1) {
                    addCount++;
                }
            }
            //修改
            if (operType == updateType) {
                int count = regionComputerRoomDao.updateSelective(room);
                if (count == 1) {
                    updateCount++;
                }
            }
            //删除
            if (operType == deleteType) {
                room.setLogicRemove(true);
                int count = regionComputerRoomDao.updateSelective(room);
                if (count == 1) {
                    deleteCount++;
                }
            }
        }
        if (addCount + updateCount + deleteCount != totalCount) {
            throw new RuntimeException("批量同步设备机房增量数据失败!");
        } else {
            Date updateTime = new Date();
            if (list.get(totalCount - 1).getOperTime() != null) {
                updateTime = TimeUtil.parseStrToDateTime(list.get(totalCount - 1).getOperTime());
            }
            int msgType = ExternalConstant.MsgTypeValue.BGY_MOTOR_ROOM_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount,updateTime);
            return ResponseVO.success().setMsg("同步集成平台设备机房增量总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }

    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/20 14:36
     */
    @Override
    public List<Map<String, Object>> queryListRegionComputerRoom(RegionAndBrandVO regionAndBrandVO) {
        return regionComputerRoomDao.queryListRegionComputerRoom(regionAndBrandVO);
    }

    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/20 14:36
     */
    @Override
    public int updateRegionComputerRoom(RegionComputerRoom record) {
        if (record.getId() != null || record.getId() > 0) {
            record.setCreateTime(new Date());
            return regionComputerRoomDao.updateRegionComputerRoom(record);
        }
        return 0;
    }

    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/20 14:37
     */
    @Override
    public int deleteRegionComputerRoom(List<Long> list) {
        if (list.size() > 0) {
            return regionComputerRoomDao.deleteRegionComputerRoom(list);
        }
        return 0;
    }
}
