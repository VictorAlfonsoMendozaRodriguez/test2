package com.victor.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.dto.AnswerQuestionDTO;
import com.victor.dto.StudentResponseDTO;
import com.victor.model.Assignment;
import com.victor.model.Exam;
import com.victor.model.Question;
import com.victor.model.StudentResponse;
import com.victor.repository.IExamRepository;
import com.victor.repository.IStudentExamRepository;
import com.victor.repository.IStudentResponseRepository;

@Service
public class StudentResponseService implements IStudentResponseService {

	@Autowired
	IStudentResponseRepository studentResponseRepo;
	@Autowired
	IStudentExamRepository studentExamRepo;
	@Autowired
	IExamRepository examExamRepo;

	@Override
	public StudentResponseDTO create(StudentResponseDTO studentResponse) {
		
		Assignment assignment = studentExamRepo.findById(studentResponse.getAssignment()).orElse(null);
		Exam exam = examExamRepo.findById(assignment==null?0:assignment.getExamid()).orElse(null);
		
		int score = 0;
		
		if(exam != null && studentResponse.getQuestion().stream().filter(
				response -> existinListofQuestions(response.getQuestionid(),response.getAswerid(),exam.getQuestions())
				).count()==studentResponse.getQuestion().size()) {
			
			
			for (AnswerQuestionDTO question : studentResponse.getQuestion()) {

				StudentResponse studentRes = new StudentResponse();
				studentRes.setStudentexamid(studentResponse.getAssignment());
				studentRes.setQuestionid(question.getQuestionid());
				studentRes.setAnswerid(question.getAswerid());
				studentResponseRepo.save(studentRes);
				score = score + getScoreResponse(question.getQuestionid(),question.getAswerid(),exam.getQuestions());
			}
			studentResponse.setScore(score);
			return studentResponse;
			
		}
		return null;
	}
	
	private boolean existinListofQuestions(int questionID, int anserwerID, Set<Question> question) {
		
		return question.stream().anyMatch(q-> q.getId() ==questionID && q.getAnswers().stream().anyMatch(a-> a.getId()== anserwerID));
	}
	
	private int getScoreResponse(int questionID, int anserwerID, Set<Question> question) {
		return question.stream().filter(
				q-> q.getId() ==questionID && 
				q.getAnswers().stream().anyMatch(a-> a.getId()== anserwerID && q.getCorrectAnswer().equals(a.getValue()) )
				).mapToInt(q->q.getScore()).sum();
	}
}


