package com.testbase.myrestspringbootapph2db.dao;


import com.testbase.myrestspringbootapph2db.entity.EducationalDiscipline;
import com.testbase.myrestspringbootapph2db.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Slf4j
@Repository
public class EducationalDisciplineDAOImpl implements EducationalDisciplineDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<EducationalDiscipline> getAllEducationalDisciplines () {

        Query query = entityManager.createQuery("from EducationalDiscipline");
        List <EducationalDiscipline> allEducationalDisciplines = query.getResultList();
        log.info("getAllEducationalDisciplines" + allEducationalDisciplines);
        return allEducationalDisciplines;
    }

    @Override
    public EducationalDiscipline saveEducationalDiscipline(EducationalDiscipline educationalDiscipline) {
        return entityManager.merge(educationalDiscipline);
    }

    @Override
    public  EducationalDiscipline getEducationalDiscipline(int id){
        return  entityManager.find(EducationalDiscipline.class, id);
    }

    @Override
    public boolean deleteEducationalDiscipline(int id) {
        /**
        Query query = entityManager.createQuery("delete from EducationalDiscipline "
                + " where id =:educationalDisciplineId");
        query.setParameter("educationalDisciplineId", id);
        query.executeUpdate();
        return false; */
        try {
            EducationalDiscipline educationalDiscipline = entityManager.find(EducationalDiscipline.class, id);
            if (educationalDiscipline != null) {
                entityManager.remove(educationalDiscipline);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
