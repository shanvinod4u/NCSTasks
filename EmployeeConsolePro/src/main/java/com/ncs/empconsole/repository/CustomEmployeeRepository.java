package com.ncs.empconsole.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.ncs.empconsole.model.Employee;

public interface CustomEmployeeRepository {

	public Employee getEmployeeDetails(String searchedEmpName);
		
	public List<Employee> getAllEmployeesBySalary(int salaryRange1, int salaryRange2);
	
}
