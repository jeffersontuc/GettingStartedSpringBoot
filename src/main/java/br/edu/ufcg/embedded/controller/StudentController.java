package br.edu.ufcg.embedded.controller;

import br.edu.ufcg.embedded.model.Coach;
import br.edu.ufcg.embedded.model.DTO.RegisterStudent;
import br.edu.ufcg.embedded.model.Student;
import br.edu.ufcg.embedded.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by treinamento-16 on 04/05/17.
 */

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@Valid @RequestBody RegisterStudent student){

        Student newStudent = new Student(student.getName(), student.getDateOfBirth(), student.getEmail(), student.getPassword(), student.getPhone(), student.getCpf(), student.getAddress());

        return new ResponseEntity<>(studentService.create(newStudent), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getStudents(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id){
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody RegisterStudent student){

        Student newStudent = new Student(student.getName(), student.getDateOfBirth(), student.getEmail(), student.getPassword(), student.getPhone(), student.getCpf(), student.getAddress());
        return new ResponseEntity<>(studentService.update(newStudent), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable("id") Long id){
        return new ResponseEntity(studentService.removeById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll(){
        return new ResponseEntity(studentService.removeAll(), HttpStatus.OK);
    }
}
