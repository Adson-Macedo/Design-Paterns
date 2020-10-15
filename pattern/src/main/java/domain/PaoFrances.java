package domain;

public class PaoFrances implements PaoIF{

    @Override
    public String getTipoPao() {
        return "Fatia de Pao Frances";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PaoFrances){
            return true;
        }else{
            return false;
        }
    }
}