package ru.geekbrains.interview.prep.lessons.lesson7;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepository studentRepository;

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student saveOrUpdate(Student student){
        return studentRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }
}
