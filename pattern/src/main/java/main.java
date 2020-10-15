import domain.MistoQuente;
import domain.Sanduiche;
import domain.XTudao;

public class Main {
    public static void main(String[] args) {
        Sanduiche s1 = new Sanduiche();
        System.out.println("------DESCRICAO DO SANDUICHE--------");
        System.out.println(s1.getDescricaoSanduiche());
        System.out.println("------------------------------------");
        
        Sanduiche s2 = new MistoQuente();
        System.out.println("-----DESCRICAO DO MISTO QUENTE------");
        System.out.println(s2.getDescricaoSanduiche());
        System.out.println("------------------------------------");

        Sanduiche s3 = new XTudao();
        System.out.println("--------DESCRICAO DO X-TUDAO--------");
        System.out.println(s3.getDescricaoSanduiche());
        System.out.println("------------------------------------");
    }
}