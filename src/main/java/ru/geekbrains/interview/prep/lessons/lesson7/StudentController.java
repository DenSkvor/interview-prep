package ru.geekbrains.interview.prep.lessons.lesson7;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", studentService.findAll());
        return "student_page";
    }

    @GetMapping("/add_upd")
    public String showAddPage(@ModelAttribute Student student, Model model){
        model.addAttribute("student", student);
        return "add_upd_student_page";
    }

    @PostMapping("/add_upd")
    public String addOrUpdStudent(@ModelAttribute Student student){
        if(student.getName() != null && !student.getName().isBlank() && student.getAge() != null) studentService.saveOrUpdate(student);
        return "redirect:/students";
    }

    @GetMapping("/del/{id}")
    public String delStudent(@PathVariable Long id){
        Student student = studentService.findById(id).orElseThrow(() -> new IllegalArgumentException("Студент не найден."));
        studentService.delete(student);
        return "redirect:/students";
    }

}
