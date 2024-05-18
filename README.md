# Student Management System

## Overview

The Student Management System is a comprehensive web application developed using Spring Boot. It enables efficient management of student records, providing functionalities for CRUD operations, data retrieval, and user authentication.

## Features

- *Add Student*: Save individual or multiple student records.
- *View Students*: Retrieve student information based on various criteria (ID, phone, email, grades, etc.).
- *Update Student*: Modify student details such as name, phone number, email, secured marks, and more.
- *Delete Student*: Remove student records by ID, phone number, email, or all at once.
- *Authentication*: User login functionality with email/phone and password.
- *Advanced Search*: Filter students by percentage, grades, and other attributes.

## Technologies Used

- *Backend*: Spring Boot
- *Database*: JPA (Hibernate), MySQL/PostgreSQL
- *Testing*: JUnit, Mockito
- *Build Tool*: Maven
- *Version Control*: Git

## Project Structure

src
├── main
│ ├── java
│ │ └── com
│ │ └── qsp
│ │ └── studentmanagementsystem
│ │ ├── controller
│ │ │ └── StudentController.java
│ │ ├── dao
│ │ │ └── StudentDao.java
│ │ ├── dto
│ │ │ └── Student.java
│ │ ├── repo
│ │ │ └── StudentRepo.java
│ │ └── service
│ │ └── Service.java
│ └── resources
│ └── application.properties
└── test
└── java
└── com
└── qsp
└── studentmanagementsystem
└── StudentManagementSystemApplicationTests.java


## Endpoints

### StudentController

- *Create Operations*
  - POST /student/save: Save a single student.
  - POST /student/saveAll: Save multiple students.

- *Read Operations*
  - GET /student/getById: Retrieve student by ID.
  - GET /student/getAll: Retrieve all students.
  - GET /student/getByPhone: Retrieve student by phone number.
  - GET /student/getByEmail: Retrieve student by email.
  - GET /student/login: Login using email/phone and password.
  - GET /student/getByGrades: Retrieve students by grades.
  - GET /student/getByName: Retrieve students by name.
  - GET /student/getByAddress: Retrieve students by address.
  - GET /student/getByPercentage: Retrieve students by percentage.
  - GET /student/getLessThan: Retrieve students with percentage less than a specified value.
  - GET /student/getGreaterThan: Retrieve students with percentage greater than a specified value.
  - GET /student/getBetween: Retrieve students with percentage between two specified values.

- *Update Operations*
  - PUT /student/update: Update student details.
  - PATCH /student/updateMarks: Update student marks.
  - PATCH /student/updatePhone: Update student phone number.
  - PATCH /student/updateEmail: Update student email.
  - PATCH /student/updateName: Update student name.
  - PATCH /student/updatePassword: Update student password.
  - PATCH /student/updatePasswordAfterLogin: Update password after login.
  - PATCH /student/updatePasswordByPhone: Update password using phone number.

- *Delete Operations*
  - DELETE /student/delete: Delete student by ID.
  - DELETE /student/deleteByEmail: Delete student by email.
  - DELETE /student/deleteByPhone: Delete student by phone number.
  - DELETE /student/deleteAll: Delete all student records.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- MySQL/PostgreSQL

### Setup

1. *Clone the repository*
   ```bash
   git clone https://github.com/yourusername/student-management-system.git
   cd student-management-system
2. *Build and run the application*
-mvn clean install
-mvn spring-boot:run
3. *Access the application*
Open your browser and go to http://localhost:8080

###Contributing
Contributions are welcome! Please fork the repository and submit a pull request.
