import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import domain.Aluno;
import domain.Disciplina;
import domain.Professor;

import utils.Messages;

public class DisciplinaTeste {

    Professor professor = new Professor("Sabrina", "12345678");

    @Test
    public void verificarCriacaoDisciplina() {
        Disciplina disciplina = new Disciplina("MAP");
        assertEquals(disciplina.getDescricao(), "MAP");
        assertEquals(disciplina.getTurmas(), new ArrayList<>());
    }

    @Test
    public void verificarCriacaoDeTurmaDaDisciplina() {
        Disciplina disciplina = new Disciplina("MAP");

        disciplina.criarTurma("Comp-Noturno", professor);
        assertEquals(disciplina.getTurmas().get(0).getNomeTurma(), "Comp-Noturno");
    }

    @Test
    public void verificarMatriculaDeAlunoNaTurma() throws Exception {
        Disciplina disciplina = new Disciplina("MAP");
        disciplina.criarTurma("Comp-Noturno", professor);
        disciplina.matricularAlunoNaTurma(new Aluno("Thairam", "0000001"), "Comp-Noturno");

        assertEquals(disciplina.getTurmas().get(0).getAlunos().get(0).getNome(), "Thairam");
    }

    @Test
    public void verificarAdicaoDeAulaATurma() throws Exception {
        Disciplina disciplina = new Disciplina("MAP");
        disciplina.criarTurma("Comp-Noturno", professor);
        disciplina.adicionarAulaATurma("Comp-Noturno", "Terça", "20:00");

        assertEquals(disciplina.getTurmas().get(0).getHorario().getAulas().get(0).getDiaDaSemana(), "Terça");
        assertEquals(disciplina.getTurmas().get(0).getHorario().getAulas().get(0).getHorarioAula(), "20:00");

    }

    @Test
    public void verificarAdicaoDeAulaAUmaTurmaQueNaoFoiRegistrada() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Disciplina disciplina = new Disciplina("MAP");
            disciplina.adicionarAulaATurma("Comp-Noturno", "Terça", "20:00");
        });
        assertEquals(Messages.MSG_NOT_FOUND_EXCEPTION, exception.getMessage());
    }

    @Test
    public void verificarMatriculaDeAlunoAUmaTurmaQueNaoFoiRegistrada() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            Disciplina disciplina = new Disciplina("MAP");
            disciplina.matricularAlunoNaTurma(new Aluno("Thairam", "0000001"), "Comp-Noturno");
        });
        assertEquals(Messages.MSG_NOT_FOUND_EXCEPTION, exception.getMessage());
    }
}