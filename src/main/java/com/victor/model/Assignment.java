package com.victor.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="studentexam")
public class Assignment {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentid;
    private Integer examid;
	private Time time;
    private Date date;

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Assignment() {
        super();
    }
	
    public Assignment(int studentID, int examID, Time date) {
        super();
        this.studentid = studentID;
        this.examid = examID;
        this.time = date;
    }
    
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public Integer getExamid() {
		return examid;
	}
	public void setExamid(Integer examidexamid) {
		this.examid = examidexamid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}