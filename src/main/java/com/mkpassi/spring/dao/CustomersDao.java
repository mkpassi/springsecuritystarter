package com.mkpassi.spring.dao;

import com.mkpassi.spring.ds.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
