package br.edu.ufcg.embedded.service;

import br.edu.ufcg.embedded.model.Coach;
import br.edu.ufcg.embedded.repository.CoachRepository;
import br.edu.ufcg.embedded.util.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by treinamento-16 on 04/05/17.
 */

@Service
public class CoachService implements Crud<Coach> {

    @Autowired
    CoachRepository coachRepository;


    public Coach create(Coach coach){
        return coachRepository.save(coach);
    }

    @Override
    public List<Coach> getAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach getById(Long id) {
        return coachRepository.findOne(id);
    }

    @Override
    public Coach update(Coach coach) {

        if(coachRepository.exists(coach.getId())){
            coachRepository.save(coach);
        }
        return null;
    }

    @Override
    public boolean removeById(Long id) {
        if(coachRepository.exists(id)){
            coachRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll() {
        coachRepository.deleteAll();
        return true;
    }


    public Coach getByEmail(String email){
        return coachRepository.findByEmail(email);
    }

}
