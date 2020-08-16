import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Aluno;
import domain.Disciplina;
import domain.Turma;

public class TurmaTeste {

    Aluno aluno1 = new Aluno("Thairam", "0000001");
    Aluno aluno2 = new Aluno("Adson", "0000002");

    Disciplina disciplina = new Disciplina("MAP");

    @Test
    public void verificarCriacaoTurma() {
        Turma turma = new Turma("Noturno");

        assertEquals(turma.getNomeTurma(), "Noturno");
        assertEquals(turma.getAlunos(), new ArrayList<>());
        assertEquals(turma.getHorario().getAulas(), new ArrayList<>());
    }

    @Test
    public void verificarTurmaComAluno() {
        Turma turma = new Turma("Noturno");
        turma.addAluno(aluno1);
        turma.addAluno(aluno2);

        List<String> alunos = new ArrayList<>();
        alunos.add(aluno1.toString());
        alunos.add(aluno2.toString());

        assertEquals(turma.getListaDeAlunos(), alunos);
    }

    @Test
    public void verificarTurmaComAula() throws Exception {
        Turma turma = new Turma("Noturno");
        turma.adicionarAula("Terça", "20:00", disciplina);

        List<String> aulas = new ArrayList<>();
        aulas.add("Terça\t20:00\tMAP");

        assertEquals(turma.getHorario().getAulas().toString(), aulas.toString());
    }
}