package domain;

import java.util.ArrayList;
import java.util.List;
import domain.funcionarios.*;

public class Produtora {
    private List<Pessoa> pessoas;
    private List<Filme> filmes;
    private List<Atuacao> atuacoes;

    public Produtora() {
        this.pessoas = new ArrayList<>();
        this.filmes = new ArrayList<>();
        this.atuacoes = new ArrayList<>();
    }

    public void criarFilme(String nome, Integer ano) {
        this.filmes.add(new Filme(nome, ano));
    }

    public void criarPessoa(String nome) {
        this.pessoas.add(new Pessoa(nome));
    }

    public void adicionarAtorAoFilme(Integer idPessoa, Integer idFilme) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        Filme filme = buscarFilmePeloId(idFilme);

        atuacoes.add(new Atuacao(new Ator(pessoa), filme));
    }

    public void adicionarCameraAoFilme(Integer idPessoa, Integer idFilme) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        Filme filme = buscarFilmePeloId(idFilme);

        atuacoes.add(new Atuacao(new Camera(pessoa), filme));
    }

    public void adicionarCinegrafistaAoFilme(Integer idPessoa, Integer idFilme) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        Filme filme = buscarFilmePeloId(idFilme);

        atuacoes.add(new Atuacao(new Cinegrafista(pessoa), filme));
    }

    public void adicionarDiretorAoFilme(Integer idPessoa, Integer idFilme) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        Filme filme = buscarFilmePeloId(idFilme);

        atuacoes.add(new Atuacao(new Diretor(pessoa), filme));
    }

    public void adicionarRoteiristaAoFilme(Integer idPessoa, Integer idFilme) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);
        Filme filme = buscarFilmePeloId(idFilme);

        atuacoes.add(new Atuacao(new Roteirista(pessoa), filme));
    }

    public Pessoa buscarPessoaPeloId(Integer id) {
        return pessoas.get(id);
    }

    public Filme buscarFilmePeloId(Integer id) {
        return filmes.get(id);
    }

    public List<String> getFilmografiaDaPessoa(Integer idPessoa) {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);

        List<String> filmografia = new ArrayList<>();

        atuacoes.forEach(atuacao -> {
            if (atuacao.getCargo().getId() == pessoa.getId()){
                filmografia.add(atuacao.toString());
            }
        });

        return filmografia;
    }

    public List<String> getCaracteriticasDoFilme(Integer idFilme) {
        Filme filme = buscarFilmePeloId(idFilme);
        return filme.toStrings();
    }
    
    public void adicionarTrilhaSonoraAoFilme(Integer idFilme, String trilhaSonora){
        Filme filme = buscarFilmePeloId(idFilme);
        filme.addTrilha(trilhaSonora);
    }
}
