package com.socgen.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.entity.Employee;
import com.socgen.exception.BadRequestException;
import com.socgen.model.EmployeeModel;
import com.socgen.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

	private static AtomicInteger requestNumber = new AtomicInteger(0); // for logging purposes.
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	private Map<String, Map<String, List<Employee>>> getAllEmployees() {
		return employeeService.getAllActiveEmployees();
	}

	@GetMapping("/employee/{employeeId}")
	private Employee getEmployeeById(@PathVariable Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@DeleteMapping("/employee/{employeeId}")
	private void inactivateEmployeeById(@PathVariable Integer employeeId) {
		employeeService.inactivateEmployeeById(employeeId);
	}

	@PostMapping("/employee")
	private Employee insertEmployee(@RequestBody EmployeeModel emp) {
		if (emp.getId() != null) {
			throw new BadRequestException(
					"Employee id will be auto generated for new employees. Please attempt with a valid request.");
		}
		return employeeService.insert(emp);
	}

	@PutMapping("/employee")
	private Employee updateEmployee(@RequestBody EmployeeModel emp) {
		if (emp.getId() == null) {
			throw new BadRequestException("Employee id is mandatory for updates. Please attempt with a valid request.");
		}
		return employeeService.update(emp);
	}

}
