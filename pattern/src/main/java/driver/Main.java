package driver;

import domain.Sig;

public class Main {
    public static void main(String[] args) {
        Sig sig = new Sig();

        String entrevistado = "Thairam";
        
        System.out.println(sig.agendarEntrevista(entrevistado, "12:00"));

    }
}