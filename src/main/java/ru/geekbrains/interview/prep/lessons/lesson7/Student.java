package ru.geekbrains.interview.prep.lessons.lesson7;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "student_tbl")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name_fld")
    private String name;

    @Column(name = "age_fld")
    private Integer age;

}
