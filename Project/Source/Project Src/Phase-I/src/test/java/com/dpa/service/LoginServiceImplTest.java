package com.dpa.service;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.dpa.dao.LoginDao;
import com.dpa.model.Login;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ LoginServiceImpl.class, LoginDao.class })
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
	private List<Login> mockLoginList;
	private LoginDao mockLoginDao;
	
	@Before
	public void setup() {
		
		mockLoginDao = Mockito.mock(LoginDao.class);
		try {
			PowerMockito.whenNew(LoginDao.class).withAnyArguments().thenReturn(mockLoginDao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testLoginList() {
		mockLoginList = new ArrayList<Login>();
		mockLoginList.add(new Login());
		when(mockLoginDao.validateUser(Matchers.anyString(), Matchers.anyString(), Matchers.anyString()))
		.thenReturn(mockLoginList);
		LoginServiceImpl mockObj = new LoginServiceImpl();
		List<Login> actualLoginList = mockObj.checkCredentials("user", "password", "role");
		Assert.assertEquals(mockLoginList, actualLoginList);
		
	}
	
	
}

