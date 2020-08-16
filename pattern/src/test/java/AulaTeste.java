import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import domain.Aula;
import domain.Disciplina;
import utils.Messages;

public class AulaTeste {

    Disciplina disciplina = new Disciplina("MAP");

    @Test
    public void verificarCriacaoDaAula() throws Exception {
        Aula aula = new Aula("20:00", "Terça", disciplina);

        assertEquals(aula.getHorarioAula(), "20:00");
        assertEquals(aula.getDiaDaSemana(), "Terça");
    }

    @Test
    public void verificarCriacaoDaAulaComDiaDaSemanaInválido() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Aula("20:00", "palavra", disciplina);
        });
        assertEquals(Messages.MSG_DIA_DA_SEMANA_INVALIDO_EXCEPTION, exception.getMessage());
    }

    @Test
    public void verificarCriacaoDaAulaComHorarioInválido() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Aula("24:00", "Terça", disciplina);
        });
        assertEquals(Messages.MSG_FORMATO_DE_HORARIO_INVALIDO_EXCEPTION, exception.getMessage());
    }

    @Test
    public void verificarToString() throws Exception {
        Aula aula = new Aula("18:00", "Quinta", disciplina);
        assertEquals(aula.toString(), "Quinta\t18:00\tMAP");
    }    
}