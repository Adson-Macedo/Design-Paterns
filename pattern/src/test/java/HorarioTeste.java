import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Disciplina;
import domain.Horario;

public class HorarioTeste {

    Disciplina disciplina1 = new Disciplina("MAP");
    Disciplina disciplina2 = new Disciplina("WEB");
    Disciplina disciplina3 = new Disciplina("IHC");

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

        horario.addAula("20:00", "Terça", disciplina1);
        horario.addAula("18:00", "Quinta", disciplina1);

        assertEquals(horario.toStrings(), aulasHorario);
    }

    @Test
    public void verificarOrdenacaoHorario() throws Exception {
        Horario horario = new Horario();
        
        horario.addAula("20:00", "Terça", disciplina1);
        horario.addAula("18:00", "Quinta", disciplina1);
        
        horario.addAula("20:00", "Segunda", disciplina2);
        horario.addAula("20:00", "Sexta", disciplina2);
        
        horario.addAula("18:00", "Segunda", disciplina3);
        horario.addAula("18:00", "Quarta", disciplina3);
    
        assertEquals(horario.getAulas().size(), 6);
        
        assertEquals(horario.getAulas().get(0).toString(), "Segunda\t18:00\tIHC");
        assertEquals(horario.getAulas().get(1).toString(), "Segunda\t20:00\tWEB");
        
        assertEquals(horario.getAulas().get(2).toString(), "Terça\t20:00\tMAP");
        assertEquals(horario.getAulas().get(3).toString(), "Quarta\t18:00\tIHC");
        
        assertEquals(horario.getAulas().get(4).toString(), "Quinta\t18:00\tMAP");
        assertEquals(horario.getAulas().get(5).toString(), "Sexta\t20:00\tWEB");
    }

    @Test
    public void verificarHorarioDuplicado() throws Exception {
        Horario horario = new Horario();
        
        horario.addAula("18:00", "Terça", disciplina2);
        
        // Duplicação de horários
        horario.addAula("20:00", "Terça", disciplina1);
        horario.addAula("20:00", "Terça", disciplina1);
    
        assertEquals(horario.getAulas().size(), 2);
        assertEquals(horario.getAulas().get(0).toString(), "Terça\t18:00\tWEB");
        assertEquals(horario.getAulas().get(1).toString(), "Terça\t20:00\tMAP");
    }
}