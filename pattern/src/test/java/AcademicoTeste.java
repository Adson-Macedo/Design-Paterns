import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import domain.Academico;
import domain.Disciplina;
import domain.Horario;

public class AcademicoTeste {

    Horario horario = new Horario();
    Disciplina disciplina1 = new Disciplina("MAP");
    Disciplina disciplina2 = new Disciplina("WEB");

    @Test
    public void verificarCriacaoAcademico() {
        Academico academico = new Academico("Maria das Dores Gonçalves", "121314159");

        assertEquals(academico.getNome(), "Maria das Dores Gonçalves");
        assertEquals(academico.getMatricula(), "121314159");
        assertEquals(academico.getHorarioAulas(), new ArrayList<>());
    }

    @Test
    public void verificarAdicaoDeHorario() throws Exception {
        Academico academico = new Academico("Maria das Dores Gonçalves", "121314159");
        horario.addAula("20:00", "Terça", disciplina1);

        academico.adicionarHorario(horario);

        assertEquals(academico.getHorarios().get(0).getAulas().get(0).getDiaDaSemana(), "Terça");
        assertEquals(academico.getHorarios().get(0).getAulas().get(0).getHorarioAula(), "20:00");
        assertEquals(academico.getHorarios().get(0).getAulas().get(0).getDisciplina().getDescricao(), "MAP");
    }

    @Test
    public void verificarToString() {
        Academico academico = new Academico("Maria das Dores Gonçalves", "121314159");
        assertEquals(academico.toString(), "Matricula: 121314159 Nome: Maria das Dores Gonçalves");
    }

    @Test
    public void verificarHorarioAulas() throws Exception {
        Academico academico = new Academico("Maria das Dores Gonçalves", "121314159");
        
        horario.addAula("20:00", "Terça", disciplina1);
        horario.addAula("18:00", "Terça", disciplina2);

        academico.adicionarHorario(horario);

        assertEquals(academico.getHorarioAulas().size(), 2);
        assertEquals(academico.getHorarioAulas().get(0), "Terça\t20:00\tMAP");
        assertEquals(academico.getHorarioAulas().get(1), "Terça\t18:00\tWEB");
    }
}