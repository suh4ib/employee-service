package com.socgen.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.dao.DepartmentDao;
import com.socgen.entity.Department;
import com.socgen.exception.BadRequestException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao dao;

	public Department getDepartmentFromCode(String departmentCode) {
		Iterator<Department> iterator = dao.findAll().iterator();
		while (iterator.hasNext()) {
			Department next = iterator.next();
			if (next.getDepartmentCode().equals(departmentCode)) {
				return next;
			}
		}
		throw new BadRequestException("Department not found.");
	}

}
