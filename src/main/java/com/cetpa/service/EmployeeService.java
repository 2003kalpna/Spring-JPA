package com.cetpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entity.Employee;
import com.cetpa.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public void saveRecord(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	public List<Employee> getList()
	{
		return employeeRepository.findAll();
	}
	public Employee getRecord(int eid) 
	{
		return employeeRepository.findById(eid).orElse(null);
	}

	  public void deleteRecord(int eid) {
	        employeeRepository.deleteById(eid);  
	    }
	public void updateRecord(Employee employee) 
	{
		employeeRepository.save(employee);
	}
}
