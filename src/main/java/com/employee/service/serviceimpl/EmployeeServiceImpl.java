package com.employee.service.serviceimpl;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
			return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee updateEmployee(Employee updatedEmployee) {
		Employee existingEmployee = employeeRepository.findById(updatedEmployee.getId()).orElse(null);
		
		if (existingEmployee != null) {
			if(updatedEmployee.getEno() != 0)
				existingEmployee.setEno(updatedEmployee.getEno());
			if(updatedEmployee.getEname() != null)
				existingEmployee.setEname(updatedEmployee.getEname());
			if(updatedEmployee.getSalary() != 0)
				existingEmployee.setSalary(updatedEmployee.getSalary());
			if(updatedEmployee.getDob() != null)
				existingEmployee.setDob(updatedEmployee.getDob());
			if(updatedEmployee.getDoj() != null)
				existingEmployee.setDoj(updatedEmployee.getDoj());
			if(updatedEmployee.getManager() != null)
				existingEmployee.setManager(updatedEmployee.getManager());
			if(updatedEmployee.getDept() != null)
				existingEmployee.setDept(updatedEmployee.getDept());
			
			return employeeRepository.save(existingEmployee);
		} else {
			return null;
		}
	}
	
	
	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}