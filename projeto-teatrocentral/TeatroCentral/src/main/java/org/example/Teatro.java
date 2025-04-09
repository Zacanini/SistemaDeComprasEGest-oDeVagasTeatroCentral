package org.example;

import org.example.infos.Endereco;
import org.example.infos.Pagamento;
import org.example.pessoas.Atracao;
import org.example.pessoas.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Teatro {
    private String nome;
    private Endereco endereco;
    private ArrayList<Cliente> clientes;
    private ArrayList<Evento> eventos;


    public Teatro() {
    }


    public Teatro(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.clientes = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void addClientes(Cliente cliente) {

        clientes.add(cliente);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }


    public void rmvEventos(String nome){
        Iterator<Evento> iterator = eventos.iterator();
        while (iterator.hasNext()) {
            Evento e = iterator.next();
            if(e.getNome().equals(nome)){
                iterator.remove();
            }
        }
    }
    public void addEventos(Evento evento) {
        for (Evento e : eventos){
            if ((e.getData()==evento.getData())){
                throw new RuntimeException("Um evento ja está marcado para essa data!! ");
            }
        }
        eventos.add(evento);
    }
    public ArrayList<Evento> retornaEventoMes (int mesEvent){
        ArrayList<Evento> eventosMes = new ArrayList<>();
        {
            for (Evento e : eventos) {
                if (e.getData().getMonthValue() == mesEvent) {
                    eventosMes.add(e);
                }
            }
        }
        if (eventosMes.isEmpty()){
            throw new RuntimeException("Não ha eventos nesse mês!!");
        }
        return eventosMes;
    }
    public ArrayList<Evento> retornaEventosAno (int ano){
        ArrayList<Evento> eventosAno = new ArrayList<>();
        {
            for (Evento e : eventos) {
                if (e.getData().getYear() == ano) {
                    eventosAno.add(e);
                }
            }
        }
        return eventosAno;
    }
    public Evento retornaEvento(String nomeeven){
        Evento evento = new Evento();
        for (Evento e : eventos){
            if (e.getNome().equals(nomeeven))
                evento = e;
        }
        return evento;
    }
    public void confereEvento(String nome){
        int contador = 0;
        for (Evento e : eventos){
            if (e.getNome().equals(nome)){
                contador++;
            }
        }
        if (contador == 0){
            throw new RuntimeException("O evento digitado não existe!");
        }

    }

    public int relatorioDeVendasMensal(int mes){
        ArrayList<Evento> eventosMes = retornaEventoMes(mes);
        int NumeroDeVendasMes = 0;
        for (Evento e : eventosMes){
            NumeroDeVendasMes += e.NumeroDeVendas();
        }
        return NumeroDeVendasMes;
    }
    public int relatorioDeingressosNaoVendidosMes(int mes){
        ArrayList<Evento> eventosMes = retornaEventoMes(mes);
        int ingressosNaoVendidosMes = 0;
        for (Evento e : eventosMes){
            ingressosNaoVendidosMes += e.ingressosNaoVendidos();
        }
        return  ingressosNaoVendidosMes;
    }
    public double relatorioDeValorTotalArrecadadoMes(int mes){
        ArrayList<Evento> eventosMes = retornaEventoMes(mes);
        double ValorTotalArrecadadoMes = 0;
        for (Evento e : eventosMes){
            ValorTotalArrecadadoMes += e.ValorTotalArrecadado();
        }
        return  ValorTotalArrecadadoMes;

    }
    public double relatorioDelucroMes(int mes){
        ArrayList<Evento> eventosMes = retornaEventoMes(mes);
        double lucroMes = 0;
        for (Evento e : eventosMes){
            lucroMes += e.lucroDoEvento();
        }
        return  lucroMes;

    }

    public int relatorioDeVendasAnual(int ano){
        ArrayList<Evento> eventosAno = retornaEventosAno(ano);
        int NumeroDeVendasAno = 0;
        for (Evento e : eventosAno){
            NumeroDeVendasAno += e.NumeroDeVendas();
        }
        return NumeroDeVendasAno;
    }
    public int relatorioDeingressosNaoVendidosAno(int ano){
        ArrayList<Evento> eventosAno = retornaEventosAno(ano);
        int ingressosNaoVendidosAno = 0;
        for (Evento e : eventosAno){
            ingressosNaoVendidosAno += e.ingressosNaoVendidos();
        }
        return  ingressosNaoVendidosAno;
    }
    public double relatorioDeValorTotalArrecadadoAno(int ano){
        ArrayList<Evento> eventosAno = retornaEventosAno(ano);
        double ValorTotalArrecadadoAno = 0;
        for (Evento e : eventosAno){
            ValorTotalArrecadadoAno += e.ValorTotalArrecadado();
        }
        return  ValorTotalArrecadadoAno;

    }
    public double relatorioDelucroAno(int ano){
        ArrayList<Evento> eventosAno = retornaEventosAno(ano);
        double lucroAno = 0;
        for (Evento e : eventosAno){
            lucroAno += e.lucroDoEvento();
        }
        return  lucroAno;

    }

    public double MediaFaturamentoEventos(){
        double faturamento = 0;
        for (Evento e : eventos){
            faturamento += e.ValorTotalArrecadado();
        }
        return faturamento/eventos.size();
    }
    public double LucroMedioEventos(){
        double lucroM = 0;
        for (Evento e : eventos){
            lucroM += e.lucroDoEvento();
        }
        return lucroM/eventos.size();
    }
    public Atracao retornaAtracaoMes(int mes){
        ArrayList<Evento> eventosMes = retornaEventoMes(mes);
        Atracao atracao = new Atracao();
        for (Evento e : eventosMes){
            ArrayList<Atracao> atracaos = e.getAtracoes();
            for (Atracao a : atracaos){
                if (a.getNumDeIngressosVendidos() > atracao.getNumDeIngressosVendidos()){
                    atracao = a;
                }
            }
        }
        return atracao;
    }
    public Atracao retornaAtracaoAno(int ano){
        ArrayList<Evento> eventosAno = retornaEventosAno(ano);
        Atracao atracao = new Atracao();
        for (Evento e : eventosAno){
            ArrayList<Atracao> atracaos = e.getAtracoes();
            for (Atracao a : atracaos){
                if (a.getNumDeIngressosVendidos() > atracao.getNumDeIngressosVendidos()){
                    atracao = a;
                }
            }
        }
        return atracao;
    }




    public void trocaNome (String nomeantigo , String nomeNovo){
        for (Evento e : eventos) {
            if (e.getNome().equals(nomeantigo)) {
                e.setNome(nomeNovo);
            }
        }
    }
    public void adicionarDescricao (String nome,String descricao){
        for (Evento e : eventos){
            if (e.getNome().equals(nome)){
                e.setDescricao(descricao);
            }
        }
    }
    public void alterarData (LocalDate data, String nome){
        for (Evento e : eventos){
            if (e.getNome().equals(nome)){
                e.setData(data);
            }
        }
    }
    public void alterarHorario (String horario, String nome){
        for (Evento e : eventos){
            if (e.getNome().equals(nome)){
                e.setHorario(horario);
            }
        }
    }
    public void addAtracao (String nomeEven , Atracao atracao){
        for (Evento e : eventos){
            if (e.getNome().equals(nomeEven)){
                e.addAtracao(atracao);

            }
        }

    }
    public void definePublico (String nomeEvent, int quantidade){
        for (Evento e : eventos){
            if (e.getNome().equals(nomeEvent)){
                e.setCapacidadeTotalDePublico(quantidade);
                e.setAssentosRestantes(quantidade);
                e.setAssentos(new int[quantidade]);
            }
        }
    }


    public Cliente buscaCliente(String cpf){
        Cliente cliente = new Cliente();
        for (Cliente c : clientes){
            if (c.getCPF().equals(cpf)){
                cliente = c;
            }
        }
        return cliente;
    }
    public void verificaCadastroCliente(String cpf){
        for (Cliente c : clientes){
            if (c.getCPF().equals(cpf)){
                throw new RuntimeException("Cliente já cadastrado!!");
            }
        }
    }
    public void buscaCPF(String cpf){
        int cont = 0;
        for (Cliente c : clientes){
            if (c.getCPF().equals(cpf)){
                cont++;
            }
        }if (cont == 0){
            throw new RuntimeException("Cliente Não encontrado!!");
        }
    }
}
