package com.mkpassi.spring.dao;

import com.mkpassi.spring.ds.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
