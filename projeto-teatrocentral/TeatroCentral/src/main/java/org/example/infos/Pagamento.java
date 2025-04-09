package org.example.infos;

import java.time.LocalDate;

public class Pagamento {
    private LocalDate data;
    private double valor;
    private String descricao;

    public Pagamento() {
    }

    public Pagamento(LocalDate data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}


