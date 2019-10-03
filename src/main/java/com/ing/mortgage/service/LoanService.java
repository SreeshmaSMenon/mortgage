package com.ing.mortgage.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ing.mortgage.entity.LoanApproval;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanApprovalRepository;
import com.ing.mortgage.repository.LoanRepository;

@Service
public class LoanService {

	 @Autowired
	 LoanApprovalRepository loanApprovalRepository;
	 
	 @Autowired
	 CustomerRepository customerRepository;
	 
	 @Autowired
	 LoanRepository loanRepository;
	 
	 public String applyLoan(Long customerId,Long loanId) {
		 String status="failure";
		 if(customerId!= null && loanId!=null ) {
			 LoanApproval loanApproval=new LoanApproval();
			 loanApproval.setLoanId(loanId);
			 loanApproval.setCustomerId(customerId);
			 LoanApproval approvedLoan=loanApprovalRepository.save(loanApproval);
			 if(approvedLoan.getId()!=null)
				 status="Your loan has approved successfully!";
		 }
		 return status;
	 }
	
	 
	 public List<Mortgage> getApprovedLoans(Long phone,String email){
		 return loanRepository.findAllByEmailAndPhoneNo(email,phone); 
	 }

}
