package com.xisoft.projectmanagementtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xisoft.projectmanagementtool.domain.Project;
import com.xisoft.projectmanagementtool.services.ProjectService;

@RestController
@RequestMapping("api/project")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping("")
	public ResponseEntity<?> CreateNewProject(@Valid @RequestBody Project project, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<String>("Invalid Project Object", HttpStatus.BAD_REQUEST);
		}
		Project prj = projectService.saveProject(project);
		return new ResponseEntity<Project>(prj, HttpStatus.CREATED);
	}

}
