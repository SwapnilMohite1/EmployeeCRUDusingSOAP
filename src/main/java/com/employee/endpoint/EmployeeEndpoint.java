package com.employee.endpoint;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@WebService(serviceName = "EmployeeService")
public class EmployeeEndpoint {
	private final EmployeeService employeeService;
	
	public EmployeeEndpoint(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@WebMethod
	@WebResult(name = "employee")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@WebMethod
	@WebResult(name = "employee")
	public Employee getEmployeeById(@WebParam(name = "id") int id) {
		return employeeService.getEmployeeById(id);
	}

	@WebMethod
	@WebResult(name = "employee")
	public Employee addEmployee(@WebParam(name = "employee") Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@WebMethod
	@WebResult(name = "employee")
	public Employee updateEmployee(@WebParam(name = "employee") Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@WebMethod
	public void deleteEmployee(@WebParam(name = "id") int id) {
		employeeService.deleteEmployee(id);
	}
}