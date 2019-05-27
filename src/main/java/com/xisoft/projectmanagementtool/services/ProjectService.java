package com.xisoft.projectmanagementtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xisoft.projectmanagementtool.domain.Project;
import com.xisoft.projectmanagementtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
}
