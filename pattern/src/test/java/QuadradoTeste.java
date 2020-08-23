import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Quadrado;
import utils.Messages;

public class QuadradoTeste {

    @Test
    public void verificarCriacaoQuadrado() throws Exception {
        Quadrado r = new Quadrado(150);
        assertEquals(r.getLado(), 150);
    }

    @Test
    public void verificarCriacaoQuadradoComLadoInvalido() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Quadrado(0);
        });
        assertEquals(Messages.MSG_LADO_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarCriacaoQuadradoComLadoNegativo() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            new Quadrado(-10);
        });
        assertEquals(Messages.MSG_LADO_INVALIDO, exception.getMessage());
    }

    @Test
    public void verificarPerimetroDoQuadrado() throws Exception {
        Quadrado r = new Quadrado(12);
        assertEquals(r.getPerimetro(), 48);
    }

    @Test
    public void verificarAreaDoQuadrado() throws Exception {
        Quadrado r = new Quadrado(4);
        assertEquals(r.getArea(), 16);
    }

    @Test
    public void verificarToString() throws Exception {
        Quadrado r = new Quadrado(11);
        String msg = "O quadrado criado tem lados de tamanho: 11";
        assertEquals(r.toString(), msg);
    }
}