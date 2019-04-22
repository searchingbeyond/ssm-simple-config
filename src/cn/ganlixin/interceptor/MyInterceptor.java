package cn.ganlixin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object method) throws Exception {
		System.out.println("执行preHandle");
		
		// 执行业务代码
		
		return true; // 执行请求对应的controller
		// return false;  // 拦截请求，不进行其他操作
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object method, ModelAndView mav)
			throws Exception {
		System.out.println("执行postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object method, Exception ex)
			throws Exception {
		System.out.println("执行afterCompletion");
	}
}
