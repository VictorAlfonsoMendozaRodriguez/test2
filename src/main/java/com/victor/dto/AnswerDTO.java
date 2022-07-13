package com.victor.dto;

import javax.validation.constraints.NotBlank;

public class AnswerDTO {
	
    private Integer id;
	@NotBlank()
    private String value;
	private QuestionDTO question;
	@NotBlank()
	private String index;
  
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public QuestionDTO geQuestion() {
		return question;
	}
	public void setQuestion(QuestionDTO question) {
		this.question = question;
	}

	public AnswerDTO() {
        super();
    }
    public AnswerDTO( String value) {
        super();
        this.value = value;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
  
    

}
