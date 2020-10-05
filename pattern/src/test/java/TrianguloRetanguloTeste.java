import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.TrianguloRetangulo;

public class TrianguloRetanguloTeste {

    @Test
    public void verificarCriacaoTrianguloRetangulo() throws Exception {
        TrianguloRetangulo triangulo = new TrianguloRetangulo(2.5, 3);
        assertEquals(triangulo.getAltura(), 3);
    }

    @Test
    public void verificarHipotenusaDoTrianguloRetangulo() throws Exception {
        TrianguloRetangulo triangulo = new TrianguloRetangulo(4, 3);
        assertEquals(triangulo.getHipotenusa(), 5, 0.001);
    }

    @Test
    public void verificarPerimetroDoTrianguloRetangulo() throws Exception {
        TrianguloRetangulo triangulo = new TrianguloRetangulo(4, 3);
        assertEquals(triangulo.getPerimetro(), 12, 0.001);
    }

    @Test
    public void verificarAlturaDoTrianguloRetangulo() throws Exception {
        TrianguloRetangulo triangulo = new TrianguloRetangulo(2, 2.9);
        assertEquals(triangulo.getAltura(), 2.9);
    }
}
