import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import sistemas.SistemaAdministrativo; 

public class SistemaAdministrativoTeste {

    SistemaAdministrativo sistemaAdm = new SistemaAdministrativo();

    @Test
    public void validarAdicionarReuniao() {
        String matricula = "0012";
        String horario = "08:00 - 10:00";
        
        String reuniao = sistemaAdm.adicionarReuniao(matricula, horario);
        assertEquals(reuniao, "{matricula: '" + matricula + "', horario: '" + horario + "'"+ "}");
    }

    @Test
    public void validarAdicionarEntrevista() {
        String nomeEntrevistado = "Thairam Michel";
        String horario = "15:30";
        
        String reuniao = sistemaAdm.adicionarEntrevista(nomeEntrevistado, horario);
        assertEquals(reuniao, "{nomeEntrevistado: '" + nomeEntrevistado + "', horario: '" + horario + "'"+ "}");
    }    

    @Test
    public void validarObterAgendaDeReunioes() {
        String resultadoEsperado = "[{matricula: '12345678', horario: '00:00'},\n{matricula: '87654321', horario: '10:00'}]";
        assertEquals(sistemaAdm.obterAgendaDeReunioes() , resultadoEsperado);
    }        

    @Test
    public void validarObterAgendaDeEntrevistas() {
        String resultadoEsperado = "[{nomeEntrevistado: 'Fulano de Tal', horario: '00:00'},\n{nomeEntrevistado: 'Tal de Fulano', horario: '10:00'}]";
        assertEquals(sistemaAdm.obterAgendaDeEntrevistas() , resultadoEsperado);
    }            
}
