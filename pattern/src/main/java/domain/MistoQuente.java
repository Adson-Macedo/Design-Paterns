package domain;

public class MistoQuente extends Sanduiche{
    @Override
    public Recheio montaRecheio(){
        Recheio recheio = new Recheio();

        recheio.setPresunto(new PresuntoDeFrango());
        recheio.setQueijo(new QueijoMussarela());

        return recheio;
    }

    @Override
    public PaoIF criaFatiaDePao(){
        return new PaoIntegral();
    }
    
}
