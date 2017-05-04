package br.edu.ufcg.embedded.repository;

import br.edu.ufcg.embedded.model.Coach;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by treinamento-16 on 04/05/17.
 */
public interface CoachRepository extends CrudRepository<Coach, Long> {

    List<Coach> findAll();

    Coach findByEmail(String email);
}
