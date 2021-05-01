package com.durgasoft.springbootrestfulwebservices43rdVideo.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	
	//connect the db and perform CURD operations
	
	private static int count = 4;
	
	private static List<Employee> employeeList = new ArrayList<>();
	
	static {
		employeeList.add(new Employee(1, "Afroz", "afroz.1092@gmail.com", "8790718502", new Date()));
		employeeList.add(new Employee(2, "Reshma", "reshma.1092@gmail.com", "7418529631", new Date()));
		employeeList.add(new Employee(3, "Althaf", "althaf.1092@gmail.com", "8527419633", new Date()));
		employeeList.add(new Employee(4, "Adam", "adam.1092@gmail.com", "7458529631", new Date()));
		
	}
	
	/**
	 * get all Employee details
	 * @return List of Employees
	 */
	
	public List<Employee> findAll(){
		System.out.println("findAll method in EmployeeDAO");
		return employeeList;
		
	}
	/**
	 * Persist the Employee Object into db or inmemory database
	 * @param employee
	 * @return
	 */
	
	public Employee save(Employee employee) {
		System.out.println("save method in EmployeeDAO");
		if(employee.getId() == null) {
			employee.setId(++count);
		}
		employeeList.add(employee);
		return employee;
		
	}
	
	/**
	 * find employee based on id
	 * @param id
	 * @return {@link Employee}
	 */
	
	public Employee getOne(int id) {
		System.out.println("getOne method in EmployeeDAO:"+ id);
		for (Employee employee : employeeList) 
		{
			if(employee.getId() == id) {
				return employee;
			}
		}
		return null;
		
	}
	
	public Employee deleteEmployee(int id) {
		System.out.println("deleteEmployee method in EmployeeDAO:"+ id);
		Iterator<Employee> iterator = employeeList.iterator();
		while(iterator.hasNext()) {
			Employee employee = iterator.next();
			if(employee.getId() == id) {
				iterator.remove();
				return employee;
			}
		}
		return null;
		
	}
	
	
	public void updateEmployee(Employee emp) {
		System.out.println("UpdateEmployee method in EmployeeDAO:"+ emp.getId());
		Iterator<Employee> iterator = employeeList.iterator();
		while(iterator.hasNext()) {
			Employee employee = iterator.next();
			if(employee.getId() == emp.getId()) {
				employee.setName(emp.getName());
				employee.setEmail(emp.getEmail());
				employee.setDateOfBirth(emp.getDateOfBirth());
				employee.setContactNo(emp.getContactNo());
			}
		}
	}
	

}
