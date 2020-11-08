package model;

public class Passageiro {
    private static int contador = 0;
    private int id;
    private String nome;
    private String cpf;

    public Passageiro(String nome, String cpf) {
        this.id = ++contador;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Passageiro))
            return false;

        Passageiro passageiro = (Passageiro) obj;

        return this.getId() == passageiro.getId();
    }
}