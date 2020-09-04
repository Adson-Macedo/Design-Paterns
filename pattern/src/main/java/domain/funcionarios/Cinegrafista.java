package domain.funcionarios;

import domain.Pessoa;

public class Cinegrafista extends Cargo {
    public Cinegrafista(Pessoa pessoa){
        super(pessoa);
    }

    @Override
    public String getFuncao() {
        return "Cinegrafista";
    }
}
