import domain.*;

public class Main {

    public static void main(String[] args) {
        Circulo c1 = new Circulo(10);
        Retangulo r1 = new Retangulo(10, 30);
        Trapezio t1 = new Trapezio(10, 10, 30);
        Triangulo tr = new Triangulo(4, 3);

        VisitorCalcularArea area = new VisitorCalcularArea();
        VisitorCalcularPerimetro perimetro = new VisitorCalcularPerimetro();
        VisitorDesenhar desenhar = new VisitorDesenhar();
        VisitorMaximizarFigura maximizar = new VisitorMaximizarFigura();

        System.out.println("***************************************");
        System.out.println("Área do círculo: " + c1.aceitaVisita(area));
        System.out.println("Perímetro do círculo: " + c1.aceitaVisita(perimetro));
        System.out.println(c1.aceitaVisita(desenhar));
        c1.aceitaVisita(maximizar);
        System.out.println("Novo raio do círculo: " + c1.getRaio());
        System.out.println("***************************************");

        System.out.println("Área do retângulo: " + r1.aceitaVisita(area));
        System.out.println("Perímetro do retêngulo: " + r1.aceitaVisita(perimetro));
        System.out.println(r1.aceitaVisita(desenhar));
        r1.aceitaVisita(maximizar);
        System.out.println("Nova altura do retângulo: " + r1.getAltura());
        System.out.println("Nova largura do retângulo: " + r1.getLargura());
        System.out.println("***************************************");

        System.out.println("Área do trapézio: " + t1.aceitaVisita(area));
        System.out.println("Perímetro do trapézio: " + t1.aceitaVisita(perimetro));
        System.out.println(t1.aceitaVisita(desenhar));
        t1.aceitaVisita(maximizar);

        System.out.println("Nova altura do trapézio: " + t1.getAltura());
        System.out.println("Nova Base Menor do trapézio: " + t1.getBaseMenor());
        System.out.println("Nova Base Maior do trapézio: " + t1.getBaseMaior());
        System.out.println("***************************************");

        System.out.println("Área do triângulo: " + tr.aceitaVisita(area));
        System.out.println("Perímetro do triângulo: " + tr.aceitaVisita(perimetro));
        System.out.println(tr.aceitaVisita(desenhar));
        tr.aceitaVisita(maximizar);
        System.out.println("Nova altura do triângulo: " + tr.getAltura());
        System.out.println("Nova base do triângulo: " + tr.getBase());
        System.out.println("***************************************");
    }
}