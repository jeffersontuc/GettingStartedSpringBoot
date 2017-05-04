package br.edu.ufcg.embedded.service;

import br.edu.ufcg.embedded.model.Student;
import br.edu.ufcg.embedded.repository.StudentRepository;
import br.edu.ufcg.embedded.util.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by treinamento-16 on 04/05/17.
 */

@Service
public class StudentService implements Crud<Student> {

    @Autowired
    StudentRepository studentRepository;

    public Student create(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public Student update(Student student) {
        if(studentRepository.exists(student.getId())){
            return studentRepository.save(student);
        }

        return null;
    }

    @Override
    public boolean removeById(Long id) {
        if(studentRepository.exists(id)){
            studentRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll() {
        studentRepository.deleteAll();
        return true;
    }


    public Student getByEmail(String email){
        return studentRepository.findByEmail(email);
    }


}
