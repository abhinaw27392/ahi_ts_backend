package com.ahi.model;

import java.io.Serializable;

import com.ahi.entity.AhiClients;

public class ProjectsModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private Integer headedByUserId;
	private String headedBy;
	private Integer clientId;
	private String clientName;



	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Integer getHeadedByUserId() {
		return headedByUserId;
	}

	public void setHeadedByUserId(Integer headedByUserId) {
		this.headedByUserId = headedByUserId;
	}

	public String getHeadedBy() {
		return headedBy;
	}

	public void setHeadedBy(String headedBy) {
		this.headedBy = headedBy;
	}


}
