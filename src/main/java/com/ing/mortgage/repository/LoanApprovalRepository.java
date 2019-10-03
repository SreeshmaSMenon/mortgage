package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ing.mortgage.entity.LoanApproval;

@Repository
public interface LoanApprovalRepository extends JpaRepository<LoanApproval, Long>{
	
}
