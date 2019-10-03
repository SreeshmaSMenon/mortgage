package com.ing.mortgage.service;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ing.mortgage.dto.CustomerDto;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanRepository;

@Service
public class CustomerService {

	 @Autowired
	 CustomerRepository customerRepository;
	 
	 @Autowired
	 LoanRepository loanRepository;
	 
	 public List<Mortgage> saveCustomer(CustomerDto customerdto) {
		 Customer customer=insertCustomer(customerdto);
		 if(customer!=null) {
			 return getApplicableLoans(customerdto.getPropertyValue());
		 }else {
			 return Collections.emptyList();
		 }
	 }
	 
	 public Customer insertCustomer(CustomerDto customerdto) {
		 Customer customerEntity = new Customer();
		 BeanUtils.copyProperties(customerdto, customerEntity);
		 return customerRepository.save(customerEntity);
	 }
	 
	 public List<Mortgage> getApplicableLoans(String propertyValue){
		 Double maximumEligibleAmount=Double.parseDouble(propertyValue) * 0.8;
		 return loanRepository.findByAmountLessThanOrEquals(maximumEligibleAmount);
	 }
	 
}
