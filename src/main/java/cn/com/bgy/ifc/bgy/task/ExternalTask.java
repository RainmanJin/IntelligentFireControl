package cn.com.bgy.ifc.bgy.task;

import cn.com.bgy.ifc.service.interfaces.api.system.UserApiService;
import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyEquipmentService;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyOrgService;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyProjectService;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyRegionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: ZhangCheng
 * @description:采用spring定时注解，集成平台接入接口调用
 * @date: 2018-12-18 20:48
 **/
@Component
public class ExternalTask {

    /*@Scheduled(cron="* 0/1 *  * * ? ")
    private void test(){
        System.out.println("xxxxxxxx=====");
    }*/

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

    /**
     * @author: ZhangCheng
     * @description:1.同步集成平台机构
     * @param: []
     * @return: void
     */
    public void obtainBgyOrg(){
        bgyOrgService.baseObtainBgyOrg(1,50);
        System.out.println("同步集成平台机构");
    }

    /**
     * @author: ZhangCheng
     * @description:2.同步集成平台用户
     * @param: []
     * @return: void
     */
    public void obtainUser(){
        userApiService.baseObtainBgyUser(1,1000);
    }
    
    /**
     * @author: ZhangCheng
     * @description:同步集成平台用户权限
     * @param: []
     * @return: void
     */
    public void obtainUserPermission(){
        userApiService.baseObtainBgyUserPermission(1,500);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台区域
     * @param: []
     * @return: void
     */
    public void obtainBgyRegionInfo(){
        bgyRegionInfoService.baseObtainBgyRegionInfo(1,100,1);
        System.out.println("同步集成平台区域");
    }
    
    /**
     * @author: ZhangCheng
     * @description:同步集成平台项目
     * @param: []
     * @return: void
     */
    public void obtainBgyProject(){
        bgyProjectService.baseObtainBgyProject(1,500);
        System.out.println("同步集成平台项目");
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备信息
     * @param: []
     * @return: void
     */
    public void obtainBgyEquipmentInfo(){
        bgyEquipmentService.baseObtainBgyEquipmentInfo(1,500);
    }
    
    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备类型
     * @param: []
     * @return: void
     */
    public void obtainBgyEquipmentType(){
        bgyEquipmentService.baseObtainBgyEquipmentType(1, 100);
    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台设备品牌
     * @param: []
     * @return: void
     */
    public void obtainBgyEquipmentBrand(){
        bgyEquipmentService.baseObtainBgyEquipmentBrand(1,500);
    }
}
