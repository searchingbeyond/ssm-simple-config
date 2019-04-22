package cn.ganlixin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ganlixin.pojo.User;
import cn.ganlixin.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/select")
	public String selectOne(HttpServletRequest req) {
		
		User u = new User(2, "aaa", "beijing");
		User user = userService.selectUserById(u);
		if (user == null) {
			req.setAttribute("msg", "not found this user");
			return "error";
		} else {
			req.setAttribute("user", user);
			return "info";
		}
	}
}
