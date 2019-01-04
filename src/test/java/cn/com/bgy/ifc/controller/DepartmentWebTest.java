package cn.com.bgy.ifc.controller;

import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.domain.interfaces.system.UserGroupItemsDomain;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyEquipmentService;
import cn.com.bgy.ifc.service.interfaces.api.maintenance.BgyMaintenanceCompanyService;
import cn.com.bgy.ifc.service.interfaces.api.system.UserApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentWebTest {

    @Autowired
    private BgyEquipmentService bgyEquipmentService;

    @Autowired
    private BgyMaintenanceCompanyService bgyMaintenanceCompanyService;

    @Autowired
    private UserApiService userApiService;

    @Autowired
    private UserGroupItemsDomain userGroupItemsDomain;

    @Test
    public void test() {
        //String ids = "[1,2]";
       // List<Long> list = ListUtil.getListId(ids);
        ResponseVO<Object> vo=bgyMaintenanceCompanyService.baseObtainBgyRepairCompany(1,200);
        System.out.println("list" + vo.getMsg());
        // bgyEquipmentService.baseObtainBgyEquipmentInfo(1,1000);
        // bgyMachineRoomService.baseObtainBgyMachineRoom(1, 1000);
        //userApiService.baseObtainBgyUserPermission(1,500);
        // bgyRepairCompanyService.baseObtainBgyRepairCompany(1,500);
        //.baseObtainBgyUserPermission(1,500);
        //bgyMachineRoomService.baseObtainBgyMachineRoom(1,10);
        //  bgyEquipmentService.baseObtainBgyEquipmentVersion(1,500);
        //  bgyProjectService.baseObtainBgyProject(pageNum, pageSize);
        // bgyRegionInfoService.baseObtainBgyRegionInfo(pageNum, pageSize,1);
        // bgyUserService.baseObtainBgyMachineRoom();
    }
}
