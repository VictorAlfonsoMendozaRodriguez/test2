package com.victor.services;

import org.springframework.stereotype.Service;

import com.victor.dto.AssignmentDTO;

@Service
public interface IAssignmentService {
	AssignmentDTO create(AssignmentDTO assignment);

	AssignmentDTO getByID(int id);
}
