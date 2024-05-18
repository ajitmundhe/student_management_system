package com.qsp.student_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.student_management_system.dto.Student;
import com.qsp.student_management_system.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;
	
	public Student save(Student student)
	{
		return repo.save(student);
	}
	public List<Student> saveAll(List<Student>list)
	{
		return repo.saveAll(list);
	}
	
	public Optional<Student> findById(int id)
	{
		return repo.findById(id);
	}
	public List<Student> findAll() {
		return repo.findAll();
	}
	public Student findStudent(long phone)
	{
		return repo.findByPhone(phone);
	}
	public Student findStudent(String email) {
		return repo.findByEmail(email);
	}
	public List<Student> findByAddress(String address) {
		return repo.findByAddress(address);
	}
	public List<Student> findByName(String name) {
		return repo.findByName(name);
	}
	public List<Student> findLessThanMarks(double marks) {
		return repo.findByPercentageLessThan(marks);
	}
	public List<Student> findGreaterThanMarks(double marks) {
		return repo.findByPercentageGreaterThan(marks);
	}
	public List<Student> findByPercentageBetween(double marks1, double marks2) {
		
		return repo.findByPercentageBetween(marks1,marks2);
	}
	public Student loginPerson(String userName) {
		
		try {
		   long phone=Long.parseLong(userName);
		   return repo.findByPhone(phone);
		}
		catch(NumberFormatException e)
		{
			return repo.findByEmail(userName);
		}
	}
	
	public void deleteStudent(Student student)
	{
		repo.delete(student);
	}
	
	public List<Student> findByGrade(String grade)
	{
		return repo.findByGrade(grade);
	}
}
