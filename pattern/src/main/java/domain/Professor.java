package domain;

import java.util.List;

public class Professor extends Pessoa {
    public Professor(String nome, String matricula){
        super(nome, matricula);
    }

    public List<Horario> getHorarios() {
        return this.horarios;
    }

}