package com.socgen.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socgen.entity.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

}
