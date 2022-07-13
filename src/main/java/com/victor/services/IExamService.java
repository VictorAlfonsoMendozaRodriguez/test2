package com.victor.services;

import org.springframework.stereotype.Service;

import com.victor.dto.ExamDTO;

@Service
public interface IExamService {
	ExamDTO create(ExamDTO exam);
	
	ExamDTO  getByID(Integer id);
}
