package com.testbase.myrestspringbootapph2db.controller;

import com.testbase.myrestspringbootapph2db.entity.Student;
import com.testbase.myrestspringbootapph2db.service.ResponseWithStatus;
import com.testbase.myrestspringbootapph2db.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public ResponseWithStatus<List<Student>> showAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        if (allStudents != null && !allStudents.isEmpty()) {
            return new ResponseWithStatus<>(allStudents, "Успешно студенты найдены", true);
        } else {
            return new ResponseWithStatus<>(allStudents, "Нет студентов", false);
        }
    }

    @GetMapping("/students/{id}")
    public ResponseWithStatus<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return new ResponseWithStatus<>(student, "Успешно cтудент найден", true);
        } else {
            return new ResponseWithStatus<>(null, "Студент не найден", false);
        }
    }

    @PostMapping("/students")
    public ResponseWithStatus<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        if (savedStudent != null) {
            return new ResponseWithStatus<>(savedStudent, "Студент сохранен успешно", true);
        } else {
            return new ResponseWithStatus<>(null, "Не удалось сохранить студента", false);
        }
    }

    @PutMapping("/students")
    public ResponseWithStatus<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.saveStudent(student);
        if (updatedStudent != null) {
            return new ResponseWithStatus<>(updatedStudent, "Студент обновлен успешно", true);
        } else {
            return new ResponseWithStatus<>(null, "Не удалось обновить студента", false);
        }
    }

    @DeleteMapping("/students/{id}")
    public ResponseWithStatus<Void> deleteStudent(@PathVariable("id") int id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return new ResponseWithStatus<>(null, "Студент удален успешно", true);
        } else {
            return new ResponseWithStatus<>(null, "Не удалось удалить студента", false);
        }
    }
}