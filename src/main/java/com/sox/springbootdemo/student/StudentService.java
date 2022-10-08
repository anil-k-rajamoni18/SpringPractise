package com.sox.springbootdemo.student;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class StudentService {

    public List<Student> getStudents(){
        return Arrays.asList(
                new Student(
                        96L,
                        "AnilKumar",
                        "ak@optum.com",
                        LocalDate.of(1999, Month.MARCH,9),
                        23
                )
                ,
                new Student(
                        97L,
                        "Rajamoni",
                        "rajamoni@optum.com",
                        LocalDate.of(2000, Month.MARCH,12),
                        22
                )

        );
    }
}
