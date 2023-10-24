package com.testbase.myrestspringbootapph2db.controller;
import com.testbase.myrestspringbootapph2db.entity.EducationalDiscipline;
import com.testbase.myrestspringbootapph2db.service.EducationalDisciplineService;
import com.testbase.myrestspringbootapph2db.service.ResponseWithStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EducationalDisciplinesController {
    @Autowired
    private EducationalDisciplineService educationalDisciplineService;
    @GetMapping("/edudisciplines")
    public ResponseWithStatus<List<EducationalDiscipline>> showAllEducationalDisciplines() {
        List<EducationalDiscipline> allEducationalDisciplines =
                educationalDisciplineService.getAllEducationalDisciplines();
        if (allEducationalDisciplines != null && !allEducationalDisciplines.isEmpty()) {
            return new ResponseWithStatus<>(allEducationalDisciplines,
                    "Учебные дисциплины найдены", true);
        } else {
            return new ResponseWithStatus<>(allEducationalDisciplines,
                    "Учебные дисциплины не найдены", false);
        }
    }
    @GetMapping("/edudisciplines/{id}")
    public ResponseWithStatus<EducationalDiscipline> getEducationalDiscipline(@PathVariable("id") int id) {
        EducationalDiscipline educationalDiscipline =
                educationalDisciplineService.getEducationalDiscipline(id);
        if (educationalDiscipline != null) {
            return new ResponseWithStatus<>(educationalDiscipline,
                    "Учебная дисциплина найдена", true);
        } else {
            return new ResponseWithStatus<>(null, "Учебная дисциплина не найдена", false);
        }
    }
    @PostMapping("/edudisciplines")
    public ResponseWithStatus<EducationalDiscipline> saveEducationalDiscipline
            (@RequestBody EducationalDiscipline educationalDiscipline) {
        EducationalDiscipline savedEducationalDiscipline = educationalDisciplineService.
                saveEducationalDiscipline(educationalDiscipline);
        if (savedEducationalDiscipline != null) {
            return new ResponseWithStatus<>
                    (savedEducationalDiscipline, "Учебная дисциплина сохранена успешно", true);
        } else {
            return new ResponseWithStatus<>
                    (null, "Не удалось сохранить учебную дисциплину", false);
        }
    }
    @PutMapping("/edudisciplines")
    public ResponseWithStatus<EducationalDiscipline>
    updateEducationalDiscipline(@RequestBody EducationalDiscipline educationalDiscipline) {
        EducationalDiscipline updatedEducationalDiscipline =
                educationalDisciplineService.saveEducationalDiscipline(educationalDiscipline);
        if (updatedEducationalDiscipline != null) {
            return new ResponseWithStatus<>(updatedEducationalDiscipline,
                    "Учебная дисциплина успешно обновлена", true);
        } else {
            return new ResponseWithStatus<>(null,
                    "Не удалось обновить учебную дисциплину", false);
        }
    }
    @DeleteMapping("/edudisciplines/{id}")
    public ResponseWithStatus<Void> deleteEducationalDiscipline(@PathVariable("id") int id) {
        boolean deleted = educationalDisciplineService.deleteEducationalDiscipline(id);
        if (deleted) {
            return new ResponseWithStatus<>(null,
                    "Учебная дисциплина успешно удалена", true);
        } else {
            return new ResponseWithStatus<>(null,
                    "Не удалось удалить учебную дисциплину", false);
        }
    }
}
