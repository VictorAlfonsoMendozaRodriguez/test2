package com.victor.services;

import org.springframework.stereotype.Service;

import com.victor.dto.StudentDTO;

@Service
public interface IStudentService {
	StudentDTO create(StudentDTO student);
}
