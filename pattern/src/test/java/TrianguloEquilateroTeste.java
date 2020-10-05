import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.TrianguloEquilatero;

public class TrianguloEquilateroTeste {

    @Test
    public void verificarCriacaoTrianguloEquilatero() throws Exception {
        TrianguloEquilatero triangulo = new TrianguloEquilatero(2.5);
        assertEquals(triangulo.getBase(), 2.5);
    }

    @Test
    public void verificarPerimetroDoTrianguloEquilatero() throws Exception {
        TrianguloEquilatero triangulo = new TrianguloEquilatero(1.2);
        assertEquals(triangulo.getPerimetro(), 3.60, 0.001);
    }

    @Test
    public void verificarAlturaDoTrianguloEquilatero() throws Exception {
        TrianguloEquilatero triangulo = new TrianguloEquilatero(4);
        assertEquals(triangulo.getAltura(), (4 * Math.sqrt(3) / 2), 0.001);
    }
}