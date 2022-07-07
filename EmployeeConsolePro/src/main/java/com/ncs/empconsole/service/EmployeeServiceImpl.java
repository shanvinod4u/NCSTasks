package com.ncs.empconsole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.exception.OutofRangeSalaryException;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.repository.CustomEmployeeRepository;
import com.ncs.empconsole.repository.EmployeeRepository;
import com.ncs.empconsole.util.ValidateEmployee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ValidateEmployee validateEmployee;
	
	@Autowired
	ProjectService projectService;
	
	@Override
	public Employee addEmployee(Employee e) throws OutofRangeSalaryException{
		if(e!=null)
		{
			boolean status = validateEmployee.validateEmployeeSalary(e);
			if(status == true)
			{
				Employee savedEntity =  employeeRepository.save(e);
				return savedEntity;
			}
			else
			{
				throw new OutofRangeSalaryException("",e.getSalary(),e.getDesignation());
			}
		}
		else
		{
			throw new NullPointerException("Employee Info Is Null");
		}
		
	}

	@Override
	public Employee getEmployeeDetails(int searchedEmpId) {
		
		Employee returnedEmployee =  employeeRepository.getById(searchedEmpId);
		
		 return (returnedEmployee!=null)? returnedEmployee : null;
	}
	
	@Override
	public boolean deleteEmployeeById(int id) {
		
		employeeRepository.deleteById(id);
		return true;
	}

	@Override
	public Employee getEmployeeDetails(String searchedEmpName) {
		
		return employeeRepository.getEmployeeDetails(searchedEmpName);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getAllEmployees(int salaryRange1, int salaryRange2) {
		
		return  employeeRepository.getAllEmployeesBySalary(salaryRange1, salaryRange2);
	}

	@Override
	public Employee updateProjectInfo(int id, int projectId) {
		
		Employee e = getEmployeeDetails(id);
		Project p = projectService.getProjectById(projectId);
		e.setProjectInfo(p);
		
		employeeRepository.save(e);
		
		return e;
		
	}

	
}
	

