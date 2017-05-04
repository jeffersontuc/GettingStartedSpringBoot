package br.edu.ufcg.embedded.model;

import br.edu.ufcg.embedded.model.enums.UserType;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by treinamento-16 on 04/05/17.
 */

@Entity
@Table
public class Student extends User{

    @OneToOne
    private Coach coach;

    public Student(String name, String dateOfBirth, String email, String password, String phone, String cpf, String address, Coach coach){

        super(name, dateOfBirth, email, password, phone, cpf, address, UserType.STUDENT);
        this.coach = new Coach();
    }

    public Student(String name, String dateOfBirth, String email, String password, String phone, String cpf, String address){
        super(name, dateOfBirth, email, password, phone, cpf, address, UserType.STUDENT);
    }

    public Student(){

    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
}
