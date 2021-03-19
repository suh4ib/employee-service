package com.socgen.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.dao.EmployeeDao;
import com.socgen.entity.Employee;
import com.socgen.exception.NotFoundException;
import com.socgen.model.EmployeeModel;
import com.socgen.rde.EmployeeDesignation;
import com.socgen.rde.EmployeeRole;
import com.socgen.rde.EmploymentType;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentService service;

	public Map<String, Map<String, List<Employee>>> getAllActiveEmployees() {
		List<Employee> activeEmployeeList = new ArrayList<>();
		employeeDao.findAll().forEach(emp -> {
			if (emp.getIsActive()) {
				activeEmployeeList.add(emp);
			}
		});
		return generateEmployeesMap(activeEmployeeList);
	}

	private Map<String, Map<String, List<Employee>>> generateEmployeesMap(List<Employee> activeEmployeeList) {

		Map<String, Map<String, List<Employee>>> map = new HashMap<>(activeEmployeeList.size());

		activeEmployeeList.stream().forEach(emp -> {

			String role = emp.getEmployeeRole().name();
			String type = emp.getEmployeeType().name();

			if (map.get(role) == null) {

				// role itself is not there.
				Map<String, List<Employee>> typeMap = new HashMap<>(4);
				List<Employee> list = new ArrayList<>(5);
				list.add(emp);
				typeMap.put(type, list);
				map.put(role, typeMap);

			} else {
				// role map exists;
				if (map.get(role).get(type) == null) {

					// type is not there.
					List<Employee> list = new ArrayList<>(5);
					list.add(emp);
					map.get(role).put(type, list);

				} else {

					// type is also there.
					map.get(role).get(type).add(emp);

				}
			}
		});

		return map;
	}

	public Employee getEmployeeById(Integer employeeId) {
		Optional<Employee> emp = employeeDao.findById(employeeId);
		return emp.isPresent() ? emp.get() : null;
	}

	public void inactivateEmployeeById(Integer employeeId) {
		Employee emp = getEmployeeById(employeeId);
		if (emp == null) {
			throw new NotFoundException("No such employee found.");
		} else {
			emp.setIsActive(false);
			employeeDao.save(emp);
		}
	}

	public Employee insert(EmployeeModel emp) {
		return employeeDao.save(transform(emp));
	}

	public Employee update(EmployeeModel emp) {
		// inactivateEmployeeById(emp.getId());
		return employeeDao.save(transform(emp));
	}

	private Employee transform(EmployeeModel emp) {

		Employee obj = new Employee(emp.getName(), EmploymentType.getEmploymentType(emp.getType()),
				EmployeeDesignation.getEmployeeDesignation(emp.getDesingation()),
				EmployeeRole.getEmployeeRole(emp.getRole()), emp.getSalary(), true, emp.getImage(), emp.getGender(),
				emp.getPhone(), emp.getAddress(), emp.getEmail());
		if (emp.getId() != null) {
			obj.setEmployeeId(emp.getId());
		}
		obj.setDepartment(service.getDepartmentFromCode(emp.getDepartment().getDepartmentCode()));
		return obj;
	}

}
