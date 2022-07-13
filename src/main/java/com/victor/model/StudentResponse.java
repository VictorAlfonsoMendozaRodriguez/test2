package com.victor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="studentresponse")
public class StudentResponse {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private Integer studentexamid;
    private Integer answerid;
    private Integer questionid;

	public StudentResponse() {
        super();
    }
    public StudentResponse(int studentexamid, int answerid, int questionid) {
        super();
        this.studentexamid = studentexamid;
        this.answerid = answerid;
        this.questionid = questionid;
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentexamid() {
		return studentexamid;
	}
	public void setStudentexamid(Integer studentexamid) {
		this.studentexamid = studentexamid;
	}
	public Integer getAnswerid() {
		return answerid;
	}
	public void setAnswerid(Integer answerid) {
		this.answerid = answerid;
	}
	public Integer getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}
    
}