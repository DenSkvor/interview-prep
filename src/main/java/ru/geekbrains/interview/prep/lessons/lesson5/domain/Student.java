package ru.geekbrains.interview.prep.lessons.lesson5.domain;

import javax.persistence.*;

@Entity
@Table(name = "student_tbl")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "name_fld")
    private String name;

    @Column(name = "mark_fld")
    private String mark;


    public Student(){}
    public Student(String name, String mark){
        this.name = name;
        this.mark = mark;
    }


    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getMark() {
        return mark;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
