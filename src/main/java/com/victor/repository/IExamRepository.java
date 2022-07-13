package com.victor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.model.Exam;

public interface IExamRepository extends JpaRepository<Exam,Integer>   {

}
