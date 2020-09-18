import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sistemas.SistemaAdministrativo;

public class SistemaAdministrativoTeste {

    SistemaAdministrativo sistema = new SistemaAdministrativo();

    @Test
    public void validarAdicionarReuniao() {
        String resultadoEsperado = new String("{matricula: '001254', horario: '08:00 - 10:00'}");
        assertEquals(sistema.adicionarReuniao("001254", "08:00 - 10:00"), resultadoEsperado);
    }

    @Test
    public void validarAdicionarEntrevista() {
        String resultadoEsperado = new String("{nomeEntrevistado: 'Thairam Michel', horario: '15:30'}");
        assertEquals(sistema.adicionarEntrevista("Thairam Michel", "15:30"), resultadoEsperado);
    }

    @Test
    public void validarObterAgendaDeReunioes() {
        String resultadoEsperado = new String(
                "[{matricula: '12345678', horario: '00:00'},\n{matricula: '87654321', horario: '10:00'}]");
        assertEquals(sistema.obterAgendaDeReunioes(), resultadoEsperado);
    }

    @Test
    public void validarObterAgendaDeEntrevistas() {
        String resultadoEsperado = "[{nomeEntrevistado: 'Fulano de Tal', horario: '00:00'},\n{nomeEntrevistado: 'Tal de Fulano', horario: '10:00'}]";
        assertEquals(sistema.obterAgendaDeEntrevistas(), resultadoEsperado);
    }
}
