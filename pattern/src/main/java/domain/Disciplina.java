package domain;

import java.util.ArrayList;
import java.util.List;
import utils.Messages;

public class Disciplina {
    private static int contador = 1;

    private Integer id;
    private String descricao;
    private List<Turma> turmas;

    public Disciplina(String descricao) {
        this.id = contador++;
        this.descricao = descricao;
        this.turmas = new ArrayList<>();
    }

    private Turma getTurma(String nomeTurma) throws Exception{
        for (Turma turma : turmas) {
            if (turma.getNomeTurma().equals(nomeTurma)){
                return turma;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getId() {
        return id;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void criarTurma(String nomeTurma, Professor professor){
        Turma turma = new Turma(nomeTurma);

        this.turmas.add(turma);
        professor.adicionarHorario(turma.getHorario());
    }

    public void matricularAlunoNaTurma(Aluno aluno, String nomeTurma) throws Exception{
        Turma turma = getTurma(nomeTurma);
        turma.addAluno(aluno);
    }
    
    public void adicionarAulaATurma(String nomeTurma, String diaDaSemana, String horarioDaAula) throws Exception {
        Turma turma = getTurma(nomeTurma);
        turma.adicionarAula(diaDaSemana, horarioDaAula, this);
    }
}