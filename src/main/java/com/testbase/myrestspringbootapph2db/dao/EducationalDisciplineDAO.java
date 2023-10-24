package com.testbase.myrestspringbootapph2db.dao;

import com.testbase.myrestspringbootapph2db.entity.EducationalDiscipline;


import java.util.List;

public interface EducationalDisciplineDAO {

    List<EducationalDiscipline> getAllEducationalDisciplines();
    EducationalDiscipline saveEducationalDiscipline(EducationalDiscipline educationalDiscipline);
    EducationalDiscipline getEducationalDiscipline(int id);
    boolean deleteEducationalDiscipline(int id);
}
