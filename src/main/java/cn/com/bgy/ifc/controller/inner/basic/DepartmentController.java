package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-05 09:30
 **/
@Controller
@RequestMapping("/basic/department")
public class DepartmentController {
    @Autowired
    private DepartmentDomain departmentDomain;
}
