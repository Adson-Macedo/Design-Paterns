package domain;

import java.util.ArrayList;
import java.util.List;

public class Academico {
    private static int contador = 1;

    private final Integer id;
    private String nome;
    private String matricula;
    protected List<Horario> horarios;

    public Academico(final String nome, final String matricula) {
        this.id = contador++;

        this.nome = nome;
        this.matricula = matricula;
        this.horarios = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setMatricula(final String matricula) {
        this.matricula = matricula;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public void adicionarHorario(final Horario horario) {
        this.horarios.add(horario);
    }

    public String toString(){
        return "Matricula: " + this.matricula + " Nome: " + this.nome;
    }

    private Horario getHorarioGeral() {
        Horario horarioTotal = new Horario();

        for (Horario horario : horarios) {
            horarioTotal.concat(horario);
        }

        return horarioTotal;
    }

    public List<String> getHorarioAulas(){
        Horario horarioGeral = getHorarioGeral();

        return horarioGeral.toStrings();
    }

    public List<Horario> getHorarios() {
        return horarios;
    }
}