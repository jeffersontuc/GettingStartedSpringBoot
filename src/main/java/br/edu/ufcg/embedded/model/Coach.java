package br.edu.ufcg.embedded.model;

import br.edu.ufcg.embedded.model.enums.UserType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by treinamento-16 on 04/05/17.
 */

@Entity
@Table
public class Coach extends User {

    public Coach(String name, String dateOfBirth, String email, String password, String phone, String cpf, String address){
        super(name, dateOfBirth, email, password, phone, cpf, address, UserType.COACH);
    }

    public Coach(){

    }
}
