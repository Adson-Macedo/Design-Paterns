package domain;

public class Sanduiche {
    private PaoIF fatiaPaoSuperior;
    private PaoIF fatiaPaoInferior;
    private Recheio recheio;

    public Sanduiche(){
        this.fatiaPaoInferior = criaFatiaDePao();
        this.fatiaPaoSuperior = criaFatiaDePao();
        this.recheio = montaRecheio();        
    }

    public Recheio montaRecheio(){
        Recheio recheio = new Recheio();

        recheio.setOvo(new OvoDeGranja());

        return recheio;
    }

    public PaoIF criaFatiaDePao(){
        return new PaoFrances();
    }
    
    public String getDescricaoSanduiche(){
        return String.join("\n", 
            fatiaPaoSuperior.getTipoPao(), 
            recheio.getDescricaoRecheio(), 
            fatiaPaoInferior.getTipoPao()
        );
    }
}
