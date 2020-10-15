package domain;

public class PaoIntegral implements PaoIF{

    @Override
    public String getTipoPao() {
        return "Fatia de Pao Integral";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PaoIntegral){
            return true;
        }else{
            return false;
        }
    }
}
