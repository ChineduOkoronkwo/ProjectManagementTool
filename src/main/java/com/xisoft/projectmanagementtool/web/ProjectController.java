package com.xisoft.projectmanagementtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xisoft.projectmanagementtool.domain.Project;
import com.xisoft.projectmanagementtool.services.MapValidationErrorService;
import com.xisoft.projectmanagementtool.services.ProjectService;

@RestController
@RequestMapping("api/project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> saveOrUpdate(@Valid @RequestBody Project project, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
		if (errorMap != null) return errorMap;
		
		Project prj = projectService.saveProject(project);	
		return new ResponseEntity<Project>(prj, HttpStatus.CREATED);		
	}
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProjectByProjectIdentifier(@PathVariable String projectId) {
		projectService.deleteProjectByProjectIdentifier(projectId);
		return new ResponseEntity<String>("Project with ID '" + projectId + " was deleted", HttpStatus.OK);
	}
	
	@GetMapping("/{projectId}")
	//@RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
	public ResponseEntity<?> getProjectById(@PathVariable String projectId) {
		Project prj = projectService.findProjectById(projectId);
		return new ResponseEntity<Project>(prj, HttpStatus.OK); 
	}
	
	@GetMapping("getAll")
	public Iterable<Project> getAll() {
		return projectService.getAll();
	}

}
