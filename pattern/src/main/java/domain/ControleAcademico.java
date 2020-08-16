package domain;

import java.util.ArrayList;
import java.util.List;
import utils.Messages;

public class ControleAcademico {
    private List<Disciplina> disciplinas;
    private List<Pessoa> pessoas;

    public ControleAcademico(){
        this.disciplinas = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public Disciplina getDisciplina(int id) throws Exception{
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Disciplina getDisciplina(String descricao) throws Exception{
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getDescricao().equals(descricao)) {
                return disciplina;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Aluno getAluno(int id) throws Exception{
        for (Pessoa pessoa : pessoas) {
            if ((pessoa instanceof Aluno) && (pessoa.getId() == id)) {
                return (Aluno) pessoa;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Aluno getAluno(String matricula) throws Exception{
        for (Pessoa pessoa : this.pessoas) {
            if ((pessoa instanceof Aluno) && (pessoa.getMatricula().equals(matricula))) {
                return (Aluno) pessoa;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Professor getProfessor(int id) throws Exception{
        for (Pessoa pessoa : pessoas) {
            if ((pessoa instanceof Professor) && (pessoa.getId() == id)) {
                return (Professor) pessoa;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Professor getProfessor(String matricula) throws Exception{
        for (Pessoa pessoa : pessoas) {
            if ((pessoa instanceof Professor) && (pessoa.getMatricula().equals(matricula))) {
                return (Professor) pessoa;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public void criarDisciplina(String descricao){
        this.disciplinas.add(new Disciplina(descricao));
    }
    
    public void criarAluno(String nome, String matricula){
        this.pessoas.add(new Aluno(nome, matricula));
    }

    public void criarProfessor(String nome, String matricula){
        this.pessoas.add(new Professor(nome, matricula));
    }

    public void criarTurma(String nomeTurma, String nomeDisciplina, String matriculaProfessor) throws Exception{
        Disciplina disciplina = getDisciplina(nomeDisciplina);
        Professor professor = getProfessor(matriculaProfessor);
        
        disciplina.criarTurma(nomeTurma, professor);
    }
    
    public List<String> getAlunosDaDisciplina(String nomeDisciplina) throws Exception{
        Disciplina disciplina = getDisciplina(nomeDisciplina);

        List<String> alunos = new ArrayList<>();
        
        for (Turma turma : disciplina.getTurmas()){
            alunos.addAll(turma.getListaDeAlunos());
        }

        return alunos;
    }

    public void matricularAluno(String matriculaAluno, String nomeDisciplina, String nomeTurma) throws Exception{
        Aluno aluno = getAluno(matriculaAluno);
        Disciplina disciplina = getDisciplina(nomeDisciplina);
        
        disciplina.matricularAlunoNaTurma(aluno, nomeTurma);
    }
    
    public void adicionarAula(String nomeDisciplina, String nomeTurma, String diaDaSemana, String horarioDaAula) throws Exception{
        Disciplina disciplina = getDisciplina(nomeDisciplina);

        disciplina.adicionarAulaATurma(nomeTurma, diaDaSemana, horarioDaAula);
    }
}