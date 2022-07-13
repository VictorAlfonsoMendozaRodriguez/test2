package com.victor.dto;

import java.sql.Date;

public class StudentExamDTO {
	
    private Integer id;
    private Integer studentid;
    private Integer examid;
	private Date date;
    

	public StudentExamDTO() {
        super();
    }
    public StudentExamDTO(int studentid, int examid, Date date) {
        super();
        this.studentid = studentid;
        this.examid = examid;
        this.date = date;
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
	public void setExamid(Integer examid) {
		this.examid = examid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
}