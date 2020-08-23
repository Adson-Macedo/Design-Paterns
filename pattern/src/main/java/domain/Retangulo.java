package domain;

import utils.Validation;

public class Retangulo extends FiguraGeometrica {
    private int altura;
    private int largura;

    public Retangulo(int altura, int largura) throws Exception{
        Validation.validarAltura(altura);
        Validation.validarLargura(largura);
        
        this.altura = altura;
        this.largura = largura;
        this.figName = "retângulo";
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setAltura(int altura) throws Exception{
        Validation.validarAltura(altura);
        this.altura = altura;
    }
    
    public void setLargura(int largura) throws Exception{
        Validation.validarAltura(largura);
        this.largura = largura;
    }

    @Override
    public double getPerimetro(){
        return 2 * (altura+largura);
    }

    @Override
    public double getArea(){
        return altura * largura;
    }

    @Override
    public String toString(){
        return "O retângulo criado tem altura de tamanho: "
            .concat(Integer.toString(this.altura))
            .concat(" e largura de tamanho: ")
            .concat(Integer.toString(this.largura));
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Retangulo)){
            return false;
        }
        Retangulo ret = (Retangulo) obj;
        return (ret.altura == this.altura) && (ret.largura == this.largura);
    }
}