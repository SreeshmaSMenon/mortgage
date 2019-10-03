package com.ing.mortgage.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import com.ing.mortgage.dto.CustomerDto;
import com.ing.mortgage.entity.Customer;
import com.ing.mortgage.entity.Mortgage;
import com.ing.mortgage.repository.CustomerRepository;
import com.ing.mortgage.repository.LoanRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	
   @Mock
	CustomerRepository customerRepository;
	
	@Mock
	LoanRepository mortgageRepository;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test
	public void testInsertCustomer() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName("Sreeshma");
		customerDto.setLastName("Menon");
		customerDto.setGeneder("F");
		customerDto.setPhone(9876543265L);
		customerDto.setEmail("email");
		customerDto.setPropertyName("Sreenilayam");
		customerDto.setPropertyType("House");
		customerDto.setPropertyValue("1000000");
		Customer customer =new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customer.setCustomerId(1L);
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Customer savedCustomer= customerService.insertCustomer(customerDto);
		assertNotNull(savedCustomer);
		assertNotNull(savedCustomer.getCustomerId());
	}
	
	@Test
	public void testGetApplicableLoans() {
		List<Mortgage> mortgageList= new ArrayList<Mortgage>();
		Mortgage mortgage=new Mortgage();
		mortgage.setId(101L);
		mortgage.setMonthlyInstallment(10134L);
		mortgage.setAmount(800000.0);
		mortgage.setRateOfInterest(9);
		mortgage.setTenure(10);
		mortgageList.add(mortgage);
		Mockito.when(mortgageRepository.findByAmountLessThanOrEquals(Mockito.any())).thenReturn(mortgageList);
		List<Mortgage> availableLoans=customerService.getApplicableLoans("800000.0");
		assertNotNull(availableLoans);		
	}

	
	@Test
	public void testSaveCustomer() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setFirstName("Sreeshma");
		customerDto.setLastName("Menon");
		customerDto.setGeneder("F");
		customerDto.setPhone(9876543265L);
		customerDto.setEmail("email");
		customerDto.setPropertyName("Sreenilayam");
		customerDto.setPropertyType("House");
		customerDto.setPropertyValue("1000000");
		Customer customer =new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		customer.setCustomerId(1L);
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		List<Mortgage> mortgageList= new ArrayList<Mortgage>();
		Mortgage mortgage=new Mortgage();
		mortgage.setId(101L);
		mortgage.setMonthlyInstallment(10134L);
		mortgage.setAmount(800000.0);
		mortgage.setRateOfInterest(9);
		mortgage.setTenure(10);
		mortgageList.add(mortgage);
		Mockito.when(mortgageRepository.findByAmountLessThanOrEquals(Mockito.any())).thenReturn(mortgageList);
		List<Mortgage> availableLoans=customerService.saveCustomer(customerDto);
		assertNotNull(availableLoans);		
	}
}
 