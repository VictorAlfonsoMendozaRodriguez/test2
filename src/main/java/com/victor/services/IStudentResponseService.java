package com.victor.services;

import org.springframework.stereotype.Service;

import com.victor.dto.StudentResponseDTO;

@Service
public interface IStudentResponseService {
	StudentResponseDTO create(StudentResponseDTO studentResponse);
}
