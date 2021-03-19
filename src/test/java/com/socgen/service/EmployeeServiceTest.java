package com.socgen.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.socgen.dao.EmployeeDao;
import com.socgen.entity.Department;
import com.socgen.entity.Employee;
import com.socgen.exception.NotFoundException;
import com.socgen.model.EmployeeModel;
import com.socgen.rde.EmployeeRole;
import com.socgen.rde.EmploymentType;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;

	@Mock
	private EmployeeDao dao;

	@Mock
	private DepartmentService departmentService;

	@Test
	public void testGetAll() throws Exception {

		Map<String, Map<String, List<Employee>>> expected = new HashMap<>();
		List<Employee> daoList = new ArrayList<>(3);

		Employee e1 = new Employee();
		e1.setIsActive(true);
		e1.setEmployeeRole(EmployeeRole.Developer);
		e1.setEmployeeType(EmploymentType.FullTime);
		daoList.add(e1);

		Employee e2 = new Employee();
		e2.setIsActive(true);
		e2.setEmployeeRole(EmployeeRole.Developer);
		e2.setEmployeeType(EmploymentType.Internship);
		daoList.add(e2);

		Employee e3 = new Employee();
		e3.setIsActive(true);
		e3.setEmployeeRole(EmployeeRole.Developer);
		e3.setEmployeeType(EmploymentType.Internship);
		daoList.add(e3);

		Map<String, List<Employee>> fulltimeMap = new HashMap<>(1);
		
		List<Employee> list = new ArrayList<>(1);
		list.add(e1);
		fulltimeMap.put(EmploymentType.FullTime.name(), list);
		expected.put(EmployeeRole.Developer.name(), fulltimeMap);
		
		List<Employee> internList = new ArrayList<>(2);
		internList.add(e2);
		internList.add(e3);
		
		expected.get(EmployeeRole.Developer.name()).put(EmploymentType.Internship.name(), internList);

		Mockito.when(dao.findAll()).thenReturn(daoList);
		Map<String, Map<String, List<Employee>>> actual = employeeService.getAllActiveEmployees();
		assertEquals(expected, actual);
	}

	@Test
	public void testInsert() throws Exception {
		Employee expected = Mockito.mock(Employee.class);
		EmployeeModel mockModel = Mockito.mock(EmployeeModel.class);
		Mockito.when(dao.save(Mockito.any(Employee.class))).thenReturn(expected);
		Mockito.when(mockModel.getDepartment()).thenReturn(Mockito.mock(Department.class));
		// Mockito.when(departmentService.getDepartmentFromCode(Mockito.anyString())).thenReturn(Mockito.mock(Department.class));
		Employee actual = employeeService.insert(mockModel);
		assertEquals(expected, actual);
	}

	@Test
	public void testUpdate() throws Exception {
		Employee expected = Mockito.mock(Employee.class);
		EmployeeModel mockModel = Mockito.mock(EmployeeModel.class);
		Mockito.when(dao.save(Mockito.any(Employee.class))).thenReturn(expected);
		Mockito.when(mockModel.getDepartment()).thenReturn(Mockito.mock(Department.class));
		// Mockito.when(departmentService.getDepartmentFromCode(Mockito.anyString())).thenReturn(Mockito.mock(Department.class));
		Employee actual = employeeService.update(mockModel);
		assertEquals(expected, actual);
	}

	@Test
	public void testGetEmployeeById() throws Exception {
		Employee expected = Mockito.mock(Employee.class);
		Mockito.when(dao.findById(Mockito.anyInt())).thenReturn(Optional.of(expected), Optional.empty());
		Employee actual = employeeService.getEmployeeById(1);
		assertEquals(expected, actual);
		assertEquals(null, employeeService.getEmployeeById(0));
	}

	@Test
	public void testInactivateEmployeeByIdForExisting() throws Exception {
		Employee expected = Mockito.mock(Employee.class);
		Mockito.when(dao.findById(Mockito.anyInt())).thenReturn(Optional.of(expected));
		Mockito.when(dao.save(Mockito.any(Employee.class))).thenReturn(expected);
		employeeService.inactivateEmployeeById(1);
	}

	@Test(expected = NotFoundException.class)
	public void testInactivateEmployeeByIdForNonExisting() throws Exception {
		Mockito.when(dao.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		employeeService.inactivateEmployeeById(0);
	}

}
