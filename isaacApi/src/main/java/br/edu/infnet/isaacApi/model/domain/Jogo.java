package br.edu.infnet.isaacApi.model.domain;

import br.edu.infnet.isaacApi.model.enumerator.Genero;

public class Jogo {

    Integer id;

    String nome;
    Double preco;
    Integer clasificacaoIndicativa;
    boolean acessoAntecipado;
    Genero genero;


    public Jogo() {
    }

    public Jogo(String nome, Double preco, Integer clasificacaoIndicativa, Boolean acessoAntecipado, Genero genero) {
        this.nome = nome;
        this.preco = preco;
        this.clasificacaoIndicativa = clasificacaoIndicativa;
        this.acessoAntecipado = acessoAntecipado;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s " +
                "| Preco: R$%.2f " +
                "| Classificação indicativa: +%d " +
                "| Acesso antecipado: %b " +
                "| Genero: %s",
                nome,preco,clasificacaoIndicativa,acessoAntecipado,String.valueOf(genero));
    }

    public Integer getClasificacaoIndicativa() {
        return clasificacaoIndicativa;
    }

    public void setClasificacaoIndicativa(Integer clasificacaoIndicativa) {
        this.clasificacaoIndicativa = clasificacaoIndicativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Boolean getAcessoAntecipado() {
        return acessoAntecipado;
    }

    public void setAcessoAntecipado(Boolean acessoAntecipado) {
        this.acessoAntecipado = acessoAntecipado;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
