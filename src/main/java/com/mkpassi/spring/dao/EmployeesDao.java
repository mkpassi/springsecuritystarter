package com.mkpassi.spring.dao;

import com.mkpassi.spring.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesDao extends CrudRepository<Employee, Integer> {
}
