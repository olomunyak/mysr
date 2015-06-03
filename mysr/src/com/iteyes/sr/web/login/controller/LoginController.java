package com.iteyes.sr.web.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iteyes.sr.web.login.bean.LoginBean;
import com.iteyes.sr.web.login.service.ILoginService;

@Controller
public class LoginController {
	
	@Autowired
	public ILoginService iLoginService;

	@RequestMapping(value = "/login")
	public ModelAndView login(
			HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView) throws Throwable {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("sUserId") != null) {
			modelAndView.setViewName("redirect:hello");
		} else {
			modelAndView.addObject("msg", request.getParameter("msg"));
			
			modelAndView.setViewName("login/login");
		}
		

		return modelAndView;
	}
	
	@RequestMapping(value = "/loginResult")
	public ModelAndView loginResult(
			@ModelAttribute(value="LoginBean") LoginBean lb,
			HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView) throws Throwable {
		
		LoginBean userInfo = iLoginService.getUserInfo(lb);
		
		if(userInfo != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("sUserNo", userInfo.getUserNo());
			session.setAttribute("sUserId", userInfo.getUserId());
			session.setAttribute("sUserNm", userInfo.getUserNm());
			
			modelAndView.setViewName("redirect:main");
		} else {
			modelAndView.addObject("msg", "Login Failed.");
			
			modelAndView.setViewName("redirect:login");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/main")
	public ModelAndView main(
			HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView) throws Throwable {
		
		modelAndView.setViewName("main");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(
			HttpServletRequest request, HttpServletResponse response,
			ModelAndView modelAndView) throws Throwable {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		String msg = "로그아웃 되었습니다.";
		
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("redirect:login");

		return modelAndView;
	}
}






