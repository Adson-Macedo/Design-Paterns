package domain;

import domain.funcionarios.Cargo;
import java.util.List;
import java.util.ArrayList;

public class Filme {
    private Integer id;
    private static int CONT = 0;
    private List<Cargo> elenco;
    private List<String> trilhaSonora;
    private String nome;
    private Integer ano;

    public Filme(String nome, Integer ano) {
        this.id = CONT++;
        this.nome = nome;
        this.ano = ano;
        this.elenco = new ArrayList<Cargo>();
        this.trilhaSonora = new ArrayList<>();
    }

    public List<String> toStrings() {
        List<String> strings = new ArrayList<>();

        strings.add("O Filme: " + this.nome + ", lançado em: " + this.ano);
        strings.add("\nElenco:");

        for (Cargo cargo : this.elenco) {
            strings.add(cargo.toString());
        }

        strings.add("Trilha Sonora: ");

        for (String trilha : this.trilhaSonora) {
            strings.add(trilha);
        }

        return strings;
    }

    public void addTrilha(String trilha) {
        this.trilhaSonora.add(trilha);
    }

    public Integer getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public String getNome() {
        return nome;
    }

    public void setElenco(List<Cargo> elenco) {
        this.elenco = elenco;
    }

    public List<Cargo> getElenco() {
        return elenco;
    }

    public List<String> getTrilhaSonora() {
        return trilhaSonora;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Filme)) {
            return false;
        }

        return ((Filme) obj).id == this.id;
    }
}