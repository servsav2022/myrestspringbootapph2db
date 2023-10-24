package com.testbase.myrestspringbootapph2db.service;

import com.testbase.myrestspringbootapph2db.dao.StudentDAO;
import com.testbase.myrestspringbootapph2db.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id) {return studentDAO.getStudent(id);}

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id){
        if (studentDAO.deleteStudent(id)) {
            return true;
        } else {
            return false;
        }
    }
}
