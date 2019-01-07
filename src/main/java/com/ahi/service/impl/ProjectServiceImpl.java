package com.ahi.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahi.AHCustomException;
import com.ahi.entity.AhiClients;
import com.ahi.entity.AhiProjects;
import com.ahi.entity.AhiUser;
import com.ahi.model.ProjectsModel;
import com.ahi.repository.ClientsRepository;
import com.ahi.repository.ProjectsRepository;
import com.ahi.repository.UserRepository;
import com.ahi.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProjectsRepository projectsRepository;

	@Autowired
	private UserRepository ahiUserRepository;
	
	@Autowired
	private ClientsRepository clientsRepository;

	@Override
	public ProjectsModel addProject(ProjectsModel pm, Principal principal) throws AHCustomException {
		try {
			AhiProjects projects = new AhiProjects();
			projects.setProjectName(pm.getProjectName());
			projects.setProjectDescription(pm.getProjectDescription());
			projects.setHeadedByUser(ahiUserRepository.findById(pm.getHeadedByUserId()).get());
			projects.setAhiClients(clientsRepository.findById(pm.getClientId()).get());
			projects.setWhoUpdated(principal.getName());
			projectsRepository.save(projects);
			pm.setProjectId(projects.getProjectId());
			return pm;
		} catch (Exception e) {
			log.error("Error while adding Project" + e);
			throw new AHCustomException("Error while adding Project");
		}
	}

	@Override
	public boolean deleteProject(Integer ProjectId) throws AHCustomException {
		try {
			Optional<AhiProjects> projects = projectsRepository.findById(ProjectId);
			if (projects.isPresent())
				log.debug("The entity is present");
			else
				log.debug("The entity is not present");
			AhiProjects Project = projects.get();
			projectsRepository.delete(Project);
			return true;
		} catch (Exception e) {
			log.error("Error while deleting Projects");
			throw new AHCustomException("Error while deleting Project::" + ProjectId);
		}
	}

	@Override
	public ProjectsModel updateProject(ProjectsModel pm, Principal principal) throws AHCustomException {
		try {
			AhiProjects project = projectsRepository.findById(pm.getProjectId()).get();
			if (project == null)
				throw new AHCustomException(
						"Error wnile udpating Project.. No Project found for Project id:::" + pm.getProjectId());
			project.setProjectName(pm.getProjectName());
			project.setProjectDescription(pm.getProjectDescription());
			project.setHeadedByUser(ahiUserRepository.findById(pm.getHeadedByUserId()).get());
			project.setAhiClients(clientsRepository.findById(pm.getClientId()).get());
			project.setWhoUpdated(principal.getName());
			projectsRepository.save(project);
			return pm;
		} catch (Exception e) {
			log.error("Error while adding Project");
			throw new AHCustomException("Error while updating Project" + e);
		}
	}

	@Override
	public List<ProjectsModel> getAllProjects() throws AHCustomException {
		try {
			List<ProjectsModel> models = new ArrayList<>();
			Iterable<AhiProjects> projects = projectsRepository.findAll();
			Iterator<AhiProjects> iterator = projects.iterator();
			while (iterator.hasNext()) {
				ProjectsModel pm = new ProjectsModel();
				AhiProjects project = iterator.next();
				pm.setProjectId(project.getProjectId());
				pm.setProjectDescription(project.getProjectDescription());
				pm.setProjectName(project.getProjectName());
				AhiUser headedByUser = project.getHeadedByUser();
				if (headedByUser != null) {
					pm.setHeadedByUserId(headedByUser.getId());
					pm.setHeadedBy(String.format("%s %s", headedByUser.getFirstName(), headedByUser.getLastName()));
				}
				AhiClients ahiClients = project.getAhiClients();
				if(ahiClients != null) {
					pm.setClientId(ahiClients.getClientId());
					pm.setClientName(ahiClients.getClientName());
				}
				models.add(pm);
			}
			return models;
		} catch (Exception e) {
			log.error("Error while getting Projects");
			throw new AHCustomException("Error while getting Projects");
		}
	}

}
