package domain;

import java.util.List;

public class Aluno extends Pessoa {

    public Aluno(String nome, String matricula) {
        super(nome, matricula);
    }

    public List<Horario> getRdm() {
        return this.horarios;
    }

}