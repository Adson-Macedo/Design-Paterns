package sistemas;

public class SistemaControleAcademico {
    public SistemaControleAcademico(){

    }

    public String criarAluno(String matricula, String nome){
        return "Matricula: " + matricula + "; Nome: " + nome;
    }
    
    public String criarProfessor(String matricula, String nome, String dataDeAdmissao){
        return "Matricula: " + matricula + "; Nome: " + nome + "; Data de Admissao: " + dataDeAdmissao;
    }

    public String criarDisciplina(String descricao){
        return "Disciplina " + descricao;
    }

    public String obterHistoricoDoAluno(String matriculaAluno){
        return "Historico do aluno " + matriculaAluno + "...";
    }

    public String obterRdmDoAluno(String matriculaAluno){
        return "RDM do aluno " + matriculaAluno + "...";
    }

    public String alocarProfessorParaDisciplina(String matriculaProfessor, int idDisciplina){
        return "Professor " + matriculaProfessor + " ministra disciplina de id = " + idDisciplina;
    }


}
