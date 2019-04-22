package cn.ganlixin.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object method,
			Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		
		if (ex instanceof SQLException) {
			mav.setViewName("error-sql");
		} else if (ex instanceof IOException) {
			mav.setViewName("error-io");
		} else {
			mav.setViewName("error");
		}
		return mav;
	}
}
