package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.dpa.dao.LoginDao;
import com.dpa.model.Login;

/*@RunWith(MockitoJUnitRunner.class)*/
public class LoginServiceImplTest {
	
	/*@Mock
	private LoginDao logindao;
	
	@InjectMocks
	private LoginService loginService = new LoginServiceImpl();;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoginServiceImpl() {
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		List<Login> result = new ArrayList<Login>();
		when(logindao.validateUser(anyString(),anyString(),anyString())).thenReturn(result);
		List<Login> result1 = loginServiceImpl.checkCredentials(anyString(), anyString(), anyString());
		assertEquals(0, result1.size());
	}
*/
}

