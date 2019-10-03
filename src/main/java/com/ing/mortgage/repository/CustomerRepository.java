package com.ing.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ing.mortgage.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
