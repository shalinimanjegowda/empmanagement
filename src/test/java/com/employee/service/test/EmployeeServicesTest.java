package com.employee.service.test;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import net.com.springmvc.entity.Employee;
import net.com.springmvc.exception.ResourceNotFoundException;
import net.com.springmvc.service.EmployeeService;

public class EmployeeServicesTest {

	@Mock
	EmployeeService empService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getEmployeesTest() {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("devon");
		emp.setLastName("software");
		emp.setEmail("a@gmail.com");
		list.add(emp);
		when(empService.getEmployees()).thenReturn(list);
		List<Employee> empList = empService.getEmployees();
		assertEquals(1, empList.size());
	}

	@Test
	public void getEmployeeTest() throws ResourceNotFoundException {
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("devon");
		emp.setLastName("software");
		emp.setEmail("a@gmail.com");
		list.add(emp);
		when(empService.getEmployee(emp.getId())).thenReturn(new Employee());
		Employee employee = empService.getEmployee(1);
		assertEquals("devon", emp.getFirstName());
		assertEquals("software", emp.getLastName());
		assertEquals("a@gmail.com", emp.getEmail());
	}

}
