package domain;

public class XTudao extends Sanduiche{
    @Override
    public Recheio montaRecheio(){
        Recheio recheio = new Recheio();

        recheio.setOvo(new OvoDeCapoeira());
        recheio.setPresunto(new PresuntoDePeru());
        recheio.setQueijo(new QueijoPrato());
        recheio.setTomate(new Tomate());

        return recheio;
    }

    @Override
    public PaoIF criaFatiaDePao(){
        return new PaoBola();
    }
}
