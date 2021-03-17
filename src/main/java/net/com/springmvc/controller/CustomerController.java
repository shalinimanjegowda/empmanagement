package net.com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.com.springmvc.entity.Customer;
import net.com.springmvc.repository.CustomerRepository;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/saveCustomer")
	public int saveCustomer(@RequestBody List<Customer>customers)
	{
		repository.saveAll(customers);
		return customers.size();
	}
	
	@GetMapping("/findByFirstName/{firstName}")
	public List<Customer>findByFirstName(@PathVariable String firstName)
	{
		return repository.findByFirstName(firstName);
	}
	
	@GetMapping("/findAll")
	public Iterable<Customer>findAllCustomer()
	{
		return repository.findAll();
	}

}
