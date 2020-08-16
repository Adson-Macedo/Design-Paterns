package driver;

import java.util.List;

import domain.*;

public class Main {
    public static void main(String[] args) {
        ControleAcademico ca = new ControleAcademico();
        
        ca.criarAluno("Adson Macedo", "161085270");
        ca.criarAluno("Thairam Michel", "000000000");
        ca.criarProfessor("Sabrina Souto", "12345678");
        ca.criarProfessor("Toin", "87654321");
        ca.criarDisciplina("MAP");
        ca.criarDisciplina("IHC");

        try {
            ca.criarTurma("Noturno", "MAP", "12345678");
            System.out.println(ca.getDisciplina("MAP").getTurmas().size());

            ca.adicionarAula("MAP", "Noturno", "Terça", "18:00");
            ca.matricularAluno("161085270", "MAP", "Noturno");
            ca.adicionarAula("MAP", "Noturno", "Domingo", "20:00");

            
            Professor p1 = ca.getProfessor("12345678");
            
            System.out.println("Horario de " + p1.toString());
            List<String> horario1 = p1.getHorarioAulas();
            for (String h : horario1) {
                System.out.println(h);
            }
            
            List<String> alunos = ca.getAlunosDaDisciplina("MAP");
            for (String aluno : alunos) {
                System.out.println(aluno);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}