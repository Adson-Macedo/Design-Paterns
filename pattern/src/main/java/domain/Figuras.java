package domain;

import java.util.ArrayList;
import java.util.List;

import utils.Validation;

public class Figuras {
    private List<FiguraGeometrica> figuras;

    public Figuras() {
        this.figuras = new ArrayList<>();
    }

    public List<FiguraGeometrica> getFiguras() {
        return figuras;
    }

    public FiguraGeometrica get(int index) {
        return figuras.get(index);
    }

    public void adicionarRetangulo(int altura, int largura) throws Exception {
        this.figuras.add(new Retangulo(altura, largura));
    }

    public void adicionarQuadrado(int lado) throws Exception {
        this.figuras.add(new Quadrado(lado));
    }

    public void adicionarCirculo(double raio) throws Exception {
        this.figuras.add(new Circulo(raio));
    }

    public String getPerimetro(int index) throws Exception{
        Validation.validarIndex(index, figuras.size());
        return figuras.get(index).perimetroToString();
    }

    public String getArea(int index) throws Exception{
        Validation.validarIndex(index, figuras.size());
        return figuras.get(index).areaToString();
    }

    public String getDescricao(int index) throws Exception {
        Validation.validarIndex(index, figuras.size());
        return figuras.get(index).toString();
    }

    public List<String> getPerimetroDeTodasFiguras() {
        List<String> perimetros = new ArrayList<>();

        figuras.forEach(figura -> {
            perimetros.add("Tipo da figura: "
                    .concat(figura.getFigName())
                    .concat("; Perímetro: ")        
                    .concat(Double.toString(figura.getPerimetro()))
            );
        });

        return perimetros;
    }

    public List<String> getAreaDeTodasFiguras() {
        List<String> areas = new ArrayList<>();

        figuras.forEach(figura -> {
            areas.add("Tipo da figura: "
                    .concat(figura.getFigName())
                    .concat("; Área: ")        
                    .concat(Double.toString(figura.getArea()))
            );
        });

        return areas;
    }

}