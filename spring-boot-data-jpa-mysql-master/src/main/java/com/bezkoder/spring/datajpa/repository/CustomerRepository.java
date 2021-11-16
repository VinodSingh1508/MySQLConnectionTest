package com.bezkoder.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.datajpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
