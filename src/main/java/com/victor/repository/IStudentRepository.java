package com.victor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.model.Student;

public interface IStudentRepository extends JpaRepository<Student,Integer>   {

}
