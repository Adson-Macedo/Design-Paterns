package driver;

import domain.Produtora;

public class Main {
    
    public static void main(String[] args) {
        Produtora prod = new Produtora();
        
        prod.criarFilme("A volta dos que não foram", 2020);
        prod.criarFilme("O cortador de papel", 2020);
        prod.adicionarTrilhaSonoraAoFilme(0, "Lágrimas de um jumento apaixonado");
        
        prod.criarPessoa("Adson Macêdo");
        prod.criarPessoa("Thairam Michel");
        
        prod.adicionarAtorAoFilme(0, 0);        //  Adson ator A volta dos que não foram
        prod.adicionarDiretorAoFilme(0, 1);     //  Adson ator O cortador de papel
        prod.adicionarDiretorAoFilme(0, 0);     //  Adson diretor A volta dos que não foram
        prod.adicionarRoteiristaAoFilme(1, 0);  //  Thairam Roteirista A volta dos que não foram
        
        
        int idFilme = 0;
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


    }
}
