package com.ncs.empconsole.repository;

import java.util.List;

import com.ncs.empconsole.model.Project;

public interface CustomProjectRepository {
	
	public List<Project> getAllProjectByCost(int cost);
	
	public boolean updateProjectName(int projectNumber, String projectName);

}
