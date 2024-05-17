package org.example.infos;

public class Pagamento {
    private Data data;
    private double valor;
    private String descricao;

    public Pagamento() {
    }

    public Pagamento(Data data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
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


