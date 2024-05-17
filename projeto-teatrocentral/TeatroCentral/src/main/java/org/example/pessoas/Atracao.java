package org.example.pessoas;

public class Atracao {
    private String nome;
    private double cache;
    private String descricao;
    private int numDeIngressosVendidos;

    public Atracao() {
    }

    public Atracao(String nome, double cache, String descricao) {
        this.nome = nome;
        this.cache = cache;
        this.descricao = descricao;
        numDeIngressosVendidos = 0;
    }

    public Atracao(String nome, double cache) {
        this.nome = nome;
        this.cache = cache;
        numDeIngressosVendidos = 0;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCache() {
        return cache;
    }
    public void setCache(double cache) {
        this.cache = cache;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumDeIngressosVendidos() {
        return numDeIngressosVendidos;
    }

    public void setNumDeIngressosVendidos(int numDeIngressosVendidos) {
        this.numDeIngressosVendidos = numDeIngressosVendidos;
    }
    public void addVendaDeIngresso(int quantIngressos){
        this.numDeIngressosVendidos += quantIngressos;
    }

}

