package com.victor.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity 
@Table(name="Question")
public class Question {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String query;
    private int score;
	@OneToMany(targetEntity=Answer.class, mappedBy="question", fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<@Valid Answer> answers;
	@Column(name="correctanswer")
    private String correctAnswer;
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "examid", referencedColumnName = "id", nullable = false)
	private Exam exam;
  
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public Question() {
        super();
    }
    public Question( String query,int score,String correctAnswer) {
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
	
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		answers.forEach(answer -> answer.setQuestion(this));
		this.answers = answers;
	}


}
