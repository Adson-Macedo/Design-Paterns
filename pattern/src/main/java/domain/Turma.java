package domain;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nomeTurma;
    private List<Aluno> alunos;
    private Horario horario;

    public Turma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
        this.alunos = new ArrayList<>();
        this.horario = new Horario();
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.adicionarHorario(horario);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public Horario getHorario() {
        return horario;
    }

    public List<String> getListaDeAlunos(){
        List<String> listaDeAlunos = new ArrayList<>();

        for (Aluno aluno : alunos) {
            listaDeAlunos.add(aluno.toString());
        }

        return listaDeAlunos;
    }

    public void adicionarAula(String diaDaSemana, String horarioDaAula, Disciplina disciplina) throws Exception{
        horario.addAula(horarioDaAula, diaDaSemana, disciplina);
    }
}