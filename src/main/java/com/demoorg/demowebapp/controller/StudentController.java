package com.demoorg.demowebapp.controller;

import com.demoorg.demowebapp.domain.Student;
import com.demoorg.demowebapp.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentServiceImpl.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentServiceImpl.getStudent(id);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/update")
    public Student updateStudent(@RequestBody Student studentDetails){ return studentServiceImpl.updateStudent(studentDetails);}

    @RequestMapping(method=RequestMethod.POST, value="/add")
    public Student addStudent(@RequestBody Student student){ return studentServiceImpl.addStudent(student);}

    @RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long id){ studentServiceImpl.deleteStudent(id);}

}
