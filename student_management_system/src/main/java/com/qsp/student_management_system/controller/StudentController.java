package com.qsp.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.student_management_system.dto.Student;
import com.qsp.student_management_system.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
   
	@Autowired
	private StudentService service;
	
	@PostMapping
	public Student save(@RequestBody Student student)
	{
		return service.save(student);
	}
	
	@PostMapping("/saveall")
	public List<Student> saveAll(@RequestBody List<Student> list)
	{
		return service.saveAll(list);
	}
	
	@GetMapping("/find")
	public Student findById(@RequestParam int id)
	{
		return service.findById(id);
	}
	
	@GetMapping("/find/all")
	public List<Student> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/find/phone")
	public Student findStudent(@RequestParam long phone) {
		return service.findStudent(phone);

	}

	@GetMapping("/find/email")
	public Student findPerson(@RequestParam String email) {
		return service.findStudent(email);

	}
	
	@GetMapping("/find/address")
	public List<Student> findByAddress(@RequestParam String address) {
		return service.findByAddress(address);
	}

	@GetMapping("/find/name")
	public List<Student> findByName(@RequestParam String name) {
		return service.findByName(name);

	}
	
	@GetMapping("/find/grade")
	public List<Student> findByGrade(@RequestParam String grade) {
		return service.findByGrade(grade);
	}

	
	@GetMapping("find/marks/lessthan")
	public List<Student> findLessThanMarks(@RequestParam double marks)
	{
		return service.findLessThanMarks(marks);
	}
	
	@GetMapping("find/marks/greaterthan")
	public List<Student> findGreaterThanMarks(@RequestParam double marks)
	{
		return service.findGreaterThanMarks(marks);
	}
	
	@GetMapping("find/marks/between")
	public List<Student> findSalaryBetween(@RequestParam double marks1,@RequestParam double marks2)
	{
		return service.findMarksBetween(marks1,marks2);
	}
	
	@PutMapping("/update")
	public Student update(@RequestParam int id, @RequestBody Student student) {
		return service.update(id, student);
	}

	@PatchMapping("/update/phone")
	public Student updatePhone(@RequestParam int id, @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/update/email")
	public Student updateEmail(@RequestParam int id, @RequestParam String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/update/password")
	public Student updatePassword(@RequestParam int id, @RequestParam String password) {
		return service.updatePasswordById(id, password);
	}

	@PatchMapping("/update/address")
	public Student updateAddress(@RequestParam int id, @RequestParam String address) {
		return service.updateAddress(id, address);
	}
	
	@PatchMapping("/update/marks")
	public Student updateMarks(@RequestParam int id, @RequestParam int marks) {
		return service.updateMarks(id, marks);
	}
	
	@GetMapping("/login")
	public String loginPerson(@RequestParam String userName, @RequestParam String password) {
		
		return service.loginPerson(userName, password);
	}
	
	@DeleteMapping("/delete")
	public Student delete(@RequestParam int id) {
		return service.delete(id);

	}

	@DeleteMapping("delete/email")
	public Student deleteByEmail(@RequestParam String email) {
		return service.deleteByEmail(email);
	}

	@DeleteMapping("/delete/phone")
	public Student deleteByPhone(@RequestParam long phone) {
		return service.deleteByPhone(phone);
	}
	
	@PatchMapping("/update/password/id")
	public Student updatePasswordById(@RequestParam int id ,@RequestParam String password)
	{
		return service.updatePasswordById(id ,password);
		
	}
	
	@PatchMapping("/update/password/phone")
	public Student updatePasswordByPhone(@RequestParam long phone ,@RequestParam String password)
	{
		return service.updatePasswordByPhone(phone ,password);
	}
	
	@PatchMapping("/update/password/email")
	public Student updatePasswordByEmail(@RequestParam String email ,@RequestParam String password)
	{
		return service.updatePasswordByEmail(email ,password);
	}
}
