package com.testbase.myrestspringbootapph2db.service;

import com.testbase.myrestspringbootapph2db.dao.EducationalDisciplineDAO;
import com.testbase.myrestspringbootapph2db.entity.EducationalDiscipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EducationalDisciplineServiceImpl implements  EducationalDisciplineService{

    @Autowired
    private EducationalDisciplineDAO educationalDisciplineDAO;

    @Override
    @Transactional
    public List<EducationalDiscipline> getAllEducationalDisciplines(){
        return educationalDisciplineDAO.getAllEducationalDisciplines();
    }

    @Override
    @Transactional
    public EducationalDiscipline getEducationalDiscipline(int id){
        return educationalDisciplineDAO.getEducationalDiscipline(id);}

    @Override
    @Transactional
    public EducationalDiscipline saveEducationalDiscipline(EducationalDiscipline educationalDiscipline) {
        return educationalDisciplineDAO.saveEducationalDiscipline(educationalDiscipline);
    }

    @Override
    @Transactional
    public boolean deleteEducationalDiscipline(int id){
        if (educationalDisciplineDAO.deleteEducationalDiscipline(id)) {
            return true;
        } else
            return false;
    }
}
