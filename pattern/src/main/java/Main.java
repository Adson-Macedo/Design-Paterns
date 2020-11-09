import controller.Rodoviaria;

public class Main {

    public static void main(String[] args) {
        Rodoviaria rodoviaria = Rodoviaria.getInstace();
        
        try{
            rodoviaria.adicionarPassageiro("Adson Macedo", "012345678910");
            rodoviaria.adicionarOnibus(8, "LS - CG");
            rodoviaria.adicionarOnibus(10, "LS - CG");
            rodoviaria.adicionarPainel();
            rodoviaria.adicionarPainel();

            rodoviaria.adicionarQuiosque();
            rodoviaria.adicionarQuiosque();
            
            rodoviaria.addListenerTo(100001, 1);
            rodoviaria.addListenerTo(100002, 2);
            
            rodoviaria.addListenerTo(200001, 1);
            rodoviaria.addListenerTo(200002, 1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            rodoviaria.reservarPassagem(1, 6, "012345678910");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            rodoviaria.reservarPassagem(2, 4, "012345678910");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            rodoviaria.reservarPassagem(1, 3, "012345678910");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            rodoviaria.comprarPassagem(1, 1, "012345678910");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            rodoviaria.comprarPassagem(1, 1, "012345678910");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            rodoviaria.comprarPassagem(2, 4, "012345678910");
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