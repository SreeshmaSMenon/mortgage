package com.ing.mortgage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.mortgage.dto.CustomerDto;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/apply")
	public ResponseEntity<List<Mortgage>> apply(@Valid @RequestBody CustomerDto customerDto) {
		List<Mortgage> mortgageList=customerService.saveCustomer(customerDto);
		return new ResponseEntity<>(mortgageList,HttpStatus.CREATED);
	}
}
