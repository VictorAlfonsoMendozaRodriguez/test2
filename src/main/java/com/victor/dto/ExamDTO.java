package com.victor.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.victor.entities.validator.TotalScoreConstrait;

public class ExamDTO {
	
    private Integer id;
    @NotBlank()
	private String name;
    @TotalScoreConstrait()
	private List<@Valid QuestionDTO> questions;
  
	public ExamDTO() {
        super();
    }
    public ExamDTO(String name ) {
        super();
        this.name = name;
    }
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
    
    public List<QuestionDTO> getQuestions() {
		return questions;
	}
    public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

}
