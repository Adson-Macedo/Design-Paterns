import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Quadrado;

public class QuadradoTeste {

    @Test
    public void verificarCriacaoQuadrado() throws Exception {
        Quadrado quadrado = new Quadrado(150);
        assertEquals(quadrado.getLado(), 150);
    }

    @Test
    public void verificarPerimetroDoQuadrado() throws Exception {
        Quadrado quadrado = new Quadrado(12.5);
        assertEquals(quadrado.getPerimetro(), 50);
    }

    @Test
    public void verificarAreaDoQuadrado() throws Exception {
        Quadrado quadrado = new Quadrado(4.25);
        assertEquals(quadrado.getArea(), 18.0625);
    }
}