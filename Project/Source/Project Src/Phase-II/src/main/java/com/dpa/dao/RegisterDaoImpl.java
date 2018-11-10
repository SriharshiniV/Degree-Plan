package com.dpa.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.model.Register;

@Service
public class RegisterDaoImpl implements RegisterDao {
	@Autowired 
	DataSource dataSource;

	//insert the new users into the database
	public int insertUserDetails(Register register) {
		// TODO Auto-generated method stub
		String role = register.getRole();
		if(role == "chair" || role == "associatechair")
		{
			role = "professor";
		}
		int result;
		try {
		String sql = "INSERT INTO register " + "(name, email, role, userName, password) VALUES (?, ?, ?, ?, ?)"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		result = jdbcTemplate.update(sql, new Object[] {register.getName(), register.getEmail(), register.getRole(), register.getUserName(), register.getPassword()});
		String sql1 =  "INSERT INTO login " + "(userName, password, role) VALUES (?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		int result1 = jdbcTemp.update(sql1, new Object[] {register.getUserName(),register.getPassword(),role});
		}catch(Exception e) {
		 System.out.println(e);
		  result = 0;
		}
		return result;
	}

}
