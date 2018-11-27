package cn.com.bgy.ifc.controller.inner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/top")
	public String top() {
		return "top";
	}

	@GetMapping("/left")
	public String left() {
		return "left";
	}

	@GetMapping("/footer")
	public String footer() {
		return "footer";
	}

	@GetMapping("/mainContent")
	public String mainContent() {
		return "mainContent";
	}
}
