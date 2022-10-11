package com.sox.springbootdemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
         Student st1 =   new Student(96L, "AnilKumar", "ak@optum.com", LocalDate.of(1999, Month.MARCH,9));
         Student st2 =  new Student(97L, "Rajamoni", "rajamoni@optum.com", LocalDate.of(2000, Month.MARCH,12));
         studentRepository.saveAll(Arrays.asList(st1, st2));
        };
    }
}
