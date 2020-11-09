import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Onibus;
import model.Passageiro;

public class OnibusTeste {

    Onibus onibus;

    @BeforeEach
    public void setUp() throws Exception {
        this.onibus = new Onibus(20, "CENTRO -> UEPB");
    }

    @Test
    public void verificarConstrutor() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Onibus(11, "LS -> CG");
        });
        assertEquals("Número de acentos precisa ser par", exception.getMessage());

        Exception exception2 = assertThrows(Exception.class, () -> {
            new Onibus(102, "LS -> CG");
        });
        assertEquals("Número de acentos precisa estar entre 2 e 98", exception2.getMessage());

        Onibus onibus = new Onibus(10, "LS -> CG");
        assertEquals(onibus.getAcentos().length, 10);
        assertEquals(onibus.getRota(), "LS -> CG");

    }

    @Test
    public void verificarReservarAcento() throws Exception {
        onibus.reservarAcento(1, new Passageiro("Thairam", "111.222.333-44"));
        assertEquals(onibus.getStatusAcentoTexto(1), "Reservado");
        assertEquals(onibus.getStatusAcentoTexto(2), "Disponível");
    }

    @Test
    public void verificarComprarAcento() throws Exception {
        onibus.comprarAcento(10, new Passageiro("Thairam", "111.222.333-44"));
        assertEquals(onibus.getStatusAcentoTexto(10), "Vendido");
        assertEquals(onibus.getStatusAcentoTexto(1), "Disponível");
    }

    @Test
    public void verificarCancelarReserva() throws Exception {
        onibus.reservarAcento(1, new Passageiro("Thairam", "111.222.333-44"));
        assertEquals(onibus.getStatusAcentoTexto(1), "Reservado");

        onibus.cancelarReserva(1);
        assertEquals(onibus.getStatusAcentoTexto(1), "Disponível");
    }

    @Test
    public void verificarComprarPassagemReservada() throws Exception {
        Passageiro passageiro = new Passageiro("Thairam", "111.222.333-44");

        onibus.reservarAcento(1, passageiro);
        assertEquals(onibus.getStatusAcentoTexto(1), "Reservado");

        onibus.comprarAcento(1, passageiro);
        assertEquals(onibus.getStatusAcentoTexto(1), "Vendido");
    }
}