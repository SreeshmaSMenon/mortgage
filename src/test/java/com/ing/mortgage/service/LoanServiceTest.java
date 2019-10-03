package com.ing.mortgage.service;

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
import com.ing.mortgage.entity.LoanApproval;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.repository.LoanApprovalRepository;
import com.ing.mortgage.repository.LoanRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {
	
	 @Mock
	 LoanApprovalRepository loanApprovalRepository;
	 
	 @Mock
	 LoanRepository loanRepository;
	 
	 @InjectMocks
	 LoanService loanService;
	 
	 @Test
	 public void testApplyLoanSuccess() {
		 Long loanId = 101L;
		 Long customerId = 1L;
		 LoanApproval loanApproval=new LoanApproval();
		 loanApproval.setLoanId(loanId);
		 loanApproval.setCustomerId(customerId);
		 loanApproval.setId(1L);
		 Mockito.when(loanApprovalRepository.save(Mockito.any())).thenReturn(loanApproval);
		 String result= loanService.applyLoan(1L, 101L);
		 assertNotNull(result);
         assertEquals("Your loan has approved successfully!", result);
	 }
	 
	 @Test
	 public void testApplyLoanFailure() {
		 String result= loanService.applyLoan(1L, null);
         assertEquals("failure", result);
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
		 Mockito.when(loanRepository.findAllByEmailAndPhoneNo(Mockito.any(),Mockito.any())).thenReturn(approvedLoans);
         List<Mortgage> loanList= loanService.getApprovedLoans(9876549876L, "sree@gmail.com");
         assertNotNull(loanList);
         assertEquals(approvedLoans, loanList);

	 }
	 
	 @Test
	 public void testGetApprovedLoansEmptyCheck() {
		 List<Mortgage> approvedLoans=new ArrayList<>();
		 Mockito.when(loanRepository.findAllByEmailAndPhoneNo(Mockito.any(),Mockito.any())).thenReturn(approvedLoans);
         List<Mortgage> loanList= loanService.getApprovedLoans(9876549876L, "sree@gmail.com");
         assertNotNull(loanList);
         assertEquals(0, loanList.size());
	 }
}
