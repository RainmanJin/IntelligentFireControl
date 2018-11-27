package cn.com.bgy.ifc.controller.inner.projects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @GetMapping("/projectPage")
    public String projectPage(){

        return "/project/projectPage";
    }
}
