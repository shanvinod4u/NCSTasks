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

import com.ncs.empconsole.exception.InvalidProjectCostException;
import com.ncs.empconsole.model.Employee;
import com.ncs.empconsole.model.Project;
import com.ncs.empconsole.service.ProjectService;

@RestController
@RequestMapping("/empconsole/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	public ProjectController() {
		System.out.println("Project Controller constructor called");
	}
	
	@PostMapping("/addProject")
	public ResponseEntity<Project> addProject(@RequestBody Project p)throws InvalidProjectCostException {
		
		Project savedProject = projectService.addProject(p);
		return new ResponseEntity<Project>(savedProject,HttpStatus.OK);
		
	}
	
	@GetMapping("/project/{projectNumber}") 
	public Project getProjectById(@PathVariable int projectNumber) {
		
		Project returnedProject = projectService.getProjectById(projectNumber);
		return returnedProject;
	}
	
	@GetMapping("/allProjects")
	public List<Project> getAllProjects(){
		
		List<Project> list = projectService.getAllProjects();
		return list;
		
	}
	
	@GetMapping("/project")
	public List<Project> getAllProjectsByCoat(int cost){
		
		List<Project> list = projectService.getAllProjectsByCost(cost);
		return list;
	}
	
	@PutMapping("/project")
	public Project updateProjectName(@RequestParam int projectNumber, @RequestParam String projectName) {
		
		Project returnedProject = projectService.updateProjectName(projectNumber, projectName);
		return returnedProject;
	}
	
	@DeleteMapping("/project/delete/{projectNumber}")
	public List<Project> deleteProject(@PathVariable int projectNumber) {
		
		boolean status = projectService.deleteProjectById(projectNumber);
		
		if (status) {
			return projectService.getAllProjects();
		}else {
			return null;
		}
		
	}

}
