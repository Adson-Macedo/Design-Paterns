package driver;

import domain.Figuras;

public class Main {
    public static void main(String[] args) {
        Figuras fig = new Figuras();

        try {
            fig.adicionarRetangulo(10, 5);
            fig.adicionarQuadrado(7);
            fig.adicionarCirculo(25);
            fig.adicionarCirculo(15);
            fig.adicionarRetangulo(8, 9);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("Perímetros: ");
        try {
            System.out.println(fig.getPerimetro(0)); 
            System.out.println(fig.getPerimetro(2)); 
            System.out.println(fig.getPerimetro(1));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println("\nÁreas: ");
        try {
            System.out.println(fig.getArea(0)); 
            System.out.println(fig.getArea(2)); 
            System.out.println(fig.getArea(1));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("\nDescrições das Figuras: ");
        try {
            System.out.println(fig.getDescricao(0)); 
            System.out.println(fig.getDescricao(2)); 
            System.out.println(fig.getDescricao(1));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("\nÁreas das Figuras: ");
        fig.getAreaDeTodasFiguras().forEach(area -> {
            System.out.println(area); 
        });

        System.out.println("\nPerímetros das Figuras: ");
        fig.getPerimetroDeTodasFiguras().forEach(perimetro -> {
            System.out.println(perimetro); 
        });


    }
}