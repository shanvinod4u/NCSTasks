package com.ncs.empconsole.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.empconsole.model.Employee;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository{

	@Autowired
	EntityManager springDataJPA;
		
	
	@Override
	public Employee getEmployeeDetails(String searchedEmpName) {
		
			
		String query = "from Employee e where e.name = :searchName";
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("searchName", searchedEmpName);
		
		Employee queryOutput = (Employee) q.getSingleResult();
		return queryOutput;
	}

	@Override
	public List<Employee> getAllEmployeesBySalary(int salaryRange1, int salaryRange2) {
		String query = "from Employee e where e.salary between :salaryRange1 and :salaryRange2";
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("salaryRange1", salaryRange1);
		q.setParameter("salaryRange2", salaryRange2);
		
		List<Employee> list = q.getResultList();
		return list;
	}
	

}
