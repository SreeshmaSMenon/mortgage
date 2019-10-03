package com.ing.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.mortgage.entity.Mortgage;

@Repository
public interface LoanRepository extends JpaRepository<Mortgage, Long> {

	@Modifying
	@Query("SELECT m FROM Mortgage m WHERE m.amount <= :maximumEligibleAmount")
	public List<Mortgage> findByAmountLessThanOrEquals(@Param("maximumEligibleAmount") Double maximumEligibleAmount);
	
	@Query(value = "SELECT distinct m.id,m.amount,m.monthly_installment,m.rate_of_interest,m.tenure FROM ing_mortgage.customer c JOIN ing_mortgage.loan_approval l ON c.customer_id=l.customer_id AND c.email=:email AND c.phone=:phone JOIN ing_mortgage.mortgage m ON l.loan_id=m.id;", nativeQuery = true)
	public List<Mortgage> findAllByEmailAndPhoneNo(@Param("email") String email, @Param("phone") Long phone);
}
