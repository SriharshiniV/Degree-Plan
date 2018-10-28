package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.LoginDao;
import com.dpa.dao.RequestDao;
import com.dpa.model.Login;

public class RequestServiceImplTest {

	@Test
	public void testSendRequest() {
		/* fail("Not yet implemented"); */
	}

	@Test
	public void testGetSentRequests() {
		/* fail("Not yet implemented"); */
	}

	@Test
	public void testGetReceivedRequests() {
		/* fail("Not yet implemented"); */
	}

	@Test
	public void testAcceptRequest() {
		/* fail("Not yet implemented"); */
	}

	@Test
	public void testGetAcceptedRequests() {
		/* fail("Not yet implemented"); */
	}

	@Test
	public void testDeleteRequest() {
		
	}

	@Test
	public void testSplitString() {
		RequestService requestService = new RequestServiceImpl();
		String details = "{'userName':['sharanya'],'professorName':['Bryant Barett'],'professorEmail':['BryantBarett@unt.edu'],'studentMajor':['CS']}";
		String[] result = requestService.splitString(details);
		assertEquals(4, result.length);
	}

}
