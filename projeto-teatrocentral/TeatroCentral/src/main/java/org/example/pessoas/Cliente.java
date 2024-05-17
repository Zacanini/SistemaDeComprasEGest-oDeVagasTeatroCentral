package org.example.pessoas;

import org.example.Ingresso;
import org.example.infos.Endereco;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int idade;
    private Endereco endereco;
    private String CPF;
    private ArrayList<Ingresso> ingressos;
    private boolean deficiente,DoadorDeSangue,CarteirinhaEstudantil;
    private String email,senha;

    public Cliente() {
        ingressos = new ArrayList<>();
    }


    public Cliente(String nome, int idade, String CPF,Endereco endereco, boolean deficiente, boolean doadorDeSangue,
                   boolean carteirinhaEstudantil,String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.endereco = endereco;
        this.deficiente = deficiente;
        DoadorDeSangue = doadorDeSangue;
        CarteirinhaEstudantil = carteirinhaEstudantil;
        this.email = email;
        this.senha=senha;
        ingressos = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void addIngressos(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean isDeficiente() {
        return deficiente;
    }
    public void setDeficiente(boolean deficiente) {
        this.deficiente = deficiente;
    }

    public boolean isDoadorDeSangue() {
        return DoadorDeSangue;
    }
    public void setDoadorDeSangue(boolean doadorDeSangue) {
        DoadorDeSangue = doadorDeSangue;
    }

    public boolean isCarteirinhaEstudantil() {
        return CarteirinhaEstudantil;
    }
    public void setCarteirinhaEstudantil(boolean carteirinhaEstudantil) {
        CarteirinhaEstudantil = carteirinhaEstudantil;
    }



    public String carteirinhaDeCliente(){
        String carteirinha = "---NOME: " +getNome()+ "  ---IDADE: "+getIdade()+"; \n " +
                "---CPF: "+getCPF();

        return carteirinha;
    }


}

