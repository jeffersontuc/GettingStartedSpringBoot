package br.edu.ufcg.embedded.repository;

import br.edu.ufcg.embedded.model.Coach;
import br.edu.ufcg.embedded.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by treinamento-16 on 04/05/17.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAll();

    Student findByEmail(String email);

}
