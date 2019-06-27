package com.xisoft.projectmanagementtool.repositories;

import org.springframework.data.repository.CrudRepository;

import com.xisoft.projectmanagementtool.domain.Project;


public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	Project findByProjectIdentifier(String projectId);

}
