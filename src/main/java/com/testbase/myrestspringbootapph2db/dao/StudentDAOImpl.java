package com.testbase.myrestspringbootapph2db.dao;


import com.testbase.myrestspringbootapph2db.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student>  getAllStudents () {

        Query query = entityManager.createQuery("from Student");
        List <Student> allStudents = query.getResultList();
        log.info("getAllStudents" + allStudents);
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public  Student getStudent(int id){
        return  entityManager.find(Student.class, id);
    }

    @Override
    public boolean deleteStudent(int id) {
        try {
            Student student = entityManager.find(Student.class, id);
            if (student != null) {
                entityManager.remove(student);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
        /**
        Query query = entityManager.createQuery("delete from Student "
        + " where id =:studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();
        return true;
         */
    }
}
