import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import static domain.FiguraFactory.getQuadradoInstance;
import static domain.FiguraFactory.getCirculoInstance;
import static domain.FiguraFactory.getTrianguloEquilateroInstance;
import static domain.FiguraFactory.getTrianguloIsoscelesInstance;
import static domain.FiguraFactory.getTrianguloRetanguloInstance;

import domain.Circulo;
import domain.Quadrado;
import domain.TrianguloEquilatero;
import domain.TrianguloIsosceles;
import domain.TrianguloRetangulo;

public class FiguraFactoryTeste {

    @Test
    public void verificarInstanciasQuadrado() {
        Quadrado q1 = getQuadradoInstance(1);
        Quadrado q2 = getQuadradoInstance(2);

        assertNotEquals(q1, q2);
    }

    @Test
    public void verificarInstanciasCirculo() {
        Circulo c1 = getCirculoInstance(1);
        Circulo c2 = getCirculoInstance(2);

        assertEquals(c1, c2);
        assertEquals(c1.getRaio(), 1);
    }

    @Test
    public void verificarInstanciasTrianguloEquilatero() {
        TrianguloEquilatero t1 = getTrianguloEquilateroInstance(1);
        TrianguloEquilatero t2 = getTrianguloEquilateroInstance(2);

        assertEquals(t1, t2);
        assertEquals(t1.getPerimetro(), 3);
    }

    @Test
    public void verificarInstanciasTrianguloIsosceles() {
        TrianguloIsosceles t1 = getTrianguloIsoscelesInstance(1, 2);
        TrianguloIsosceles t2 = getTrianguloIsoscelesInstance(3, 4);

        assertEquals(t1, t2);
        assertEquals(t1.getPerimetro(), 5);
    }

    @Test
    public void verificarInstanciasTrianguloRetangulo() {
        TrianguloRetangulo t1 = getTrianguloRetanguloInstance(1, 2);
        TrianguloRetangulo t2 = getTrianguloRetanguloInstance(3, 4);

        assertEquals(t1, t2);
        assertEquals(t1.getAltura(), 2);
    }
}
