package com.victor.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

public class QuestionDTO {
	

    private Integer id;

	@NotBlank()
    private String query;
	@Min(1)
    private int score;
	@Size(min=4, max=4)
	@UniqueElements
	private List<@Valid AnswerDTO> answers;
	@NotBlank()
    private String correctAnswer;
  
	public QuestionDTO() {
        super();
    }
    public QuestionDTO( String query,int score,String correctAnswer) {
        super();
        this.query = query;
        this.score = score;
        this.correctAnswer = correctAnswer; 
    }
  
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return query;
	}
	public void setQuestion(String question) {
		this.query = question;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	public List<AnswerDTO> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerDTO> answers) {
		answers.forEach(answer -> answer.setQuestion(this));
		this.answers = answers;
	}


}
