package domain;

public class Pessoa {
    private static int CONT = 0;
    private Integer id;
    private String nome;

    public Pessoa(String nome){
        this.id = CONT++;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pessoa)) {
            return false;
        }

        return ((Pessoa) obj).id == this.id;
    }    
}
