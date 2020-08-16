package driver;

import java.util.List;

import domain.*;

public class Main {
    private static ControleAcademico ca = new ControleAcademico();

    private static void criarAlunos() {
        //  Criando alguns Alunos
        ca.criarAluno("Adson Macedo", "161085270");
        ca.criarAluno("Thairam Michel", "000000000");
        ca.criarAluno("Ramon Rodrigues", "111111111");
        ca.criarAluno("Joaozinho", "888888888");
    }

    private static void criarProfessores() {
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarProfessor("Toin", "987654321");
        ca.criarProfessor("Heron Aragão", "222222222");
    }

    private static void criarDisciplinas() {
        ca.criarDisciplina("MAP");
        ca.criarDisciplina("Discreta I");
        ca.criarDisciplina("Logica");
    }

    private static void criarTurmas() throws Exception{
        ca.criarTurma("Diurno", "MAP", "123456789");        //  Sabrina
        ca.adicionarAula("MAP", "Diurno", "Quarta", "11:00");
        ca.adicionarAula("MAP", "Diurno", "Segunda", "09:00");

        ca.criarTurma("Noturno", "MAP", "123456789");       //  Sabrina
        ca.adicionarAula("MAP", "Noturno", "Quarta", "20:00");
        ca.adicionarAula("MAP", "Noturno", "Sexta", "18:00");

        ca.criarTurma("Diurno", "Discreta I", "987654321"); //  Toin
        ca.adicionarAula("Discreta I", "Diurno", "Quarta", "10:00");
        ca.adicionarAula("Discreta I", "Diurno", "Segunda", "08:00");
        
        ca.criarTurma("Diurno", "Logica", "987654321");     //  Toin
        ca.adicionarAula("Logica", "Diurno", "Terça", "09:00");
        ca.adicionarAula("Logica", "Diurno", "Quinta", "11:00");
        
        ca.criarTurma("Noturno", "Logica", "222222222");    //  Heron
        ca.adicionarAula("Logica", "Noturno", "Terça", "18:00");
        ca.adicionarAula("Logica", "Noturno", "Quinta", "20:00");
    }

    public static void matricularAlunos() throws Exception {
        ca.matricularAluno("161085270", "MAP", "Noturno");          // Adson
        ca.matricularAluno("161085270", "Logica", "Noturno");       // Adson

        ca.matricularAluno("000000000", "MAP", "Noturno");          // Thairam
        ca.matricularAluno("000000000", "Logica", "Noturno");       // Thairam
        ca.matricularAluno("000000000", "Discreta I", "Diurno");    // Thairam

        ca.matricularAluno("111111111", "Logica", "Noturno");       // Ramon
        
        ca.matricularAluno("888888888", "Logica", "Diurno");        // Joaozinho
        ca.matricularAluno("888888888", "MAP", "Diurno");           // Joaozinho
        ca.matricularAluno("888888888", "Discreta I", "Diurno");    // Joaozinho
    }

    public static void mostrarDisciplinasDoProfessor(String matriculaProfessor) {
        try {
            List<String> disciplinasDoProfessor = ca.getDisciplinasDoAcademico(matriculaProfessor);
            
            System.out.println("====================================");
            System.out.println("Disciplinas ministradas por: " + ca.getProfessor(matriculaProfessor).getNome());
            for (String disciplina : disciplinasDoProfessor) {
                System.out.println(disciplina);
            }
            System.out.println("====================================\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarDisciplinasDoAluno(String matriculaAluno) {
        try {
            List<String> disciplinasDoAluno = ca.getDisciplinasDoAcademico(matriculaAluno);
            
            System.out.println("====================================");
            System.out.println("Disciplinas cursadas por: " + ca.getAluno(matriculaAluno).getNome());
            for (String disciplina : disciplinasDoAluno) {
                System.out.println(disciplina);
            }
            System.out.println("====================================\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarHorario(String matricula) {
        try {
            List<String> horarioAulas = ca.getHorarioAulas(matricula);
            
            System.out.println("====================================");
            System.out.println("Horario de aulas de: " + ca.getAcademico(matricula).getNome());
            for (String horario : horarioAulas) {
                System.out.println(horario);
            }
            System.out.println("====================================\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarAlunosDaDisciplina(String nomeDisciplina) {
        try {
            List<String> alunos = ca.getAlunosDaDisciplina(nomeDisciplina);
            
            System.out.println("====================================");
            System.out.println("Alunos matriculados em: " + ca.getDisciplina(nomeDisciplina).getDescricao());
            for (String aluno : alunos) {
                System.out.println(aluno);
            }
            System.out.println("====================================\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarNumeroAlunosDaDisciplina(String nomeDisciplina) {
        try {
            int numAlunos = ca.getAlunosDaDisciplina(nomeDisciplina).size();
            
            System.out.println("====================================");
            System.out.println("Número de alunos matriculados em: " + ca.getDisciplina(nomeDisciplina).getDescricao());
            System.out.println(numAlunos);
            System.out.println("====================================\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        //  Criando entidades principais do sistema
        criarAlunos();
        criarProfessores();
        criarDisciplinas();

        //  Associando alunos, professores e disciplinas
        try {
            criarTurmas();
            matricularAlunos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //  Respondendo as perguntas
        //  a) Quais disciplinas um professor esta ministrando?
        mostrarDisciplinasDoProfessor("987654321");
        
        //  b) Qual o horário de um professor?
        mostrarHorario("987654321");
        
        //  c) Quais os alunos de uma dada disciplina?
        mostrarAlunosDaDisciplina("Discreta I");

        //  d) Quais as disciplinas de um aluno?
        mostrarDisciplinasDoAluno("111111111");
        
        //  e) Qual o horário de um aluno?
        mostrarHorario("000000000");
        
        //  f) Qual o número de alunos de uma disciplina?
        mostrarNumeroAlunosDaDisciplina("Discreta I");

        System.out.println("Fim da Execução!");
    }
}