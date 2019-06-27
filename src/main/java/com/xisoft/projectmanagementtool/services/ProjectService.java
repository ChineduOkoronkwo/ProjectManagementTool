package com.xisoft.projectmanagementtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.xisoft.projectmanagementtool.domain.Project;
import com.xisoft.projectmanagementtool.exceptions.ProjectIdException;
import com.xisoft.projectmanagementtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project) {
		try {
			return projectRepository.save(project);
		} catch (Exception e) {
			throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists");
		}
	}
	
	public Project findProjectById(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project ID '" + projectId.toUpperCase() + "' does not exist");
		}
		return project;
	}
	
	public void deleteProjectByProjectIdentifier(@PathVariable String projectId) {
		Project prj = findProjectById(projectId.toUpperCase());
		projectRepository.delete(prj);
	}
	
	public Iterable<Project> getAll() {
		return projectRepository.findAll();
	}
}
