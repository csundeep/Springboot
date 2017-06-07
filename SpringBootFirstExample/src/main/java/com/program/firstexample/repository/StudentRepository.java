package com.program.firstexample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.program.firstexample.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findByname(String name);
}
