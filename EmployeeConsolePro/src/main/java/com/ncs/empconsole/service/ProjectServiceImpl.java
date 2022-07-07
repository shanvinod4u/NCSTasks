package com.ncs.empconsole.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.empconsole.exception.InvalidProjectCostException;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.repository.ProjectRepository;
import com.ncs.empconsole.util.ValidateProject;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ValidateProject validateProject;
	
	@Override
	public Project addProject(Project p) throws InvalidProjectCostException {
		if(p!=null) {
			boolean status = validateProject.ValidateProjectCost(p);
			if(status == true) {
				Project savedProject = projectRepo.save(p);
				return savedProject;
			}
			else {
				throw new InvalidProjectCostException("", p.getCost());
			}
		}
		else {
			throw new NullPointerException("Project info is null");
		}
		
	}

	@Override
	public Project getProjectById(int projectNumber) {
		
		Project returnedProject = projectRepo.getById(projectNumber);
		return returnedProject;
	}

	@Override
	public List<Project> getAllProjects() {
		
		List<Project> allProjects = projectRepo.findAll();
		return allProjects;
	}


	@Override
	public Project updateProjectName(int projectNumber, String projectName) {

		boolean status = projectRepo.updateProjectName(projectNumber, projectName);
		if(status) {
			
			Project p = getProjectById(projectNumber);
			return p;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean deleteProjectById(int projectNumber) {
		
		projectRepo.deleteById(projectNumber);
		return true;
	}

	@Override
	public List<Project> getAllProjectsByCost(int cost) {
		
		List<Project> list = projectRepo.getAllProjectByCost(cost);
		return list;
	}

}
