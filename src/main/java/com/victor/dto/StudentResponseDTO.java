package com.victor.dto;

import java.util.List;

public class StudentResponseDTO {
	
	private int assignment;
    private List<AnswerQuestionDTO> question;
    private int score;
	
    public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Integer getAssignment() {
		return assignment;
	}
	public void setAssignment(Integer assignment) {
		this.assignment = assignment;
	}
	public List<AnswerQuestionDTO> getQuestion() {
		return question;
	}
	public void setQuestion(List<AnswerQuestionDTO> question) {
		this.question = question;
	}
	  
}