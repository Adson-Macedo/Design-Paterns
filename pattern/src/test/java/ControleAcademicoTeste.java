import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        ControleAcademico ca = new ControleAcademico();

        ca.criarAluno("Adson", "123456789");
        ca.criarDisciplina("MAP");
        
        assertThrows(Exception.class, () -> {
            ca.criarTurma("Noturno", "MAP", "123456789");
        });
    }


}