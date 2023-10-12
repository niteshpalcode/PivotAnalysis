package com.crudStudent.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudStudent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findByRollNumber(int rollNumber);

}
