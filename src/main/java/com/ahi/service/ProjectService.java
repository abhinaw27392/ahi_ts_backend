package com.ahi.service;

import java.security.Principal;
import java.util.List;

import com.ahi.AHCustomException;
import com.ahi.model.ProjectsModel;

public interface ProjectService {

	ProjectsModel addProject(ProjectsModel pm, Principal principal) throws AHCustomException;

	boolean deleteProject(Integer projectId) throws AHCustomException;

	ProjectsModel updateProject(ProjectsModel pm, Principal principal) throws AHCustomException;

	List<ProjectsModel> getAllProjects() throws AHCustomException;


}
