package com.sox.springbootdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/")
    public String hello(){
        return  "Hey Hi Sox , Happing learning Spring boot";
    }


    @GetMapping(path = "/student")
    public List<Student> getStudent(){
        return studentService.getStudents();
    }

    @PostMapping(path="/createStudent")
    public String registerNewStudent(@RequestBody Student student){
        studentService.addStudent(student);

        return "Inserted successfully";
    }


    @DeleteMapping("/deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
        return "Deleted successfully";
    }
}
