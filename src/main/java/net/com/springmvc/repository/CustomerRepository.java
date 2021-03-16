package net.com.springmvc.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import net.com.springmvc.entity.Customer;


public interface CustomerRepository extends ElasticsearchRepository<Customer, String>{

	List<Customer> findByFirstName(String firstName);
}

