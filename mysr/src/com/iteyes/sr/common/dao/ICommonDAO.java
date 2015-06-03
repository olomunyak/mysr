package com.iteyes.sr.common.dao;

import java.util.ArrayList;

import com.iteyes.sr.common.bean.CodeBean;

public interface ICommonDAO {

	public ArrayList<CodeBean> getCode(String lCd) throws Throwable;
	
	public int getCodeCount(String lCd) throws Throwable;
}
