package net.com.springmvc.service;

import java.util.List;

import net.com.springmvc.entity.Employee;
import net.com.springmvc.exception.ResourceNotFoundException;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId) throws ResourceNotFoundException;

	public void deleteEmployee(int theId) throws ResourceNotFoundException;

}
