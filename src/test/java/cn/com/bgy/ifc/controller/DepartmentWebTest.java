package cn.com.bgy.ifc.controller;

import cn.com.bgy.ifc.service.interfaces.api.project.BgyRegionInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentWebTest {

    @Autowired
    private BgyRegionInfoService bgyBrandService;

    ;
    @Test
    public void test(){
//        int pageNum = 1;
//        int pageSize = 5;
//        bgyBrandService.obtainBgyRegionInfoIncrement(pageNum,pageSize,"2017-01-01 00:00:00");
    }
}
