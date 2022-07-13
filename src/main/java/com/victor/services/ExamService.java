package com.victor.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.dto.ExamDTO;
import com.victor.model.Exam;
import com.victor.repository.IExamRepository;

@Service
public class ExamService implements IExamService {
	
	@Autowired
	IExamRepository examRepo;

	@Override
	public ExamDTO create(ExamDTO examdto) {
		
		ModelMapper modelMapper = new ModelMapper();
		Exam exam = modelMapper.map(examdto, Exam.class);
		return modelMapper.map(examRepo.save(exam), ExamDTO.class);
	}

	@Override
	public ExamDTO getByID(Integer id) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(examRepo.findById(id).orElse(new Exam()), ExamDTO.class);
	}
    
}