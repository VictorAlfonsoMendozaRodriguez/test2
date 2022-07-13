package com.victor.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Answer")
public class Answer {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;
    private String index;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "questionid", referencedColumnName = "id", nullable = false)
	private Question question;
  
	public Question geQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer() {
        super();
    }
    public Answer( String value) {
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
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
    

}
