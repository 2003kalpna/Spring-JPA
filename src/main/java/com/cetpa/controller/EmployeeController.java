package com.cetpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entity.Employee;
import com.cetpa.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@RequestMapping("insert-employee")
	public String getInsertView()
	{
		return "add";
	}
	@RequestMapping("save-record")
	public String saveEmployeeRecord(Employee employee)
	{
		employeeService.saveRecord(employee);
		return "save";
	}
	@RequestMapping("employee-list")
	public String getEmployeeList(Model model)
	{
		List<Employee> employeeList=employeeService.getList();
		model.addAttribute("elist",employeeList);
		return "list";
	}
	@RequestMapping("search-employee")
	public String getSearchView()
	{
		return "search";
	}
	@RequestMapping("search-record")
	public String searchEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record not found");
			model.addAttribute("eid",eid);
			return "search";
		}
		model.addAttribute("emp", employee);
		return "show-record";
	}
	@RequestMapping("delete-employee")
	public String getDeleteView()
	{
		return "delete";
	}
	@RequestMapping("confirm-delete")
	public String confirmDeleteEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record does not exist");
			model.addAttribute("eid",eid);
			return "delete";
		}
		model.addAttribute("emp", employee);
		return "confirm";
	}
	@RequestMapping("delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		employeeService.deleteRecord(eid); 
		return "delete-success";
	}
	@RequestMapping("edit-employee")
	public String getEditView()
	{
		return "edit";
	}
	@RequestMapping("show-record")
	public String showDeleteEmployeeRecord(int eid,Model model)
	{
		Employee employee=employeeService.getRecord(eid);
		if(employee==null)
		{
			model.addAttribute("msg","Record does not exist");
			model.addAttribute("eid",eid);
			return "edit";
		}
		model.addAttribute("emp", employee);
		return "update-show";
	}
	@RequestMapping("update-record")
	public String updateEmployeeRecord(Employee employee)
	{
		employeeService.updateRecord(employee);
		return "update-success";
	}
}
