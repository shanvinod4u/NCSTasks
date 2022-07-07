package com.ncs.empconsole.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ncs.empconsole.model.Project;

public class CustomProjectRepositoryImpl implements CustomProjectRepository {
	
	@Autowired
	EntityManager springDataJPA;
	

	@Override
	@Transactional
	public boolean updateProjectName(int projectNumber, String projectName) {
		
		String query = "Update Project set projectName = :projectName where projectNumber = :projectNumber";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("projectName", projectName);
		q.setParameter("projectNumber", projectNumber);
		int x = q.executeUpdate();
				
		return (x==1)?true:false;
	}


	@Override
	public List<Project> getAllProjectByCost(int cost) {
		String query = "from Project p where p.cost = :cost";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("cost", cost);
		
		List<Project> list = q.getResultList();
		return list;
	}

}
