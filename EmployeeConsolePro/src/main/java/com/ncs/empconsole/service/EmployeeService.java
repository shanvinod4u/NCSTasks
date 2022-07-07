package com.ncs.empconsole.service;

import java.util.List;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee e) throws OutofRangeSalaryException;
	public Employee getEmployeeDetails(int searchedEmpId);
	public Employee getEmployeeDetails(String searchedEmpName);
	public Employee updateProjectInfo(int id, int projectId);
	public boolean deleteEmployeeById(int id);
	
	public List<Employee> getAllEmployees();
	public List<Employee> getAllEmployees(int salaryRange1,int salaryRange2);
	
	
	
}
