package com.testbase.myrestspringbootapph2db.service;

import com.testbase.myrestspringbootapph2db.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent(int id);

    Student saveStudent(Student student);

    boolean deleteStudent(int id);
}
