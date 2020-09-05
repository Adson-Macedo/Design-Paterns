package driver;

import domain.Produtora;

public class Main {
    
    public static void main(String[] args) {
        Produtora prod = new Produtora();
        
        prod.criarFilme("A volta dos que não foram", 1960);
        prod.criarFilme("O cortador de papel", 2020);
        prod.criarFilme("Fulga de álcool atrás", 1998);
        prod.criarFilme("Bradock", 1980);

        prod.adicionarTrilhaSonoraAoFilme(0, "Lágrimas de um jumento apaixonado");
        prod.adicionarTrilhaSonoraAoFilme(2, "Eguinha pocotó");
        prod.adicionarTrilhaSonoraAoFilme(0, "Não sei se vou ou se fico");
        prod.adicionarTrilhaSonoraAoFilme(1, "Ilarilariê");
        prod.adicionarTrilhaSonoraAoFilme(1, "Garçom");
        prod.adicionarTrilhaSonoraAoFilme(3, "Caneta Azul");
        
        prod.criarPessoa("Adson Macêdo");
        prod.criarPessoa("Thairam Michel");
        prod.criarPessoa("Ramon Rodrigues");
        prod.criarPessoa("Arnaldo Chuarnega");
        prod.criarPessoa("Janclodivandame");
        prod.criarPessoa("Jimmy Cliff");
        prod.criarPessoa("Wesley Snipes");
        
        prod.adicionarAtorAoFilme(0, 0);        
        prod.adicionarAtorAoFilme(3, 0);        
        prod.adicionarDiretorAoFilme(0, 0);     
        prod.adicionarRoteiristaAoFilme(1, 0); 
        
        prod.adicionarDiretorAoFilme(0, 1);     
        prod.adicionarAtorAoFilme(4, 1);     
        prod.adicionarAtorAoFilme(3, 1);     
        
        
        int idFilme = 0;
        System.out.println("============================================");
        prod.getCaracteriticasDoFilme(idFilme).forEach(string -> {
            System.out.println(string);
        });
        System.out.println("============================================");
        
        int idPessoa = 0;
        System.out.println("Filmografia de " + prod.buscarPessoaPeloId(idPessoa).getNome());
        prod.getFilmografiaDaPessoa(idPessoa).forEach(string -> {
            System.out.println("\n" + string);
        });
        System.out.println("============================================");
        System.out.println("Fim da execução");

    }
}
