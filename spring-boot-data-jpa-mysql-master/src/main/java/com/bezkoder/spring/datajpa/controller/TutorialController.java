package com.bezkoder.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping("/tutorials")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		try {
			List<Customer> customerList = new ArrayList<Customer>();

				customerRepository.findAll().forEach(customerList::add);
			if (customerList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(customerList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
