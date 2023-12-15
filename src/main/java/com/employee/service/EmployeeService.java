package com.employee.service;


import com.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	void deleteEmployee(int id);
}