package com.nagarro.hrmanager.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.hrmanager.entity.Employee;
import com.nagarro.hrmanager.service.EmployeeService;

/**
 * This method is used to controll the employee
 */
@RestController
public class EmployeeController {

	/**
	 * create the object of the EmployeeService
	 */
	@Autowired
	public EmployeeService employeeService;


	/**
	 * method to show the all employee list
	 */
	@GetMapping("/employeeList")
	public ResponseEntity<List<Employee>> Employee() {
		List<Employee> employee = this.employeeService.allEmployee();
		return ResponseEntity.of(Optional.of(employee));
	}

	/**
	 * method for upload the new employee
	 */
	@GetMapping("/showFormNewEmployee")
	public String employeeForm() {
		return "AddNewEmployee";
	}

	/**
	 * method of update employee
	 */
	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployeeForm(@PathVariable("id") long id,Model model) {
		/**
		 * get the employee by Id and store the variable employee
		 */
		Employee employee = this.employeeService.getEmployeeById(id);
		model.addAttribute("employeeData", employee);
		/**
		 * return the UpdateEmployeeDetails form page 
		 */
		return "UpdateEmployeeDetails";
	}

	/**
	 * method to save the employee
	 */
	@PostMapping("/saveEmployee")
	public void saveEmployee(@RequestBody Employee employeeData) {
		/**
		 * print the saving to the Console
		 */
		System.out.println("saveing");
		/**
		 * calling the saveEmployee method from the employeeService
		 */
		this.employeeService.saveEmployee(employeeData);
	}

	/**
	 * method to delete the perticular employee 
	 */
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") long id,Model model) {
		/**
		 * print the message to the consol
		 */
		System.out.println("deleting");
		/**
		 * call the method deleteEmployeeById from employeeService
		 */
		this.employeeService.deleteEmployeeById(id);
	}



}
