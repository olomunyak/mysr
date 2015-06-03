package com.iteyes.sr.web.login.service;

import com.iteyes.sr.web.login.bean.LoginBean;

public interface ILoginService {

	public LoginBean getUserInfo(LoginBean lb) throws Throwable;

}
