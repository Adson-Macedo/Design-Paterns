package domain;

import domain.funcionarios.Cargo;

public class Atuacao {
    private Cargo cargo;
    private Filme filme;

    public Atuacao(Cargo cargo, Filme filme) {
        this.cargo = cargo;
        this.filme = filme;

        filme.getElenco().add(cargo);
    }

    public void setFuncionario(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Filme getFilme() {
        return filme;
    }

    @Override
    public String toString(){
        return "Filme: " + filme.getNome() + "\nCargo: " + cargo.getFuncao();
    }
}
