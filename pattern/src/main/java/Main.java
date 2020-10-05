import domain.Circulo;
import domain.FiguraFactory;
import domain.Quadrado;
import domain.Triangulo;

public class Main {
    public static void main(String[] args) {
        Circulo c1 = FiguraFactory.getCirculoInstance(1.2);
        System.out.println(c1.toString());

        Circulo c2 = FiguraFactory.getCirculoInstance(5.6);
        System.out.println(c2.toString());

        Quadrado q1 = FiguraFactory.getQuadradoInstance(10);
        System.out.println(q1.toString());

        Quadrado q2 = FiguraFactory.getQuadradoInstance(15);
        System.out.println(q2.toString());

        Triangulo t1 = FiguraFactory.getTrianguloEquilateroInstance(15);
        System.out.println(t1.toString());

        Triangulo t2 = FiguraFactory.getTrianguloEquilateroInstance(19);
        System.out.println(t2.toString());

        Triangulo t3 = FiguraFactory.getTrianguloIsoscelesInstance(15, 56);
        System.out.println(t3.toString());

        Triangulo t4 = FiguraFactory.getTrianguloIsoscelesInstance(19, 15);
        System.out.println(t4.toString());

        Triangulo t5 = FiguraFactory.getTrianguloRetanguloInstance(15, 30);
        System.out.println(t5.toString());

        Triangulo t6 = FiguraFactory.getTrianguloRetanguloInstance(19, 25);
        System.out.println(t6.toString());
    }
}