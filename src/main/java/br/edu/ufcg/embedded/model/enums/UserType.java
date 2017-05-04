package br.edu.ufcg.embedded.model.enums;

/**
 * Created by treinamento-16 on 04/05/17.
 */
public enum UserType {

    COACH("COACH"), STUDENT("STUDENT");

    private String type;

    UserType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
