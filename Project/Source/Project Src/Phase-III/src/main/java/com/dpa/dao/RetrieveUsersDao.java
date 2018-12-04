package com.dpa.dao;

import java.util.List;

import com.dpa.model.Register;
import com.dpa.model.Request;

public interface RetrieveUsersDao {

	 List<Request> getMyStudents(String uName);

	Request getMyAdvisors(String userName);

	List<Register> getStudentList();

	List<Register> getToApprovalList();

	List<Register> getstaffList();

}
