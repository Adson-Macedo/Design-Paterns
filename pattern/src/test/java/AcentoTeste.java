import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Acento;
import model.Passageiro;

public class AcentoTeste {
    int DISPONIVEL = 0;
    int RESERVADO = 1;
    int VENDIDO = 2;

    Acento acento;

    @BeforeEach
    public void setUp() {
        this.acento = new Acento();
    }

    @Test
    public void verificarConstrutor() {
        Acento acento = new Acento();
        assertTrue(acento.getId() > 0);
        assertEquals(acento.getStatus(), DISPONIVEL);
        assertEquals(acento.getPassageiro(), null);
    }

    @Test
    public void verificarReservar() throws Exception {
        acento.reservar(new Passageiro("Thairam", "111.222.333-44"));
        assertEquals(acento.getStatus(), RESERVADO);
    }

    @Test
    public void verificarComprar() throws Exception {
        acento.comprar(new Passageiro("Thairam", "111.222.333-44"));
        assertEquals(acento.getStatus(), VENDIDO);
    }

    @Test
    public void verificarCancelarReserva() throws Exception {
        acento.reservar(new Passageiro("Thairam", "111.222.333-44"));
        assertEquals(acento.getStatus(), RESERVADO);

        acento.cancelarReserva();
        assertEquals(acento.getStatus(), DISPONIVEL);
    }

    @Test
    public void verificarReservarException() throws Exception {
        acento.reservar(new Passageiro("Thairam", "111.222.333-44"));

        Exception exception = assertThrows(Exception.class, () -> {
            acento.reservar(new Passageiro("Thairam", "111.222.333-44"));
        });

        assertEquals("Não foi possível realizar a reserva: acento já reservado ou vendido!", exception.getMessage());
    }

    @Test
    public void verificarComprarException() throws Exception {
        acento.reservar(new Passageiro("Thairam", "111.222.333-44"));

        Exception exception = assertThrows(Exception.class, () -> {
            acento.comprar(new Passageiro("Adson", "555.666.777-88"));
        });

        assertEquals("Não foi possível realizar a venda: acento reservado/vendido para outro passageiro!",
                exception.getMessage());
    }

    @Test
    public void verificarCancelarException() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            acento.cancelarReserva();
        });

        assertEquals("Não foi possível cancelar a reserva: acento não reservado ou vendido", exception.getMessage());
    }
}
