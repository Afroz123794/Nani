package com.durgasoft.springbootrestfulwebservices43rdVideo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.durgasoft.springbootrestfulwebservices43rdVideo.employee.Employee;
import com.durgasoft.springbootrestfulwebservices43rdVideo.employee.EmployeeDAO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public List<Employee>   findAllEmployees(){
		System.out.println("findAllEmployees method in EmployeeService");
		return employeeDAO.findAll();
		}

	public Employee saveEmployee(Employee employee) {
		System.out.println("saveEmployee method in EmployeeService");
		return employeeDAO.save(employee);
		
	}
	
	
	public Employee getOneEmployee(int id) {
		System.out.println("getOneEmployee method in EmployeeService:"+id);
		return employeeDAO.getOne(id);
		
	}
	
	public Employee deleteOneEmployee(int id) {
		System.out.println("deleteOneEmployee method in EmployeeService:"+id);
		return employeeDAO.deleteEmployee(id);
		
	}
	
	public void UpdateOneEmployee(Employee emp) {
		employeeDAO.updateEmployee(emp);
	}
	
}
