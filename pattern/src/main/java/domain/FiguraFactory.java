package domain;

/**
 * FiguraFactory
 */
public abstract class FiguraFactory {
    private static Circulo circulo;
    private static TrianguloEquilatero trianguloEquilatero;
    private static TrianguloIsosceles trianguloIsosceles;
    private static TrianguloRetangulo trianguloRetangulo;

    public static Quadrado getQuadradoInstance(double lado) {
        return new Quadrado(lado);
    }

    public static Circulo getCirculoInstance(double raio) {
        if (circulo == null) {
            circulo = new Circulo(raio);
        }

        return circulo;
    }

    public static TrianguloEquilatero getTrianguloEquilateroInstance(double lado) {
        if (trianguloEquilatero == null) {
            trianguloEquilatero = new TrianguloEquilatero(lado);
        }

        return trianguloEquilatero;
    }

    public static TrianguloRetangulo getTrianguloRetanguloInstance(double base, double altura) {
        if (trianguloRetangulo == null) {
            trianguloRetangulo = new TrianguloRetangulo(base, altura);
        }

        return trianguloRetangulo;
    }

    public static TrianguloIsosceles getTrianguloIsoscelesInstance(double base, double lado) {
        if (trianguloIsosceles == null) {
            trianguloIsosceles = new TrianguloIsosceles(base, lado);
        }

        return trianguloIsosceles;
    }

}