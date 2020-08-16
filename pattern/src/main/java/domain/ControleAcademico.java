package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Messages;

public class ControleAcademico {
    private List<Disciplina> disciplinas;
    private List<Academico> academicos;

    public ControleAcademico(){
        this.disciplinas = new ArrayList<>();
        this.academicos = new ArrayList<>();
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

    public Academico getAcademico(int id) throws Exception {
        for (Academico academico : academicos) {
            if (academico.getId() == id) {
                return academico;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Academico getAcademico(String matricula) throws Exception{
        for (Academico academico : this.academicos) {
            if (academico.getMatricula().equals(matricula)) {
                return academico;
            }
        }

        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Aluno getAluno(int id) throws Exception{
        Academico aluno = getAcademico(id);
        
        if (aluno instanceof Aluno){
            return (Aluno) aluno;
        }        
        
        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Aluno getAluno(String matricula) throws Exception{
        Academico aluno = getAcademico(matricula);
        
        if (aluno instanceof Aluno){
            return (Aluno) aluno;
        }        
        
        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Professor getProfessor(int id) throws Exception{
        Academico professor = getAcademico(id);
        
        if (professor instanceof Professor){
            return (Professor) professor;
        }        
        
        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public Professor getProfessor(String matricula) throws Exception{
        Academico professor = getAcademico(matricula);
        
        if (professor instanceof Professor){
            return (Professor) professor;
        }        
        
        throw new Exception(Messages.MSG_NOT_FOUND_EXCEPTION);
    }

    public void criarDisciplina(String descricao){
        this.disciplinas.add(new Disciplina(descricao));
    }
    
    public void criarAluno(String nome, String matricula){
        this.academicos.add(new Aluno(nome, matricula));
    }

    public void criarProfessor(String nome, String matricula){
        this.academicos.add(new Professor(nome, matricula));
    }

    public void criarTurma(String nomeTurma, String nomeDisciplina, String matriculaProfessor) throws Exception{
        Disciplina disciplina = getDisciplina(nomeDisciplina);
        Professor professor = getProfessor(matriculaProfessor);
        
        disciplina.criarTurma(nomeTurma, professor);
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
    
    public List<String> getHorarioAulas(String matriculaAcademico) throws Exception{
        Academico academico = getAcademico(matriculaAcademico);
        return academico.getHorarioAulas();
    }

    public List<String> getAlunosDaDisciplina(String nomeDisciplina) throws Exception{
        Disciplina disciplina = getDisciplina(nomeDisciplina);

        List<String> alunos = new ArrayList<>();
        
        for (Turma turma : disciplina.getTurmas()){
            alunos.addAll(turma.getListaDeAlunos());
        }

        return alunos;
    }

    public List<String> getDisciplinasDoAcademico(String matricula) throws Exception {
        Set<String> disciplinas = new TreeSet<String>();

        Academico Academico = getAcademico(matricula);

        for (Horario horario : Academico.getHorarios()) {
            for (Aula aula : horario.getAulas()) {
                disciplinas.add(aula.getDisciplina().getDescricao());
            }
        }

        return new ArrayList<>(disciplinas);
    }

    public Integer getNumeroDisciplinasAcademico(String matricula) throws Exception {
        return getDisciplinasDoAcademico(matricula).size();
    }
}