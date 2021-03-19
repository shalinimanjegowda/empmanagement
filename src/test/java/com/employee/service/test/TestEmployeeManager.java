package com.employee.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.com.springmvc.MainApp;
import net.com.springmvc.entity.Employee;
import net.com.springmvc.exception.ResourceNotFoundException;
import net.com.springmvc.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApp.class)
public class TestEmployeeManager {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void testCreateEmployee() {
		Employee emp = new Employee();
		emp.setFirstName("Lokesh");
		emp.setLastName("Gupta");
		emp.setEmail("user@email.com");
		Employee emp1 = employeeRepository.save(emp);
		assertNotNull(emp1);
	}

	@Test
	public void testGetEmployeeById() throws ResourceNotFoundException {
		Employee empOne = new Employee();
		empOne.setFirstName("John");
		empOne.setLastName("Gupta");
		empOne.setEmail("user@email.com");
		Employee emp = employeeRepository.save(empOne);
		assertEquals("John", emp.getFirstName());
		assertEquals("Gupta", emp.getLastName());
		assertEquals("user@email.com", emp.getEmail());
	}

	@Test
	public void testDeleteEmployeeByID() {
		Employee emp = new Employee();
		emp.setFirstName("Lokesh");
		emp.setLastName("Gupta");
		emp.setEmail("user@email.com");
		Employee emp1 = employeeRepository.save(emp);
		assertNotNull(emp1);
		employeeRepository.deleteById(1);
		assertFalse(employeeRepository.existsById(1));
	}

	@Test
	public void testGetAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		Employee empOne = new Employee();
		empOne.setFirstName("Lokesh");
		empOne.setLastName("Gupta");
		empOne.setEmail("user@email.com");
		Employee empTwo = new Employee();
		empTwo.setFirstName("Alex");
		empTwo.setLastName("kolenchiski");
		empTwo.setEmail("alexk@email.com");
		Employee empThree = new Employee();
		empThree.setFirstName("Steve");
		empThree.setLastName("Waugh");
		empThree.setEmail("swaugh@email.com");
		empList.add(empOne);
		empList.add(empTwo);
		empList.add(empThree);
		List<Employee> empListfromDB = employeeRepository.saveAll(empList);
		assertEquals(3, empListfromDB.size());
	}

}