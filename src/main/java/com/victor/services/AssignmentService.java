package com.victor.services;

import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.dto.AnswerQuestionDTO;
import com.victor.dto.AssignmentDTO;
import com.victor.model.Assignment;
import com.victor.model.Exam;
import com.victor.model.Question;
import com.victor.model.StudentResponse;
import com.victor.repository.IExamRepository;
import com.victor.repository.IStudentExamRepository;
import com.victor.repository.IStudentResponseRepository;

@Service
public class AssignmentService implements IAssignmentService {
	
	@Autowired
	IStudentExamRepository studentExamRepo;
	@Autowired
	IStudentResponseRepository studentResponseRepo;
	@Autowired
	IExamRepository examExamRepo;

	@Override
	public AssignmentDTO create(AssignmentDTO assignment) {
		ModelMapper modelMapper = new ModelMapper();
		Assignment exam = modelMapper.map(assignment, Assignment.class);
		return modelMapper.map(studentExamRepo.save(exam), AssignmentDTO.class);
	}

	@Override
	public AssignmentDTO getByID(int id) {
		Assignment assignment = studentExamRepo.findById(id).orElse(null);
		Exam exam = examExamRepo.findById(assignment==null?0:assignment.getExamid()).orElse(null);
		
		List<StudentResponse> studentResponse = studentResponseRepo.findByStudentexamid(assignment.getId());
		
		int score = 0;

		for (StudentResponse response : studentResponse) {
			StudentResponse studentRes = new StudentResponse();
			studentRes.setStudentexamid(id);
			studentRes.setQuestionid(response.getQuestionid());
			studentRes.setAnswerid(response.getAnswerid());
			score = score + getScoreResponse(response.getQuestionid(),response.getAnswerid(),exam.getQuestions());
		}
		AssignmentDTO asign = new AssignmentDTO();
		asign.setId(id);
		asign.setExamid(exam.getId());
		asign.setStudentid(assignment.getStudentid());
		asign.setScore(score);
		return asign;
		
	}
	
	private int getScoreResponse(int questionID, int anserwerID, Set<Question> question) {
		return question.stream().filter(
				q-> q.getId() ==questionID && 
				q.getAnswers().stream().anyMatch(a-> a.getId()== anserwerID && q.getCorrectAnswer().equals(a.getValue()) )
				).mapToInt(q->q.getScore()).sum();
	}
    
}