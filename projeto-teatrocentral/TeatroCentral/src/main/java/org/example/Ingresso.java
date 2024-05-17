package org.example;

import org.example.infos.Data;
import org.example.infos.Pagamento;
import org.example.pessoas.Atracao;
import org.example.pessoas.Cliente;

import java.util.ArrayList;
import java.util.Random;

public class Ingresso {
    private Cliente dono;
    private Evento evento;
    private ArrayList<Atracao> atracoes;
    private Data dataDoEvento;
    private String horario;
    private double preco;
    private String codDeBarras;
    private int numDoAssento;
    private Pagamento pagamento;

    public Ingresso() {
    }

    public Ingresso(Cliente dono, Evento evento, ArrayList<Atracao> atracoes, Data dataDoEvento, String horario, double preco, int numDoAssento) {
        this.dono = dono;
        this.evento = evento;
        this.atracoes = new ArrayList<>(atracoes);
        this.dataDoEvento = dataDoEvento;
        this.horario = horario;
        this.preco = preco;
        this.numDoAssento = numDoAssento;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodDeBarras() {
        return codDeBarras;
    }

    public void setCodDeBarras(String codDeBarras) {
        this.codDeBarras = codDeBarras;
    }

    public Ingresso(Cliente dono) {
        this.dono = dono;
    }
    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Data getDataDoEvento() {
        return dataDoEvento;
    }
    public void setDataDoEvento(Data dataDoEvento) {
        this.dataDoEvento = dataDoEvento;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getNumDoAssento() {
        return numDoAssento;
    }
    public void setNumDoAssento(int numDoAssento) {
        this.numDoAssento = numDoAssento;
    }

    public ArrayList<Atracao> getAtracoes() {
        return atracoes;
    }
    public double definePreco(Cliente cliente){
        this.preco = evento.getPreco();
        if ((cliente.isDeficiente()) || (cliente.isCarteirinhaEstudantil()) || (cliente.isDoadorDeSangue())){
            this.preco = evento.getPreco()/2;
        }
        return this.preco;
    }

    public void geraCodigoDeBarras(){
        Random random = new Random();
        codDeBarras = "";
        for (int i = 0; i < 8; i++) {
            int digito = random.nextInt(10); // Gera um dígito aleatório entre 0 e 9
            codDeBarras += digito;
        }

    }
}
