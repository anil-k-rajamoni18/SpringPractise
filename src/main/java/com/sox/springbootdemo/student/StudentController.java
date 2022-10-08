package com.sox.springbootdemo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class StudentController {

    @GetMapping(path = "/")
    public String hello(){
        return  "Hey Hi Sox , Happing learning Spring boot";
    }

    @GetMapping(path = "/student")
    public List<String> getStudent(){
        return Arrays.asList("Java","Spring");
    }
}
