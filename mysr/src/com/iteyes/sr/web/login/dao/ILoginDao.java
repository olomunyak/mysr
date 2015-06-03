package com.iteyes.sr.web.login.dao;

import com.iteyes.sr.web.login.bean.LoginBean;

public interface ILoginDao {

	public LoginBean getUserInfo(LoginBean lb) throws Throwable;

}
