package com.victor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.model.Exam;

public interface IAnswerRepository extends JpaRepository<Exam,Integer>   {

}
