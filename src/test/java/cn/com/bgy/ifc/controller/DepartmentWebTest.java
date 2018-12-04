package cn.com.bgy.ifc.controller;

import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentWebTest {

    @Autowired
    private DepartmentDomain departmentDomain;
    @Test
    public void test(){
       /* Department department=new Department();
        department.setId(1L);
        department.setName("測試部門XXS");
        department.setParentId(0L);
        department.setState(1);
        department.setOrganizationId(1L);
        department.setLogicRemove(false);
        department.setCreateTime(new Date());
        int count=departmentDomain.update(department);*/
       // Department department=departmentDomain.findById(1L);
        int count=departmentDomain.deleteById(1l);
        System.out.println(count);
    }
}
