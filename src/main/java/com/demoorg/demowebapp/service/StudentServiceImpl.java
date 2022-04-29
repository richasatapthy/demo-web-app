package com.demoorg.demowebapp.service;

import com.demoorg.demowebapp.domain.Student;
import com.demoorg.demowebapp.exception.ResourceNotFoundException;
import com.demoorg.demowebapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override

    public Student updateStudent(Student studentDetails) {
        Student student = studentRepository.findById(studentDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Student","id",studentDetails.getId()));

        student.setEmail(studentDetails.getEmail());

        return studentRepository.save(student);
    }



    public Student insertStudent(@RequestBody Student student)
    { return studentRepository.save(student);}


    public void deleteStudent(@PathVariable("id") Long id){ studentRepository.deleteById(id);}
}
