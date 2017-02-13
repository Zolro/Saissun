package com.sais.test;

import com.sais.dao.GetAccessTokenDAO;
import com.sais.dao.imp.GetAccessTokenDAOImp;

public class OnlyAccessTokenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetAccessTokenDAO at=new GetAccessTokenDAOImp();
		System.out.println(at.getAccess());
		
	}

}
