package com.dpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dpa.dao.RequestDao;
import com.dpa.dao.RetrieveUsersDao;
import com.dpa.model.Register;
import com.dpa.model.Request;

@Service
public class RetrieveUsersServiceImpl implements RetrieveUsersService{
	@Autowired
	RetrieveUsersDao retrieveStudentsDao;
	public List<Request> getMyStudents(String userName) {
		// TODO Auto-generated method stub
		List<Request> myStudents = retrieveStudentsDao.getMyStudents(userName);
		return myStudents;
	}
	public List<Request> getMyAdvisors(String userName) {
		// TODO Auto-generated method stub
		List<Request> myAdvisors = retrieveStudentsDao.getMyAdvisors(userName);
		return myAdvisors;
	}
	public List<Register> getStudentList() {
		// TODO Auto-generated method stub
		List<Register> students = retrieveStudentsDao.getStudentList();
		return students;
	}

}
