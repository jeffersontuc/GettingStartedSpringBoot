package br.edu.ufcg.embedded.controller;

import br.edu.ufcg.embedded.model.Coach;
import br.edu.ufcg.embedded.model.DTO.RegisterCoach;
import br.edu.ufcg.embedded.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by treinamento-16 on 04/05/17.
 */

@RestController
@RequestMapping(value = "/coach")
public class CoachController {

    @Autowired
    CoachService coachService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Coach> addCoach(@Valid @RequestBody RegisterCoach coach){
        Coach newCoach = new Coach(coach.getName(), coach.getDateOfBirth(), coach.getEmail(), coach.getPassword(), coach.getPhone(), coach.getCpf(), coach.getAddress());

        return new ResponseEntity<>(coachService.create(newCoach), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getCoachs(){
        return new ResponseEntity<>(coachService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Coach> getCoach(@PathVariable("id") Long id){
        return new ResponseEntity<>(coachService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Coach> updateCoach(@Valid @RequestBody RegisterCoach coach){

        Coach newCoach = new Coach(coach.getName(), coach.getDateOfBirth(), coach.getEmail(), coach.getPassword(), coach.getPhone(), coach.getCpf(), coach.getAddress());
        return new ResponseEntity<>(coachService.update(newCoach), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCoach(@PathVariable("id") Long id){
        return new ResponseEntity(coachService.removeById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity deleteAll(){
        return new ResponseEntity(coachService.removeAll(), HttpStatus.OK);
    }
}
