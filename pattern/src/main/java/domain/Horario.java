package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Horario {
    private Set<Aula> aulas;

    public Horario() {
        this.aulas = new TreeSet<>();
    }

    public void addAula(String horario, String diaDaSemana, Disciplina disciplina) throws Exception{
        this.aulas.add(new Aula(horario, diaDaSemana, disciplina));
    }

    public List<Aula> getAulas() {
        return new ArrayList<>(aulas);
    }

    public List<String> toStrings(){
        List<String> strings = new ArrayList<>();

        for (Aula aula : aulas) {
            strings.add(aula.toString());
        }

        return strings;
    }

    protected void concat(Horario horario) {
        this.aulas.addAll(horario.getAulas());
    }
}