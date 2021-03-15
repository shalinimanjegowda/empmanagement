package net.com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.com.springmvc.entity.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
