package sistemas;

public class SistemaControleAcademico {
    public SistemaControleAcademico() {

    }

    public String criarAluno(String matricula, String nome) {
        return "{matricula: '" + matricula + "', nome: '" + nome + "'}";
    }

    public String criarProfessor(String matricula, String nome, String dataDeAdmissao) {
        return "{matricula: '" + matricula + "', nome: '" + nome + "', dataAdmissao: '" + dataDeAdmissao + "'}";
    }

    public String criarDisciplina(String descricao) {
        return "{id: 1, descricao: '" + descricao + "'}";
    }

    public String obterHistoricoDoAluno(String matriculaAluno) {
        return "{matriculaAluno:  '" + matriculaAluno + "', historico: [...]}";
    }

    public String obterRdmDoAluno(String matriculaAluno) {
        return "{matriculaAluno: '" + matriculaAluno + "', rdm: [...]}";
    }

    public String alocarProfessorParaDisciplina(String matriculaProfessor, int idDisciplina) {
        return "{professor: '" + matriculaProfessor + "', idDisciplinaMinistrada: '" + idDisciplina + "'}";
    }

    public String obterDisciplinasDoProfessor(String matriculaProfessor) {
        return "{{id: 1, descricao: 'disciplina1'}, {id: 5, descricao: 'discplina5'}}";
    }

    public String obterTempoDeCasaDoProfessor(String matriculaProfessor) {
        return "{tempo: 750}";
    }

}
