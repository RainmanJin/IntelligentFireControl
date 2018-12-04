package cn.com.bgy.ifc.controller.inner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
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
    @RequestMapping("/test")
    public String xslsheet(){
		logger.trace("I am trace log.");
		logger.debug("I am debug log.");
		logger.warn("I am warn log.");
		logger.error("I am error log.");
		return "top";
    }
}
