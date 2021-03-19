package com.socgen.dataprovider;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.socgen.dao.DepartmentDao;
import com.socgen.dao.EmployeeDao;
import com.socgen.entity.Department;
import com.socgen.entity.Employee;
import com.socgen.rde.EmployeeRole;
import com.socgen.rde.EmployeeDesignation;
import com.socgen.rde.EmploymentStatusType;
import com.socgen.rde.EmploymentType;
import com.socgen.service.EmployeeService;

@Component
public class DataProvider implements CommandLineRunner {

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeService employeeService;

	@Override
	public void run(String... args) throws Exception {

		insertTempDeptartments();

//		insertTempEmployees();
//
//		getTempEmployees();
//
//		updateTempEmployees();
//
//		deleteTempEmployees();
//
//		getAllTempEmployees();

	}

	private void getAllTempEmployees() {
		System.out.println(employeeService.getAllActiveEmployees());
	}

	private void getTempEmployees() {
		System.out.println(employeeService.getEmployeeById(3));
	}

	private void updateTempEmployees() {
//		Employee emp = employeeService.getEmployeeById(3);
//		emp.setDateOfBirth(LocalDate.of(2000, 2, 28));
//		employeeService.update(emp);
	}

	private void deleteTempEmployees() {
		employeeService.inactivateEmployeeById(3);
	}

	private void insertTempEmployees() {
//		Employee e1 = new Employee("Suhaib", EmploymentType.FullTime, EmployeeDesignation.Officer,
//				EmployeeRole.Developer, 1_00_000, true, EmploymentStatusType.Hired, "New Joiner",
//				LocalDate.of(2021, 5, 5), null, LocalDate.of(1997, 2, 22), departmentDao.findById(1).get());
//
//		Employee e2 = new Employee("Muhammed", EmploymentType.PartTime, EmployeeDesignation.Officer,
//				EmployeeRole.Developer, 50_000, true, EmploymentStatusType.Hired, "New Joiner",
//				LocalDate.of(2021, 5, 5), null, LocalDate.of(1997, 2, 22), departmentDao.findById(2).get());
//
//		employeeDao.save(e1);
//		employeeDao.save(e2);
	}

	private void insertTempDeptartments() {
		Department d1 = new Department("Foreign Exchange", "FXLM", true);
		Department d2 = new Department("Global Consumer Technology", "GCT", true);

		departmentDao.save(d1);
		departmentDao.save(d2);
	}

}
