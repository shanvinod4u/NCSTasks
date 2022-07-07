package com.ncs.empconsole.exception;

public class InvalidProjectCostException extends Exception{
	
	private String errorMsg;
	private int projectCost;
	
	public InvalidProjectCostException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidProjectCostException(String errorMsg, int projectCost) {
		super();
		this.errorMsg = errorMsg;
		this.projectCost = projectCost;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(int projectCost) {
		this.projectCost = projectCost;
	}

	@Override
	public String toString() {
		return "Project cost cannot be less than 5000";
	}
	
	
	
}
