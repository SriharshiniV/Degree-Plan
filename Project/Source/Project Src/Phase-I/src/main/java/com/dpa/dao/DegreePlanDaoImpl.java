package com.dpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dpa.jdbc.CourseRowMapper;
import com.dpa.jdbc.CoursesRowMapper;
import com.dpa.jdbc.DegreePlanRowMapper;
import com.dpa.jdbc.LoginRowMapper;
import com.dpa.jdbc.OptionalCourseRowMapper;
import com.dpa.model.Course;
import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.dpa.model.Login;

@Service
public class DegreePlanDaoImpl implements DegreePlanDao {
	@Autowired
	DataSource dataSource;

	// Get the course list from the database
	@Override
	public List<Course> getCoreCourses() {
		List<Course> courseList = new ArrayList<Course>();
		String sql = "select * from mandatorycourses";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		courseList = jdbctem.query(sql, new CourseRowMapper());
		return courseList;
	}

	// return all CSCE Department courses
	@Override
	public List<String> getOptionalCourses() {
		List<String> optionalCourses = new ArrayList<String>();
		String sql = "select * from courses";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		optionalCourses = jdbctem.query(sql, new OptionalCourseRowMapper());
		return optionalCourses;
	}

	// inserts the degree plan into database
	@Override
	public int submitDegreePlan(DegreePlan degreePlan, String userName) {
		String sql1 = "INSERT INTO gre "
				+ "(userName, verbal, quantitative, analytical, dateTaken) VALUES (?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		jdbcTemp.update(sql1,
				new Object[] { degreePlan.getName(), degreePlan.getGre().getVerbal(),
						degreePlan.getGre().getQuantitative(), degreePlan.getGre().getAnalytical(),
						degreePlan.getGre().getDateTaken() });
		String sql = "INSERT INTO degreeplan "
				+ "(userName, name, studentId, localAddress, email, degree, major, minor, interestArea, majorProfessor, coMajorProfessor, totalCreditHours, degreePlanStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int result = jdbcTemplate.update(sql,
				new Object[] { userName, degreePlan.getName(), degreePlan.getStudentId(), degreePlan.getLocalAddress(),
						degreePlan.getEmail(), degreePlan.getDegree(), degreePlan.getMajor(), degreePlan.getMinor(),
						degreePlan.getInterestArea(), degreePlan.getMajorProfessor(), degreePlan.getCoMajorProfessor(),
						degreePlan.getTotalCreditHours(), "submitted" });
		int coreReturn = insertCoreCourses(degreePlan, userName);
		int courseReturn = insertOptionalCourses(degreePlan, userName);
		String sql2 = "update majorprofessor set degreePlanStatus = ? where studentName = ?";
		JdbcTemplate jdbcTemp1 = new JdbcTemplate(dataSource);
		jdbcTemp1.update(sql2, new Object[] { "yes", userName });
		return result;
	}

	// inserts optional courses
	private int insertOptionalCourses(DegreePlan degreePlan, String userName) {
		String sql = "INSERT INTO courses_dp "
				+ "(userName, courseCatergory, courseName, semesterTaken, cHrs, grade) VALUES (?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		String courseCategory = "optional";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse1().getCourse(),
						degreePlan.getOpCourse1().getSemesterTaken(), degreePlan.getOpCourse1().getcHrs(),
						degreePlan.getOpCourse1().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse2().getCourse(),
						degreePlan.getOpCourse2().getSemesterTaken(), degreePlan.getOpCourse2().getcHrs(),
						degreePlan.getOpCourse2().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse3().getCourse(),
						degreePlan.getOpCourse3().getSemesterTaken(), degreePlan.getOpCourse3().getcHrs(),
						degreePlan.getOpCourse3().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse4().getCourse(),
						degreePlan.getOpCourse4().getSemesterTaken(), degreePlan.getOpCourse4().getcHrs(),
						degreePlan.getOpCourse4().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse5().getCourse(),
						degreePlan.getOpCourse5().getSemesterTaken(), degreePlan.getOpCourse5().getcHrs(),
						degreePlan.getOpCourse5().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse6().getCourse(),
						degreePlan.getOpCourse6().getSemesterTaken(), degreePlan.getOpCourse6().getcHrs(),
						degreePlan.getOpCourse6().getGrade() });
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getOpCourse7().getCourse(),
						degreePlan.getOpCourse7().getSemesterTaken(), degreePlan.getOpCourse7().getcHrs(),
						degreePlan.getOpCourse7().getGrade() });
		int result = jdbcTemp.update(sql,
				new Object[] { userName, courseCategory, degreePlan.getOpCourse8().getCourse(),
						degreePlan.getOpCourse8().getSemesterTaken(), degreePlan.getOpCourse8().getcHrs(),
						degreePlan.getOpCourse8().getGrade() });
		return result;
	}

	// inserts core courses
	private int insertCoreCourses(DegreePlan degreePlan, String userName) {
		// inserts core course A
		String sql = "INSERT INTO courses_dp "
				+ "(userName, courseCatergory, courseName, semesterTaken, cHrs, grade) VALUES (?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemp = new JdbcTemplate(dataSource);
		String courseCategory = "courseA";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseA().getCourse(),
						degreePlan.getCourseA().getSemesterTaken(), degreePlan.getCourseA().getcHrs(),
						degreePlan.getCourseA().getGrade() });

		// inserts core course B
		courseCategory = "courseB";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseB().getCourse(),
						degreePlan.getCourseB().getSemesterTaken(), degreePlan.getCourseB().getcHrs(),
						degreePlan.getCourseB().getGrade() });

		// inserts core course C
		courseCategory = "courseC";
		jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseC().getCourse(),
						degreePlan.getCourseC().getSemesterTaken(), degreePlan.getCourseC().getcHrs(),
						degreePlan.getCourseC().getGrade() });

		// inserts core course D
		courseCategory = "courseD";
		int result = jdbcTemp.update(sql,
				new Object[] { degreePlan.getName(), courseCategory, degreePlan.getCourseD().getCourse(),
						degreePlan.getCourseD().getSemesterTaken(), degreePlan.getCourseD().getcHrs(),
						degreePlan.getCourseD().getGrade() });

		return result;
	}

//get the degree plan information of a particular student from the database
	@Override
	public DegreePlan getDegreePlan(String sName, String userName) {
		String sql = "select name from register where userName = '" + userName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		String profName = jdbctem.queryForObject(sql, String.class);
		String sql1 = "select * from degreeplan where name= '" + sName + "' and majorProfessor = '" + profName + "'";
		DegreePlan degreePlan = (DegreePlan) jdbctem.queryForObject(sql1, new BeanPropertyRowMapper(DegreePlan.class));
		return degreePlan;
	}

	@Override
	public GRE getGREScores(String sName) {
		String sql = "select * from gre where userName= '" + sName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		GRE gre = (GRE) jdbctem.queryForObject(sql, new BeanPropertyRowMapper(GRE.class));
		return gre;
	}

	@Override
	public List<Courses> getCourses(String sName) {
		String sql = "select * from courses_dp where userName= '" + sName + "'";
		JdbcTemplate jdbctem = new JdbcTemplate(dataSource);
		List<Courses> courses = new ArrayList<Courses>();
		courses = jdbctem.query(sql, new CoursesRowMapper());
		return courses;
	}

}
