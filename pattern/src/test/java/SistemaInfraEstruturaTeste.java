import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sistemas.SistemaInfraEstrutura;

public class SistemaInfraEstruturaTeste {
    SistemaInfraEstrutura sistema = new SistemaInfraEstrutura();

    @Test
    public void validarCriarSala() {
        String resultadoEsperado = new String("{id: '0235', numero: '0125', andar: '10'}");
        assertEquals(sistema.criarSala(), resultadoEsperado);
    }

    @Test
    public void validarAlocarAtividadeParaSala() {
        String resultadoEsperado = new String(
                "{sala: '14', numero: '0057', andar: '4', atividade: 'reuniões', horário: '08:00 - 18:00', dia: 'segunda-feira'}");
        assertEquals(sistema.alocarAtividadeParaSala(14, "reuniões", "08:00 - 18:00", "segunda-feira"), resultadoEsperado);
    }

    @Test
    public void validarObterHorariosDaSala() {
        String resultadoEsperado = new String("{idSala: '15', numero: '0024', andar: '1', horarios: [...]}");
        assertEquals(sistema.obterHorariosDaSala(15), resultadoEsperado);
    }

    @Test
    public void validarObterSalasComHorarioDisponivel() {
        String resultadoEsperado = new String("[{ sala: '0011', andar: '1', horarios: [...] }, { sala: '0055', andar: '3', horarios: [...] }]");
        assertEquals(sistema.obterSalasComHorarioDisponivel(), resultadoEsperado);
    }
}
