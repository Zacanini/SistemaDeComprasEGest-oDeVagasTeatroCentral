package org.example;

import org.example.infos.Data;
import org.example.infos.Pagamento;
import org.example.pessoas.Atracao;

import java.util.ArrayList;

public class Evento {
    private String nome;
    private String descricao;
    private Data data;
    private String horario;
    private double preco;
    private ArrayList<Atracao> atracoes;
    private int CapacidadeTotalDePublico;
    private int[] assentos ;
    private int assentosRestantes ;
    private int ingressosDisponiveis ;
    private ArrayList<Pagamento> pagamentos;

    public Evento() {
        pagamentos = new ArrayList<>();
        atracoes = new ArrayList<>();
    }

    public Evento(String nome, Data data, String horario ,double preco,int capacidadeTotalDePublico,String descricao) {
        this.preco = preco;
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.descricao=descricao;
        this.CapacidadeTotalDePublico = capacidadeTotalDePublico;
        assentos = new int[CapacidadeTotalDePublico];
        assentosRestantes = assentos.length;
        ingressosDisponiveis = assentosRestantes;
        pagamentos = new ArrayList<>();
        atracoes = new ArrayList<>();
    }
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Atracao> getAtracoes() {
        return atracoes;
    }
    public void addAtracao(Atracao atracao) {
        atracoes.add(atracao);
    }
    public void removeAtracao(Atracao atracao){
        atracoes.remove(atracao);
    }

    public int getCapacidadeTotalDePublico() {
        return CapacidadeTotalDePublico;
    }
    public void setCapacidadeTotalDePublico(int capacidadeTotalDePublico) {
        CapacidadeTotalDePublico = capacidadeTotalDePublico;
    }

    public int[] getAssentos() {
        return assentos;
    }
    public void setAssentos(int[] assentos) {
        this.assentos = assentos;
    }

    public int getIngressos() {
        return ingressosDisponiveis;
    }
    public void setIngressos(int ingresso) {
        this.ingressosDisponiveis = ingresso;
    }

    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }
    public void addPagamentos(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    public int getAssentosRestantes() {
        return assentosRestantes;
    }

    public void setAssentosRestantes(int assentosRestantes) {
        this.assentosRestantes = assentosRestantes;
    }

    public void reservaAssento (int reservado){
        if (assentos[reservado-1] == reservado){
            throw new RuntimeException("Assento ja vendido/reservado");
        }
        assentos[reservado-1] = reservado;
        this.assentosRestantes -= 1;
        ingressosDisponiveis -=1;
    }
    public void TiraReserva (int reservado){
        assentos[reservado-1] = 0;
        this.assentosRestantes += 1;
        ingressosDisponiveis +=1;
    }

    public void verificaSeHaIngressos(int numero){
        if (numero > ingressosDisponiveis){
            throw new RuntimeException("Ingressos insuficientes ou esgotados!! ");
        }
    }

    public int NumeroDeVendas (){
        return pagamentos.size();
    }
    public int ingressosNaoVendidos(){
        return CapacidadeTotalDePublico - pagamentos.size();
    }
    public double ValorTotalArrecadado(){
        double soma = 0;
        for (Pagamento p : pagamentos){
            soma += p.getValor();
        }
        return soma;
    }
    public double lucroDoEvento(){
        double lucro = ValorTotalArrecadado();
        for (Atracao a : atracoes){
            lucro -= a.getCache();
        }
        return lucro;
    }
}
