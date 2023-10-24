package com.testbase.myrestspringbootapph2db.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "EDUDISCIPLINES")
public class EducationalDiscipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public EducationalDiscipline() {}

    public EducationalDiscipline(String name) {
        this.name = name;

    }
}
