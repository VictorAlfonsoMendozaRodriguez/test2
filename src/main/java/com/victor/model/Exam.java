package com.victor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity 
@Table(name="exam")
public class Exam {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank()
	private String name;
    @OneToMany(targetEntity=Question.class, mappedBy="exam", fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<@Valid Question> questions;
  
    public Exam() {
        super();
    }
    public Exam(String name ) {
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
    
    public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		questions.forEach(question -> question.setExam(this));
		this.questions = questions;
	}

}
