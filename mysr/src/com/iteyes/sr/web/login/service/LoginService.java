package com.iteyes.sr.web.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteyes.sr.web.login.bean.LoginBean;
import com.iteyes.sr.web.login.dao.ILoginDao;

@Service(value="ILoginService")
public class LoginService implements ILoginService {
	
	@Autowired
	public ILoginDao iLoginDao;

	@Override
	public LoginBean getUserInfo(LoginBean lb) throws Throwable {
		return iLoginDao.getUserInfo(lb);
	}

}
