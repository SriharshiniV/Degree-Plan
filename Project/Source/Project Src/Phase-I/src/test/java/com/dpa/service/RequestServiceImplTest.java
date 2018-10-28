package com.dpa.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequestServiceImplTest {

	@Test
	public void testSendRequest() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testGetSentRequests() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testGetReceivedRequests() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testAcceptRequest() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testGetAcceptedRequests() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testDeleteRequest() {
		/*fail("Not yet implemented");*/
	}

	@Test
	public void testSplitString() {
		RequestService requestService = new RequestServiceImpl();
		String details = "{'userName':['sharanya'],'professorName':['Bryant Barett'],'professorEmail':['BryantBarett@unt.edu'],'studentMajor':['CS']}";
		String[] result = requestService.splitString(details);
		assertEquals(4, result.length);
	}

}
