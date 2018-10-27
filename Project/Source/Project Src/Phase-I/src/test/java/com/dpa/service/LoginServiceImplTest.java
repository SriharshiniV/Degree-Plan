package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.LoginDao;
import com.dpa.model.Login;

public class LoginServiceImplTest {

	/*@Test
	public void testLoginServiceImpl() {
		LoginDao loginDaoMock = mock(LoginDao.class);
		when(loginDaoMock.validateUser("sharanya", "d232704062b0fea5c8d5b869cddef2a5", "student"));
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl(loginDaoMock);
		List<Login>  result1 = loginServiceImpl.checkCredentials("sharanya", "d232704062b0fea5c8d5b869cddef2a5", "student") ;
		assertEquals(0, result1.size());
	}*/

}

