import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Disciplina;
import domain.Horario;

public class HorarioTeste {

    Disciplina disciplina = new Disciplina("MAP");

    @Test
    public void verificarCriacaoHorario() {
        Horario horario = new Horario();

        assertEquals(horario.getAulas(), new ArrayList<>());
    }

    @Test
    public void verificarHorarioToStrings() throws Exception {
        Horario horario = new Horario();

        List<String> aulasHorario = new ArrayList<>();
        aulasHorario.add("Terça\t20:00\tMAP");
        aulasHorario.add("Quinta\t18:00\tMAP");

        horario.addAula("20:00", "Terça", disciplina);
        horario.addAula("18:00", "Quinta", disciplina);

        assertEquals(horario.toStrings(), aulasHorario);
    }
}