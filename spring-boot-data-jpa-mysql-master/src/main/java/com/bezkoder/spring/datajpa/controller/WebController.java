package com.bezkoder.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bezkoder.spring.datajpa.model.Customer;
import com.bezkoder.spring.datajpa.repository.CustomerRepository;


@Controller
public class WebController {
	
	@Autowired
	CustomerRepository tutorialRepository;
    
    @GetMapping({"/", "/list"})
	public String serveLoginPage(HttpServletRequest request,
			 HttpServletResponse response, Model model) {
    	try {
			List<Customer> customerList = new ArrayList<Customer>();
			tutorialRepository.findAll().forEach(customerList::add);
			
			model.addAttribute("customerList", customerList);
			
		} catch (Exception e) {
			System.out.println("This is error");
		}
		return "listPage";
	}
}