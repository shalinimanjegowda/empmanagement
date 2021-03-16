package net.com.springmvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.com.springmvc.entity.Employee;
import net.com.springmvc.entity.Login;
import net.com.springmvc.exception.ResourceNotFoundException;
import net.com.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String launch(Model theModel) {
		return "index";
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.getEmployees();
		theModel.addAttribute("employees", theEmployees);
		return "list-employees";
	}

	@PostMapping("/login")
	public String login(Login login, Model model) {
		Employee theEmployee = new Employee();
		model.addAttribute("employee", theEmployee);
		if (login.getUsername().equalsIgnoreCase("admin") && login.getPassword().equalsIgnoreCase("admin")) {
			return "admin-employee-form";
		} else if (login.getUsername().equalsIgnoreCase("user") && login.getPassword().equalsIgnoreCase("user")) {
			return "user-employee-form";
		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show employee-form handler method");
		Employee theEmployee = new Employee();
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return "redirect:/list";
	}

	@PostMapping("/saveUserEmployee")
	public String saveUserEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.saveEmployee(theEmployee);
		return "redirect:/details";
	}

	@GetMapping("/details")
	public String getEmployeeDetails(Model theModel) {
		List<Employee> theEmployees = employeeService.getEmployees();
		theModel.addAttribute("employees", theEmployees);
		return "employeeDetails";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel)
			throws ResourceNotFoundException {
		Employee theEmployee = employeeService.getEmployee(theId);
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) throws ResourceNotFoundException {
		employeeService.deleteEmployee(theId);
		return "redirect:/list";
	}
}
