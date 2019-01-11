package cn.com.bgy.ifc.bgy.task;

import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyEquipmentService;
import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyMachineRoomService;
import cn.com.bgy.ifc.service.interfaces.api.system.BgyOrgService;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyProjectService;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyRegionInfoService;
import cn.com.bgy.ifc.service.interfaces.api.system.UserApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: ZhangCheng
 * @description:采用spring定时注解，集成平台接入接口调用
 * @date: 2018-12-18 20:48
 **/
@Component
public class ExternalTask {

    @Autowired
    private BgyOrgService bgyOrgService;

    @Autowired
    private BgyRegionInfoService bgyRegionInfoService;

    @Autowired
    private BgyProjectService bgyProjectService;

    @Autowired
    private BgyEquipmentService bgyEquipmentService;

    @Autowired
    private UserApiService userApiService;

    @Autowired
    private BgyMachineRoomService bgyMachineRoomService;

    /**
     * @author: ZhangCheng
     * @description:1.同步集成平台机构(每天1点开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 00 01 * * ? ")
    public void obtainBgyOrg() {
        bgyOrgService.baseObtainBgyOrg(1, 50);
    }

    /**
     * @author: ZhangCheng
     * @description:2.同步集成平台用户(每天1点10分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 10 01 * * ? ")
    public void obtainUser() {
        userApiService.baseObtainBgyUser(1, 1000);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台用户权限(每天1点20分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 20 01 * * ? ")
    public void obtainUserPermission() {
        userApiService.baseObtainBgyUserPermission(1, 500);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台区域(每天1点30分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 30 01 * * ? ")
    public void obtainBgyRegionInfo() {
        bgyRegionInfoService.baseObtainBgyRegionInfo(1, 100, 1);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台项目(每天1点40分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 40 01 * * ? ")
    public void obtainBgyProject() {
        bgyProjectService.baseObtainBgyProject(1, 500);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备信息(每天1点50分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 50 01 * * ? ")
    public void obtainBgyEquipmentInfo() {
        bgyEquipmentService.baseObtainBgyEquipmentInfo(1, 2000);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备类型(每天2点开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 00 02 * * ? ")
    public void obtainBgyEquipmentType() {
        bgyEquipmentService.baseObtainBgyEquipmentType(1, 100);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备型号(每天2点10分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 10 02 * * ? ")
    public void obtainBgyEquipmentVersion() {
        bgyEquipmentService.baseObtainBgyEquipmentVersion(1, 500);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备品牌(每天2点20分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 20 02 * * ? ")
    public void obtainBgyEquipmentBrand() {
        bgyEquipmentService.baseObtainBgyEquipmentBrand(1, 500);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台苑区街道楼栋机房信息(每天2点30分开始同步)
     * @param: []
     * @return: void
     */
    @Scheduled(cron = "0 30 02 * * ? ")
    public void obtainBgyMachineRoom() {
        bgyMachineRoomService.baseObtainBgyMachineRoom(1, 1000);
    }
}
