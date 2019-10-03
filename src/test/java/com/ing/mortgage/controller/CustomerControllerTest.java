package com.ing.mortgage.controller;

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
import com.ing.mortgage.dto.CustomerDto;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;
	
	@InjectMocks
	CustomerController customerController;
	
	@Test
	public void testApply() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName("Sreeshma");
		customerDto.setLastName("Menon");
		customerDto.setGeneder("F");
		customerDto.setPhone(9876543265L);
		customerDto.setEmail("email");
		customerDto.setPropertyName("Sreenilayam");
		customerDto.setPropertyType("House");
		customerDto.setPropertyValue("1000000");
		List<Mortgage> approvedLoans=new ArrayList<>();
		Mortgage loan=new Mortgage();
		loan.setId(101L);
		loan.setAmount(800000.0);
		loan.setMonthlyInstallment(10000L);
		loan.setRateOfInterest(9);
		loan.setTenure(10);
		approvedLoans.add(loan);
		Mockito.when(customerService.saveCustomer(Mockito.any())).thenReturn(approvedLoans);
		ResponseEntity<List<Mortgage>> response = customerController.apply(customerDto);
		assertNotNull(response.getBody());
	}
}
