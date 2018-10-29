package com.dpa.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dpa.dao.DegreePlanDao;
import com.dpa.model.Course;
import com.dpa.model.DegreePlan;
import com.dpa.model.Login;

public class DegreePlanServiceImplTest {
	@Mock
	private DegreePlanDao degreePlanDao;
	
	@InjectMocks
	private DegreePlanServiceImpl degreePlanService;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testGetGroupACourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("A");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CE");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("A");c3.setMajor("CE");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("A");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupACourses("CE");
		assertEquals(2, result.size());
	}

	@Test
	public void testGetGroupBCourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("B");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CS");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("B");c3.setMajor("CS");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("D");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupBCourses("CS");
		assertNotEquals(3, result.size());
	}

	@Test
	public void testGetGroupCCourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("A");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CE");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("C");c3.setMajor("CS");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("C");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupCCourses("CE");
		assertEquals(1, result.size());
	}

	@Test
	public void testGetGroupDCourses() {
		Course c1 = new Course();c1.setCourseName("CSCE 5500");c1.setGroupId("A");c1.setMajor("CS");
		Course c2 = new Course();c2.setCourseName("CSCE 5400");c2.setGroupId("B");c2.setMajor("CE");
		Course c3 = new Course();c3.setCourseName("CSCE 5600");c3.setGroupId("D");c3.setMajor("CS");
		Course c4 = new Course();c4.setCourseName("CSCE 5200");c4.setGroupId("D");c4.setMajor("CE");
		List<Course> mockList = new ArrayList<Course>();
		mockList.add(c1);mockList.add(c2);mockList.add(c3);mockList.add(c4);
		when(degreePlanDao.getCoreCourses()).thenReturn(mockList);
		List<Course> result = degreePlanService.getGroupDCourses("CS");
		assertEquals(1, result.size());
	}

	@Test
	public void testGetOptionalCourses() {
		List<String> mockCourseList = Arrays.asList("CSCE 5350 SE", "CSCE5450 CS");
		when(degreePlanDao.getOptionalCourses()).thenReturn(mockCourseList);
		List<String> result = new ArrayList<String>();
		result = degreePlanService.getOptionalCourses();
		assertEquals(2, result.size());
	}

	@Test
	public void testSubmitDegreePlan() {
		when(degreePlanDao.submitDegreePlan(any(), anyString())).thenReturn(1);
		int result = degreePlanService.submitDegreePlan(any(), anyString());
		assertEquals(1, result);
	}

}
