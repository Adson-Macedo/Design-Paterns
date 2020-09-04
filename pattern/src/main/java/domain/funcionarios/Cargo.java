package domain.funcionarios;

import domain.Pessoa;

public abstract class Cargo {
    private Pessoa pessoa;

    public Cargo(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public abstract String getFuncao();

    public String getNome() {
        return pessoa.getNome();
    }

    public Integer getId() {
        return pessoa.getId();
    }

    public void setNome(String nome) {
        pessoa.setNome(nome);
    }

    public Pessoa getPessoa(){
        return this.pessoa;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCargo: " + getFuncao() + "\n";
    }
}
