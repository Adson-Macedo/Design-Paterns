import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.TrianguloIsosceles;

public class TrianguloIsoscelesTeste {

    @Test
    public void verificarCriacaoTrianguloIsosceles() throws Exception {
        TrianguloIsosceles triangulo = new TrianguloIsosceles(2.5, 3);
        assertEquals(triangulo.getLado(), 3);
    }

    @Test
    public void verificarPerimetroDoTrianguloIsosceles() throws Exception {
        TrianguloIsosceles triangulo = new TrianguloIsosceles(1.2, 2.2);
        assertEquals(triangulo.getPerimetro(), (2 * 2.2 + 1.2), 0.001);
    }

    @Test
    public void verificarAlturaDoTrianguloIsosceles() throws Exception {
        TrianguloIsosceles triangulo = new TrianguloIsosceles(2, 2);
        assertEquals(triangulo.getAltura(), (Math.sqrt(3)), 0.001);
    }
}
