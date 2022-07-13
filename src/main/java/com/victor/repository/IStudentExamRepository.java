package com.victor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.model.Assignment;

public interface IStudentExamRepository extends JpaRepository<Assignment,Integer>   {

}
