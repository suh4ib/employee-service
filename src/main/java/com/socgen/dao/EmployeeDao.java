package com.socgen.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socgen.entity.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

}
