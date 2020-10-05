import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import domain.Circulo;

public class CirculoTeste {

    @Test
    public void verificarCriacaoCirculo() throws Exception {
        Circulo circulo = new Circulo(2.5);
        assertEquals(circulo.getRaio(), 2.5);
    }

    @Test
    public void verificarPerimetroDoCirculo() throws Exception {
        Circulo circulo = new Circulo(0.2);
        assertEquals(circulo.getPerimetro(), 2 * Math.PI * 0.2);
    }

    @Test
    public void verificarAreaDoCirculo() throws Exception {
        Circulo circulo = new Circulo(4);
        assertEquals(circulo.getArea(), Math.PI * 4 * 4);
    }
}