package com.qsp.student_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.student_management_system.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	Student findByPhone(long phone);

	Student findByEmail(String email);

	List<Student> findByAddress(String address);

	List<Student> findByName(String name);

	List<Student> findByPercentageLessThan(double marks);

	List<Student> findByPercentageGreaterThan(double marks);

	List<Student> findByPercentageBetween(double marks1, double marks2);

	List<Student> findByGrade(String grade);

}
