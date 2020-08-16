package domain;

import java.util.ArrayList;
import java.util.List;

public class Horario {
    private List<Aula> aulas;

    public Horario() {
        this.aulas = new ArrayList<>();
    }

    public void addAula(String horario, String diaDaSemana, Disciplina disciplina) throws Exception{
        this.aulas.add(new Aula(horario, diaDaSemana, disciplina));
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public List<String> toStrings(){
        List<String> strings = new ArrayList<>();

        for (Aula aula : aulas) {
            strings.add(aula.toString());
        }

        return strings;
    }
}