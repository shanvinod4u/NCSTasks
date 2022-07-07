package com.ncs.empconsole.service;

import java.util.List;

import com.ncs.empconsole.exception.InvalidProjectCostException;
import com.ncs.empconsole.model.Project;

public interface ProjectService {
	
	public Project addProject(Project p) throws InvalidProjectCostException;
	
	public Project getProjectById(int projectNumber);
	
	public List<Project> getAllProjects();
	
	public List<Project> getAllProjectsByCost(int cost);
	
	public Project updateProjectName(int projectNumber, String projectName);
	
	public boolean deleteProjectById(int projectNumber);
	
}
