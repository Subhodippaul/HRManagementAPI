package com.nagarro.hrmanager.service;

import java.util.List;
import java.util.Optional;

import com.nagarro.hrmanager.dao.EmployeeRepository;
import com.nagarro.hrmanager.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * This is a class of EmployeeServiceImplementation
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	/**
	 * create the object of the EmployeeRepository
	 */
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * method of allEmployee
	 */
	@Override
	public List<Employee> allEmployee() {
		return this.employeeRepository.findAll();
	}
	
	/**
	 * methdo of the save employee
	 */
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	/**
	 * method of the delete employee
	 */
	@Override
	public void deleteEmployee(Employee employee) {
		this.employeeRepository.delete(employee);
	}
	
	/**
	 * method to get the ID of the particular employee
	 */
	@Override
	public Employee getEmployeeById(long id) {
		/**
		 * id store to employee variable 
		 */
		Optional<Employee> employee = this.employeeRepository.findById(id);

		/**
		 * set emp variable to null
		 */
		Employee emp = null;

		/**
		 * check the employee is present or not
		 */
		if(employee.isPresent()) {
			emp = employee.get();
		}	
		return emp;
	}
	
	/**
	 *  method to get the ID of the particular employee for delete
	 */
	@Override
	public Employee deleteEmployeeById(long id) {

		/**
		 * id store to employee variable 
		 */
		Optional<Employee> employeeDelete = this.employeeRepository.findById(id);

		/**
		 * set employee variable to null
		 */
		Employee employee = null;

		/**
		 * check the employee is present or not
		 */
		if(employeeDelete.isPresent()) {
			employee = employeeDelete.get();

			/**
			 * delete the particular employee
			 */
			employeeRepository.delete(employee);
		}
		return employee;
	}
	
	/**
	 * method of the list employee
	 */
	@Override
	public List<Employee> listEmployee() {

		/**
		 * set all employee to the ascending order by employee code 
		 */
        return employeeRepository.findAll(Sort.by("employeeCode").ascending());
    }
	
	
	
}
