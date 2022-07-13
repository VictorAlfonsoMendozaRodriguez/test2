package com.victor.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.dto.StudentDTO;
import com.victor.model.Student;
import com.victor.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {
	
	@Autowired
	IStudentRepository examRepo;

	@Override
	public StudentDTO create(StudentDTO student) {
		ModelMapper modelMapper = new ModelMapper();
		Student exam = modelMapper.map(student, Student.class);
		return modelMapper.map(examRepo.save(exam), StudentDTO.class);
	}


    
}