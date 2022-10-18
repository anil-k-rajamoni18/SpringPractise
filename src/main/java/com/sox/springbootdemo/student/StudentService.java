package com.sox.springbootdemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){

/*        return Arrays.asList(
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
        );*/
        return  studentRepository.findAll();

    }

    public void addStudent(Student student) {
//        System.out.println(student);
//        studentRepository.save(student);

       Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());

       if(studentByEmail.isPresent()){
           throw  new IllegalStateException("email taken");
       }
       studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exist = studentRepository.existsById(id);

        if(!exist){
            throw new IllegalStateException("student with id" + id +
                    "does not exits");
        }
        studentRepository.deleteById(id);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("student id" + studentId
                        +" doesn't not exist"));

        if(name != null && name.length()>0 && !Objects.equals(name,student.getName())){
            student.setName(name);
        }

        if(email != null && email.length()>0 && !Objects.equals(email,student.getEmail()) ){

            Optional<Student>studentOptional = studentRepository.findStudentByEmail(email);

            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken");
            }
            student.setEmail(email);
        }
    }
}
