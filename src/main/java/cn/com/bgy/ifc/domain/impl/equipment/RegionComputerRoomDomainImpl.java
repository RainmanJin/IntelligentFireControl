package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.utils.DBUtil;
import cn.com.bgy.ifc.bgy.utils.StringUtil;
import cn.com.bgy.ifc.dao.project.*;
import cn.com.bgy.ifc.domain.interfaces.equipment.RegionComputerRoomDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.project.RegionCourt;
import cn.com.bgy.ifc.entity.po.project.RegionProject;
import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.BgyMachineRoomVo;
import cn.com.bgy.ifc.entity.vo.project.RegionComputerRoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private RegionProjectDao regionProjectDao;

    @Resource
    private RegionCourtDao regionCourtDao;

    @Resource
    private RegionStreetDao regionStreetDao;

    @Resource
    private RegionBuildingDao regionBuildingDao;


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
            int totalCount = DBUtil.insertByList("region_computer_room", roomList);
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
            int msgType = ExternalConstant.MsgTypeValue.BGY_MOTOR_ROOM_OBTAIN.getValue();
            externalInterfaceMsgDomain.alterInterfaceMsg(orgId, msgType, totalCount, addCount, updateCount, deleteCount);
            return ResponseVO.success().setMsg("同步集成平台设备机房增量总条数：" + totalCount + "，新增条数：" + addCount + ",修改条数：" + updateCount + ",删除条数：" + deleteCount + ",成功条数：" + totalCount + "，失败条数" + 0 + "");
        }
    }
    /**
     * @Author huxin
     * @Description 查询
     * @Date 2018/12/20 14:36
     */
    @Override
    public List<RegionComputerRoomVo> queryListRegionComputerRoom( RegionComputerRoomVo record ) {
        return regionComputerRoomDao.queryListRegionComputerRoom(record);
    }
    /**
     * @Author huxin
     * @Description 修改
     * @Date 2018/12/20 14:36
     */
    @Override
    public int updateRegionComputerRoom( RegionComputerRoom record ) {
        if(record.getId()>0){
            //查询苑区信息
            RegionComputerRoom computerRoom = regionComputerRoomDao.queryRegionComputerRoomById(record.getId());
            //修改街道信息
            if(computerRoom.getStreetId() != record.getStreetId()){
                RegionStreet street= new RegionStreet();
                street.setId(record.getStreetId());
                street.setCourtId(record.getCourtId());
                street.setProjectId(record.getProjectId());
                street.setRegionId(record.getRegionId());
                regionStreetDao.updateRegionStreet(street);
            }
            //修改苑区信息
            if(computerRoom.getCourtId() != record.getCourtId()){
                RegionCourt court = new RegionCourt();
                court.setId(record.getCourtId());
                court.setProjectId(record.getProjectId());
                court.setRegionId(record.getRegionId());
                regionCourtDao.updateRegionCourt(court);
            }
            //修改项目信息
            if(computerRoom.getProjectId()!= record.getProjectId()){
                RegionProject project = new RegionProject();
                project.setId(record.getProjectId());
                project.setRegionId(record.getRegionId());
                regionProjectDao.updateSelective(project);
            }
            //查询苑区名
            String courtName = regionCourtDao.queryRegionCourtNameById(record.getCourtId());
            //查询街道名
            String streetName = regionStreetDao.queryRegionStreetNameById(record.getStreetId());
            //查询楼栋名
            String buildingName= regionBuildingDao.queryRegionBuildingtNameById(record.getBuildingId());

            if(StringUtil.isNotEmpty(courtName) || StringUtil.isNotEmpty(streetName) || StringUtil.isNotEmpty(buildingName)){
                record.setName(courtName+courtName+streetName);
                record.setCreateTime(new Date());
                return regionComputerRoomDao.updateRegionComputerRoom(record);
            }
        }
        return 0;
    }
    /**
     * @Author huxin
     * @Description 删除
     * @Date 2018/12/20 14:37
     */
    @Override
    public int deleteRegionComputerRoom( List<Long> list ) {
        return regionComputerRoomDao.deleteRegionComputerRoom(list);
    }
}
