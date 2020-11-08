import controller.Rodoviaria;

public class Main {

    public static void main(String[] args) {
        Rodoviaria rodoviaria = Rodoviaria.getInstace();

        try{
            rodoviaria.adicionarOnibus(20, "LS - CG");
            rodoviaria.adicionarPainel();
            rodoviaria.adicionarQuiosque();
            rodoviaria.addListenerTo(100001, 1);
            rodoviaria.addListenerTo(200001, 1);
            rodoviaria.adicionarPassageiro("Adson Macedo", "012345678910");
            rodoviaria.reservarPassagem(1, 11, "012345678910");
            rodoviaria.reservarPassagem(1, 14, "012345678910");
            rodoviaria.comprarPassagem(1, 1, "012345678910");
            rodoviaria.comprarPassagem(1, 1, "012345678910");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

/*
+---------------+
|  |01 03 05 07 |
|               |
|M |02 04 06 08 |
+---------------+
*/