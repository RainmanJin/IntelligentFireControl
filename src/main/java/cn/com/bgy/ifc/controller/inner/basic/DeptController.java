package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic/dept")
public class DeptController {

    @GetMapping("/deptPage")
    public String deptPage(){

        return "/basic/deptPage";
    }
}
