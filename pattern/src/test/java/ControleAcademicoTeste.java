import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.*;
// import utils.Messages;

public class ControleAcademicoTeste {
    public ControleAcademico ca;

    @BeforeEach
    public void setup() {
        ca = new ControleAcademico();
    }

    @Test
    public void verificarCriarAluno() throws Exception{
        ca.criarAluno("Joaozinho", "123456");
        assertEquals(ca.getAluno("123456").getNome(), "Joaozinho");
    }   

    @Test
    public void verificarCriarProfessor() throws Exception{
        ca.criarProfessor("Sabrina", "123456");
        assertEquals(ca.getProfessor("123456").getNome(), "Sabrina");
    }

    @Test
    public void verificarProfessorInexistente() throws Exception{
        ca.criarAluno("Sabrina", "123456");
        assertThrows(Exception.class, () -> {
            ca.getProfessor("123456").getNome();
        }); 
    }

    @Test
    public void verificarCriarDisciplina() throws Exception{
        ControleAcademico ca = new ControleAcademico();

        ca.criarDisciplina("MAP");
        assertEquals(ca.getDisciplina("MAP").getDescricao(), "MAP");
    }

    @Test
    public void verificarCriarTurma() throws Exception{
        ControleAcademico ca = new ControleAcademico();

        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarDisciplina("MAP");
        ca.criarTurma("Noturno", "MAP", "123456789");

        assertEquals(ca.getDisciplina("MAP").getTurmas().get(0).getNomeTurma(), "Noturno");
    }

    @Test
    public void verificarCriarTurmaParaDisciplinaInexistente() throws Exception{
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarDisciplina("MAP");
        
        assertThrows(Exception.class, () -> {
            ca.criarTurma("Noturno", "IHC", "123456789");
        });
    }

    @Test
    public void verificarCriarTurmaComAlunoMinistrando() throws Exception{
        ca.criarAluno("Adson", "123456789");
        ca.criarDisciplina("MAP");
        
        assertThrows(Exception.class, () -> {
            ca.criarTurma("Noturno", "MAP", "123456789");
        });
    }

    @Test
    public void verificarMatricularAluno() throws Exception{
        ca.criarAluno("Adson", "123456789");
        ca.criarDisciplina("MAP");
        
        assertThrows(Exception.class, () -> {
            ca.criarTurma("Noturno", "MAP", "123456789");
        });
    }

    @Test
    public void verificarAdicionarAula() throws Exception {
        ca.criarDisciplina("MAP");
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarTurma("Noturno","MAP", "123456789");
        ca.adicionarAula("MAP", "Noturno", "Segunda", "00:00");

        Aula aula = new Aula("00:00", "Segunda", ca.getDisciplina("MAP"));
        List<Aula> aulas = ca.getDisciplina("MAP").getTurmas().get(0).getHorario().getAulas();
        

        assertEquals(aulas.get(0).getDiaDaSemana(), aula.getDiaDaSemana());
        assertEquals(aulas.get(0).getHorarioAula(), aula.getHorarioAula());
    }

    @Test
    public void verificarGetHorarioAulas() throws Exception {
        ca.criarDisciplina("MAP");
        ca.criarDisciplina("Estruturas de Dados");
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarTurma("Noturno","MAP", "123456789");
        ca.criarTurma("Noturno","Estruturas de Dados", "123456789");
        ca.adicionarAula("MAP", "Noturno", "Segunda", "20:00");
        ca.adicionarAula("MAP", "Noturno", "Quinta", "20:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Segunda", "18:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Quarta", "18:00");

        List<String> horarioAulas = ca.getHorarioAulas("123456789");
        
        assertEquals(horarioAulas.get(0), "Segunda\t18:00\tEstruturas de Dados");
        assertEquals(horarioAulas.get(1), "Segunda\t20:00\tMAP");
        assertEquals(horarioAulas.get(2), "Quarta\t18:00\tEstruturas de Dados");
        assertEquals(horarioAulas.get(3), "Quinta\t20:00\tMAP");
    }

    @Test
    public void verificarGetAlunosDaDisciplina() throws Exception {
        ca.criarDisciplina("MAP");
        ca.criarDisciplina("Estruturas de Dados");
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarAluno("Adson", "1111111111");
        ca.criarAluno("Thairam", "2222222222");
        
        ca.criarTurma("Noturno","MAP", "123456789");
        ca.criarTurma("Noturno","Estruturas de Dados", "123456789");
        
        ca.adicionarAula("MAP", "Noturno", "Segunda", "20:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Segunda", "18:00");
        
        ca.matricularAluno("1111111111", "MAP", "Noturno");
        ca.matricularAluno("1111111111", "Estruturas de Dados", "Noturno");
        ca.matricularAluno("2222222222", "Estruturas de Dados", "Noturno");

        List<String> alunos = ca.getAlunosDaDisciplina("Estruturas de Dados");
        
        assertEquals(alunos.get(0), "Matricula: 1111111111 Nome: Adson");
        assertEquals(alunos.get(1), "Matricula: 2222222222 Nome: Thairam");
    }

    @Test
    public void verificarGetDisciplinasDoAcademico() throws Exception {
        ca.criarDisciplina("MAP");
        ca.criarDisciplina("Estruturas de Dados");
        ca.criarDisciplina("Discreta I");
        
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarProfessor("Toin", "000000000");
        
        ca.criarAluno("Adson", "1111111111");
        ca.criarAluno("Thairam", "2222222222");
        
        ca.criarTurma("Noturno","MAP", "123456789");
        ca.criarTurma("Noturno","Estruturas de Dados", "123456789");
        ca.criarTurma("Noturno","Discreta I", "000000000");
        
        ca.adicionarAula("MAP", "Noturno", "Segunda", "18:00");
        ca.adicionarAula("MAP", "Noturno", "Quarta", "20:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Quarta", "18:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Quarta", "18:00");
        ca.adicionarAula("Discreta I", "Noturno", "Quinta", "18:00");
        ca.adicionarAula("Discreta I", "Noturno", "Terça", "20:00");

        ca.matricularAluno("1111111111", "MAP", "Noturno");
        ca.matricularAluno("1111111111", "Estruturas de Dados", "Noturno");
        ca.matricularAluno("2222222222", "Discreta I", "Noturno");

        List<String> disciplinas = ca.getDisciplinasDoAcademico("1111111111");
        assertEquals(disciplinas.get(0), "Estruturas de Dados");
        assertEquals(disciplinas.get(1), "MAP");
    }

    @Test
    public void verificarGetNumeroDisciplinasAcademico() throws Exception {
        ca.criarDisciplina("MAP");
        ca.criarDisciplina("Estruturas de Dados");
        ca.criarDisciplina("Discreta I");
        
        ca.criarProfessor("Sabrina Souto", "123456789");
        ca.criarProfessor("Toin", "000000000");
        
        ca.criarAluno("Adson", "1111111111");
        ca.criarAluno("Thairam", "2222222222");
        
        ca.criarTurma("Noturno","MAP", "123456789");
        ca.criarTurma("Noturno","Estruturas de Dados", "123456789");
        ca.criarTurma("Noturno","Discreta I", "000000000");
        
        ca.adicionarAula("MAP", "Noturno", "Segunda", "18:00");
        ca.adicionarAula("MAP", "Noturno", "Quarta", "20:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Quarta", "18:00");
        ca.adicionarAula("Estruturas de Dados", "Noturno", "Quarta", "18:00");
        ca.adicionarAula("Discreta I", "Noturno", "Quinta", "18:00");
        ca.adicionarAula("Discreta I", "Noturno", "Terça", "20:00");

        ca.matricularAluno("1111111111", "MAP", "Noturno");
        ca.matricularAluno("1111111111", "Estruturas de Dados", "Noturno");
        ca.matricularAluno("2222222222", "Discreta I", "Noturno");

        assertEquals(ca.getDisciplinasDoAcademico("1111111111").size(), 2);
        assertEquals(ca.getDisciplinasDoAcademico("000000000").size(), 1);
    }
}