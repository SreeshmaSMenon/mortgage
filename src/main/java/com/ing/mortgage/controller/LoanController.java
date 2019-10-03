package com.ing.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.service.LoanService;

@RestController
@RequestMapping("/Loan")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@PostMapping("/selectLoan/{loanid}/{customerid}")
	public ResponseEntity<String>selectLoan(@PathVariable("loanid") Long loanId,@PathVariable("customerid") Long customerId ){
		String status=loanService.applyLoan(customerId, loanId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<Mortgage>>getApprovedLoans(@RequestParam("phone") Long phone,@RequestParam("email") String email ) {
		List<Mortgage> mortgageList=loanService.getApprovedLoans(phone, email);
		return new ResponseEntity<>(mortgageList,HttpStatus.OK);
	}
}
