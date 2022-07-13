package com.victor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.dto.AssignmentDTO;
import com.victor.dto.Errors;
import com.victor.services.IAssignmentService;

@RestController
@RequestMapping("/api/v1/")
public class AssignmentController {
	@Autowired
	IAssignmentService assignmentService;

	@PostMapping("/Assignment")
	public ResponseEntity<Object> addExam(@Validated @RequestBody AssignmentDTO request, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			Errors error = new Errors(bindingResult.getAllErrors());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			
		} else {
			return new ResponseEntity<>(assignmentService.create(request), HttpStatus.OK);
		}
		
	}
	
	@GetMapping("/Assignment/{id}")
	public ResponseEntity<Object> getExam(@PathVariable int id) {
		
		return new ResponseEntity<>(assignmentService.getByID(id), HttpStatus.OK);

	}

}


