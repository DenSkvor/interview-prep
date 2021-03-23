package ru.geekbrains.interview.prep.lessons.lesson6.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping
    @ResponseBody
    public String getHello(){
        return "GET Hello!";
    }

    @PostMapping
    @ResponseBody
    public String postHello(){
        return "POST Hello!";
    }
}
