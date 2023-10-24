package com.testbase.myrestspringbootapph2db.service;

import com.testbase.myrestspringbootapph2db.entity.EducationalDiscipline;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationalDisciplineService {

    List<EducationalDiscipline> getAllEducationalDisciplines();

    EducationalDiscipline getEducationalDiscipline(int id);

    EducationalDiscipline saveEducationalDiscipline(EducationalDiscipline educationalDiscipline);

    boolean deleteEducationalDiscipline(int id);
}



