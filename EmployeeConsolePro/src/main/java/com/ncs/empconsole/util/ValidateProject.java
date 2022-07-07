package com.ncs.empconsole.util;

import org.springframework.stereotype.Component;

import com.ncs.empconsole.model.Project;

@Component
public class ValidateProject {
	
	public boolean ValidateProjectCost(Project p) {
		
		int projectCost = p.getCost();
		
		if(projectCost < 5000) {
			return false;
		}
		else {
			return true;
		}
		
		
	}
}
