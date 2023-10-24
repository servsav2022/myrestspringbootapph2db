package com.testbase.myrestspringbootapph2db.dao;

import com.testbase.myrestspringbootapph2db.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudent(int id);
    boolean deleteStudent(int id);
}
