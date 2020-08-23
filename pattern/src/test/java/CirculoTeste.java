import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Circulo;
import utils.Messages;
import utils.Utils;

public class CirculoTeste {

    @Test
    public void verificarCriacaoCirculo() throws Exception {
        Circulo r = new Circulo(2.5);
        assertEquals(r.getRaio(), 2.5);
    }

    @Test
    public void verificarCriacaoCirculoComRaioInvalido() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Circulo(0);
        });
        assertEquals(Messages.MSG_RAIO_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarCriacaoCirculoComRaioNegativo() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Circulo(-10);
        });
        assertEquals(Messages.MSG_RAIO_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarPerimetroDoCirculo() throws Exception {
        Circulo r = new Circulo(0.2);
        assertEquals(r.getPerimetro(), 2 * Utils.PI * 0.2);
    }

    @Test
    public void verificarAreaDoCirculo() throws Exception {
        Circulo r = new Circulo(4);
        assertEquals(r.getArea(), Utils.PI * 4 * 4);
    }

    @Test
    public void verificarToString() throws Exception {
        Circulo r = new Circulo(7);
        String msg = "O círculo criado tem raio de tamanho: 7.0";
        assertEquals(r.toString(), msg);
    }
}