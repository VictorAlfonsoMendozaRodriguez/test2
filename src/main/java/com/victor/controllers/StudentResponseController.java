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

import com.victor.dto.Errors;
import com.victor.dto.StudentResponseDTO;
import com.victor.services.IStudentResponseService;

@RestController
@RequestMapping("/api/v1/")
public class StudentResponseController {
	
	@Autowired
	IStudentResponseService estudentResponseService;
	
	@PostMapping("/studentresponse")
	public ResponseEntity<Object> addExam(@Validated @RequestBody StudentResponseDTO studentResponse, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			Errors error = new Errors(bindingResult.getAllErrors());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			
		} else {
			StudentResponseDTO exam =estudentResponseService.create(studentResponse);
			return new ResponseEntity<>(exam, HttpStatus.OK);
		}
		
	}
	

}
