package com.dpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.RequestDao;
import com.dpa.model.Request;

@Service
public class RequestServiceImpl implements RequestService{
	@Autowired
	RequestDao requestDao;
	
	public int sendRequest(Request sendRequest) {
		// TODO Auto-generated method stub
		int result = requestDao.sendAdvisorRequest(sendRequest);
		return result;
	}

	public List<Request> getSentRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> requests = new ArrayList<Request>();
		requests = requestDao.getSentRequests(userName);
		return requests;
	}

	public List<Request> getReceivedRequests(String userName) {
		// TODO Auto-generated method stub
		List<Request> receivedRequests = new ArrayList<Request>();
		receivedRequests = requestDao.getReceivedRequests(userName);
		return receivedRequests;
	}

	public int acceptRequest(String sName, String sMajor, String pName,String pEmail) {
		// TODO Auto-generated method stub
		int result = requestDao.acceptRequest(sName, sMajor, pName, pEmail);
		return result;
	}

	public List<Request> getAcceptedRequests(String userName) {
		List<Request> acceptedRequests = new ArrayList<Request>();
		acceptedRequests = requestDao.getacceptedRequests(userName);
		return acceptedRequests;
	}

	public int deleteRequest(String pEmail, String sName) {
		int deleteStatus = requestDao.deleteRequest(pEmail, sName);
		return deleteStatus;
	}

}
