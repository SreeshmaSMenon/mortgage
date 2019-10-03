package com.ing.mortgage.controller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.service.LoanService;

@RunWith(MockitoJUnitRunner.class)
public class LoanControllerTest {
	
	@Mock
	LoanService loanService;
	
	@InjectMocks
	LoanController loanController;
	
	@Test
	public void testSelectLoan() {
		 Mockito.when(loanService.applyLoan(Mockito.any(),Mockito.any())).thenReturn("success");
		 ResponseEntity<String> response=loanController.selectLoan(101L, 1L);
         assertEquals("success", response.getBody());
	}

	@Test
	public void testGetApprovedLoans() {
		 List<Mortgage> approvedLoans=new ArrayList<>();
		 Mortgage loan=new Mortgage();
		 loan.setId(101L);
		 loan.setAmount(800000.0);
		 loan.setMonthlyInstallment(10000L);
		 loan.setRateOfInterest(9);
		 loan.setTenure(10);
		 approvedLoans.add(loan);
		 Mockito.when(loanService.getApprovedLoans(Mockito.any(),Mockito.any())).thenReturn(approvedLoans);
		 ResponseEntity<List<Mortgage>> response=loanController.getApprovedLoans(9876549876L, "sree@gmail.com");
         assertNotNull(response.getBody());
	}

}
