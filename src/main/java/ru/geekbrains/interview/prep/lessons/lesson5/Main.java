package ru.geekbrains.interview.prep.lessons.lesson5;

import ru.geekbrains.interview.prep.lessons.lesson5.dao.BaseDAO;
import ru.geekbrains.interview.prep.lessons.lesson5.domain.Student;

public class Main {

    public static void main(String[] args) {
        doExample();
    }

    private static void doExample() {
        BaseDAO<Student, Long> studentRepository = new BaseDAO<>(Student.class,"configs/hibernate.cfg.xml");
        studentRepository.saveOrUpdate(new Student("Денис", "GB"));
        System.out.println(studentRepository.findById(1L));
    }
}
