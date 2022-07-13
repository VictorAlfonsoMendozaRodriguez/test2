package com.victor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.dto.Errors;
import com.victor.dto.StudentDTO;
import com.victor.services.IStudentService;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	@Autowired
	IStudentService estudentService;
	
	@PostMapping("/student")
	public ResponseEntity<Object> addStudent(@Validated @RequestBody StudentDTO request, BindingResult bindingResult) {
			
		if (bindingResult.hasErrors()) {
			Errors error = new Errors(bindingResult.getAllErrors());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			
		} else {
			return new ResponseEntity<>(estudentService.create(request), HttpStatus.OK);
		}

	}

}