package domain;

public class PaoBola implements PaoIF{

    @Override
    public String getTipoPao() {
        return "Fatia de Pao Bola";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PaoBola){
            return true;
        }else{
            return false;
        }
    }
}
