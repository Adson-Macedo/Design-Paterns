package domain;

public abstract class FiguraGeometrica {
    protected String figName;

    public abstract double getPerimetro();
    public abstract double getArea();
    public abstract String toString();
    
    public String getFigName(){
        return this.figName;
    }
    
    public String perimetroToString(){
        return "O perímetro do "
            .concat(getFigName())
            .concat(" é: ")
            .concat(Double.toString(getPerimetro()));
    }
    
    public String areaToString(){
        return "A área deste "
            .concat(getFigName())
            .concat(" é: ")
            .concat(Double.toString(getArea()));
    }
}