package domain;

public class Recheio {
    private OvoIF ovo;
    private QueijoIF queijo;
    private PresuntoIF presunto;
    private TomateIF tomate;

    public Recheio(){
        this.ovo = new SemOvo();
        this.queijo = new SemQueijo();
        this.presunto = new SemPresunto();
        this.tomate = new SemTomate();
    }

    public String getDescricaoRecheio(){
        return String.join("\n", 
            ovo.getTipoOvo(), 
            queijo.getTipoQueijo(),
            presunto.getTipoPresunto(),
            tomate.getTipoTomate()
        );
    }

    public void setOvo(OvoIF ovo) {
        this.ovo = ovo;
    }

    public void setQueijo(QueijoIF queijo) {
        this.queijo = queijo;
    }

    public void setPresunto(PresuntoIF presunto) {
        this.presunto = presunto;
    }

    public void setTomate(TomateIF tomate) {
        this.tomate = tomate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Recheio){
            Recheio recheio = (Recheio) obj;
            return  recheio.ovo.getClass().equals(this.ovo.getClass()) &&
                    recheio.presunto.getClass().equals(this.presunto.getClass()) &&
                    recheio.queijo.getClass().equals(this.queijo.getClass()) &&
                    recheio.tomate.getClass().equals(this.tomate.getClass());
        }
        return false;
    }
}
