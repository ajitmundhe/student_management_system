package com.qsp.student_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.student_management_system.dao.StudentDao;
import com.qsp.student_management_system.dto.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao dao;

	public Student save(Student student) {
		double secured = student.getSecuredMarks();
		student.setTotalMarks(500);
		double total = student.getTotalMarks();

		if (secured <= 500 && 0 < secured) {
			double marks = ((secured * 100) / total);
			student.setPercentage(marks);

			if (marks >= 85) {
				student.setGrade("Distinction");
			} else if (marks >= 70 && marks < 85) {
				student.setGrade("First class");
			} else if (marks >= 49 && marks < 70) {
				student.setGrade("Second class");
			} else if (marks >= 35 && marks < 49) {
				student.setGrade("Pass");
			} else {
				student.setGrade("Fail");

			}
			return dao.save(student);
		} else {
			return null;
		}
	}

	public List<Student> saveAll(List<Student> list) {

		for (Student student : list) {

			double secured = student.getSecuredMarks();
			student.setTotalMarks(500);
			double total = student.getTotalMarks();

			if (secured <= 500 && 0 < secured) {
				double marks = ((secured * 100) / total);
				student.setPercentage(marks);

				if (marks >= 85) {
					student.setGrade("Distinction");
				} else if (marks >= 70 && marks < 85) {
					student.setGrade("First class");
				} else if (marks >= 49 && marks < 70) {
					student.setGrade("Second class");
				} else if (marks >= 35 && marks < 49) {
					student.setGrade("Pass");
				} else {
					student.setGrade("Fail");

				}

			}
		}
		return dao.saveAll(list);
	}
	public Student findById(int id)
	{
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			return null;
		}
	}

	public List<Student> findAll() {
		return dao.findAll();
	
	}

	public Student findStudent(long phone) {
		
		return dao.findStudent(phone);
	}

	public Student findStudent(String email) {
		return dao.findStudent(email);
	}

	public List<Student> findByAddress(String address) {
		  return dao.findByAddress(address);
	}

	public List<Student> findByName(String name) {
		 return dao.findByName(name);
	}

	public List<Student> findLessThanMarks(double marks) {
		return dao.findLessThanMarks(marks);
	}

	public List<Student> findGreaterThanMarks(double marks) {
		return dao.findGreaterThanMarks(marks);

	}

	public List<Student> findMarksBetween(double marks1, double marks2) {
		return dao.findByPercentageBetween(marks1,marks2);
	}

	public Student update(int id, Student student) {
		
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			 student.setId(id);
			 double secured = student.getSecuredMarks();
				student.setTotalMarks(500);
				double total = student.getTotalMarks();

				if (secured <= 500 && 0 < secured) {
					double marks = ((secured * 100) / total);
					student.setPercentage(marks);

					if (marks >= 85) {
						student.setGrade("Distinction");
					} else if (marks >= 70 && marks < 85) {
						student.setGrade("First class");
					} else if (marks >= 49 && marks < 70) {
						student.setGrade("Second class");
					} else if (marks >= 35 && marks < 49) {
						student.setGrade("Pass");
					} else {
						student.setGrade("Fail");

					}
					return dao.save(student);
				}
				else
				{
					return null;
				}
		}
		else
		{
			return null;
		}		 
	}

	public Student updatePhone(int id, long phone) {
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			Student s=op.get();
			 s.setPhone(phone);
			 dao.save(s);
			 return s;
		}
		else
		{
			return null;
		}
	}

	public Student updateEmail(int id, String email) {
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			Student s=op.get();
			 s.setEmail(email);
			 dao.save(s);
			 return s;
		}
		else
		{
			return null;
		}
	}

	public Student updatePasswordById(int id, String password) {
		
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			Student s=op.get();
			 s.setPassword(password);
			 dao.save(s);
			 return s;
		}
		else
		{
			return null;
		}
	}

	public Student updateAddress(int id, String address) {
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			Student s=op.get();
			 s.setAddress(address);
			 dao.save(s);
			 return s;
		}
		else
		{
			return null;
		}
	}

	public String loginPerson(String userName, String password) {
		   
		   Student student= dao.loginPerson(userName);
		   if(student!=null)
		   {
			   if(student.getPassword().equals(password))
			   {
				   return "Login Sucessfull";
			   }
			   else
			   {
				   return "Incorrect Password";
			   }
		   }
		   else
		   {
			   return "Student Not Found ";
		   }
	}

	public Student delete(int id) {
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			dao.deleteStudent(op.get());
			return op.get();
		}
		else
		{
			return null;
		}
	}

	public Student deleteByEmail(String email) {
		Student student=  dao.findStudent(email);
		if(student!=null)
		{
			dao.deleteStudent(student);
			return student;
		}
		else
		{
			return null;
		}
	}

	public Student deleteByPhone(long phone) {
		
		Student student=  dao.findStudent(phone);
		if(student!=null)
		{
			dao.deleteStudent(student);
			return student;
		}
		else
		{
			return null;
		}
	}

	public Student updatePasswordByPhone(long phone, String password) {
		
		Student student=  dao.findStudent(phone);
		if(student!=null)
		{
			student.setPassword(password);
			return dao.save(student);
		}
		else
		{
			return null;
		}
	}

	public Student updatePasswordByEmail(String email, String password) {
		Student student=  dao.findStudent(email);
		if(student!=null)
		{
			student.setPassword(password);
			return dao.save(student);
		}
		else
		{
			return null;
		}
	}

	public List<Student> findByGrade(String grade) {
		  
		List<Student> list=dao.findByGrade(grade);
		if(!(list.isEmpty()))
		{
			return list;
		}
		else
		{
			return null;
		}
	}

	public Student updateMarks(int id, int secured) {
		
		Optional<Student>op=  dao.findById(id);
		if(op.isPresent())
		{
			Student student=op.get();
			
			student.setSecuredMarks(secured);
//			double secured = student.getSecuredMarks();
//			student.setTotalMarks(500);
			double total = student.getTotalMarks();

			if (secured <= 500 && 0 <=secured) {
				double marks = ((secured * 100) / total);
				student.setPercentage(marks);

				if (marks >= 85) {
					student.setGrade("Distinction");
				} else if (marks >= 70 && marks < 85) {
					student.setGrade("First class");
				} else if (marks >= 49 && marks < 70) {
					student.setGrade("Second class");
				} else if (marks >= 35 && marks < 49) {
					student.setGrade("Pass");
				} else {
					student.setGrade("Fail");

				}
				return dao.save(student);
//			return dao.save(s);
			}
			return null;
		}
		else
		{
			return null;
		}
	}

	
}
