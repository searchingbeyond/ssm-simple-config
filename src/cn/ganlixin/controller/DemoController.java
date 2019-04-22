package cn.ganlixin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ganlixin.exception.UnauthorizeException;

@Controller
public class DemoController {

	@RequestMapping("test")
	public String test() throws UnauthorizeException {
		
		int i = 1;
		if (i == 1) {
			throw new UnauthorizeException("not authorized");
		}
		return "success";
	}
}
