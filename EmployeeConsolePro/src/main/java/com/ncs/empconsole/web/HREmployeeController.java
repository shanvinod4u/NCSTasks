package com.ncs.empconsole.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.service.EmployeeService;

@RestController
@RequestMapping("/empconsole/hr")
public class HREmployeeController{
	
	@Autowired
	EmployeeService empService;
	
	public HREmployeeController() {
		System.out.println("HR Employee Controller constructor called");
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}

	@GetMapping("/employee/id/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		System.out.println("path varible : "+id);
		return empService.getEmployeeDetails(id);
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public List<Employee> deleteById(@PathVariable int id)
	{
		 boolean status = empService.deleteEmployeeById(id);
		if (status) {
		 return empService.getAllEmployees();
		}
		return null;
	}
	
	@GetMapping("/employee") // ..../employee/hr/employee?name=ramesh
	public Employee getEmployeeByName(@RequestParam String name)
	{
		System.out.println("path varible : "+name);
		Employee e =  empService.getEmployeeDetails(name);
		System.out.println(e);
		return e;
	}
	
	
	@GetMapping("/employee/salary")
	public List<Employee> getEmployeeBySalaryRange(@RequestParam int salaryRange1,@RequestParam int salaryRange2 )
	{
		return empService.getAllEmployees(salaryRange1, salaryRange2);
	}
	
	
	@PutMapping("/employee")
	public Employee updateProjectInfo(@RequestParam int empId, @RequestParam int projectId)
	{
		return empService.updateProjectInfo(empId, projectId);
		
	}
	

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e)throws OutofRangeSalaryException
	{
		
		Employee savedEmployee = empService.addEmployee(e);
		
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		
	}
}//end class
