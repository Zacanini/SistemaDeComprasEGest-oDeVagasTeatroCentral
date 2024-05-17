package org.example;


import org.example.infos.Endereco;
import org.example.infos.Data;
import org.example.infos.Pagamento;
import org.example.pessoas.Atracao;
import org.example.pessoas.Cliente;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static Scanner leGlobal = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Teatro teatroCentral = getTeatro();

        System.out.println("Olá! digite (C) se for cliente ou (F) se for funcionario:");
        char resp2 = sc.next().toUpperCase().charAt(0);
        isCliente(resp2, sc, teatroCentral);
        isFuncionario(resp2, teatroCentral);
    }

    @NotNull
    public static Teatro getTeatro() {
        Endereco enderecoTC = new Endereco("Praça João Pessoa, s/n", "Centro", "Juiz de Fora", "36010-150");
        Teatro teatroCentral = new Teatro("Cine-Theatro Central", enderecoTC);
        Cliente cliente = new Cliente("Matheus", 22, "1234567", enderecoTC
                , false, false, false, "matheus@.com", "123");
        Cliente cliente2 = new Cliente("jonas", 22, "1234", enderecoTC,
                true, false, false, "matheus@.com", "123");
        Cliente cliente3 = new Cliente("amanda", 22, "4321", enderecoTC,
                false, true, false, "matheus@.com", "123");
        teatroCentral.addClientes(cliente);
        teatroCentral.addClientes(cliente2);
        teatroCentral.addClientes(cliente3);
        Data data = new Data(5, 5, 2024);
        Data data2 = new Data(3, 10, 2024);
        Atracao atracao1 = new Atracao("o robson", 200, "Um show animado de comedia");
        Atracao atracao2 = new Atracao("a toca", 100, "Um show  de pensamentos");
        Atracao atracao3 = new Atracao("as pingas", 80, "Um show de reflexão");
        Evento evento = new Evento("Joao nunes", data, "20:00", 60.00, 20, "Um evento de joao nunes");
        Evento evento2 = new Evento("os pensadores", data2, "21:00", 100.00, 300, "Um evento dos pensadores");
        evento.addAtracao(atracao1);
        evento.addAtracao(atracao2);
        evento.addAtracao(atracao3);
        evento2.addAtracao(atracao1);
        evento2.addAtracao(atracao2);
        evento2.addAtracao(atracao3);
        teatroCentral.addEventos(evento);
        teatroCentral.addEventos(evento2);
        return teatroCentral;
    }
    public static boolean verificaLogin() {
        System.out.print("Login?");
        String login = leGlobal.next();
        System.out.print("Senha?");
        String senha = leGlobal.next();
        return login.equals("teatrocentral") && senha.equals("123");
    }
    @NotNull
    public static String getCPF(Scanner sc) {
        System.out.println("digite seu cpf");
        return sc.next();
    }
    public static Endereco getEndereco() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite sua rua:");
        String ruaCli = sc.nextLine();
        System.out.println("Digite seu bairro:");
        String bairroCli = sc.nextLine();
        System.out.println("Digite sua cidade:");
        String cidadeCli = sc.nextLine();
        System.out.println("Digite seu CEP:");
        String cepCli = sc.next();
        return new Endereco(ruaCli, bairroCli, cidadeCli, cepCli);
    }



    public static void isFuncionario(char resp2, Teatro teatroCentral) {
        if (resp2 == 'F') {
            if (!verificaLogin()) {
                System.out.println("Login Incorreto!!!");
                System.exit(-1);
            }
            System.out.println("Olá, bem vindo ao Sistema de Vendas e Controle de Vagas\n" +
                    "do Teatro Municipal de Juiz de Fora\n ");
            menuFuncionario(teatroCentral);
        }
    }
    public static int MenuPrincipal() {
        System.out.println("#############################");
        System.out.println("#############################");
        System.out.println("### MENU PRINCIPAL");
        System.out.println("### O QUE VOCÊ DESEJA FAZER?");
        System.out.println("## 1) Cadastrar Evento");
        System.out.println("## 2) Consultar Eventos");
        System.out.println("## 3) Vender Ingressos");
        System.out.println("## 4) Gerenciar eventos");
        System.out.println("## 5) Relatório de Vendas por Evento");
        System.out.println("## 6) Relatório de Vendas Mensal");
        System.out.println("## 7) Relatório de Vendas Anual");
        System.out.println("## 8) Faturamento/Lucro Médio dos Eventos");
        System.out.println("## 9) Atração com Maior Número de Ingressos Vendidos no Mês");
        System.out.println("## 10) Atração com maior Número de Ingressos Vendidos no Ano");
        System.out.println("###########################");
        System.out.println("## 11) Sair");
        return leGlobal.nextInt();
    }
    public static void menuFuncionario(Teatro teatroCentral) {
        while (true) {
            int menu = MenuPrincipal();
            if (menu == 11) {
                System.out.println("Ate Mais!!!");
                System.exit(-1);
            } else if (menu == 1) {
                addEvento(teatroCentral);
            } else if (menu == 2) {
                consultaEventosMes(teatroCentral);
            } else if (menu == 3) {
                venderIngresso(teatroCentral);
            } else if (menu == 4) {
                menuGerenciaEventos(teatroCentral);
            }else if (menu == 5) {
                relatorioVendasPorEvento(teatroCentral);
            }else if (menu == 6) {
                relatorioVendasMensais(teatroCentral);
            }else if (menu == 7) {
                relatorioVendasAnual(teatroCentral);
            }else if (menu == 8) {
                mediaPorEvento(teatroCentral);
            }else if (menu == 9) {
                atracaoMaisIngressosMes(teatroCentral);
            }else if (menu == 10) {
                atracaoMaisIngressosAno(teatroCentral);
            }
        }
    }
    public static void addEvento(Teatro teatro) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vamos adicionar um evento!");
        Evento evento = CadastrandoEvento(sc);
        try {
            teatro.addEventos(evento);
            System.out.println("!!Evento adicionado com sucesso!! \n Para gerenciar seu evento selecione a opção 4");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    @NotNull
    public static Evento CadastrandoEvento(Scanner sc) {
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Qual nome do evento que você quer adicionar?");
        String nomeEvent = sc.nextLine();
        System.out.println("Digite a data do evento no formato dd/mm/aaaa:");
        String dataString = sc.nextLine();
        String[] partes = dataString.split("/");
        int diaEvent = Integer.parseInt(partes[0]);
        int mesEvent = Integer.parseInt(partes[1]);
        int anoEvent = Integer.parseInt(partes[2]);
        System.out.println("Qual horario desse evento?(00:00)");
        String horarioEvent = sc.next();
        System.out.println("Qual valor do ingresso ?");
        double valorIngreco = sc.nextDouble();
        System.out.println("Qual a capacidade total de publico presente no evento ?");
        int total = sc.nextInt();
        System.out.println("Qual a descrição do evento? ?");
        String descr = sc2.nextLine();
        Data dataEvent = new Data(diaEvent, mesEvent, anoEvent);
        Evento evento = new Evento(nomeEvent, dataEvent, horarioEvent, valorIngreco, total, descr);
        return evento;
    }
    public static void consultaEventosMes(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja ver os eventos de qual mês?");
        int mesEvent = sc.nextInt();
        try {
            ArrayList<Evento> eventosMes = teatro.retornaEventoMes(mesEvent);
            for (Evento e : eventosMes) {
                System.out.println("Nome do evento: " + e.getNome());
                System.out.println("Atrações:");
                for (Atracao a : e.getAtracoes()) {
                    System.out.println("---- " + a.getNome());
                }
                System.out.println("Data do evento: " + e.getData().getDia() + "/" + e.getData().getMes() + "/"
                        + e.getData().getAno());
                System.out.println("Descrição do evento: " + e.getDescricao());
                System.out.println("Horario do evento: " + e.getHorario());
                System.out.println("Numero de assentos disponivei: " + e.getAssentosRestantes());
                System.out.println("Valor do ingresso: R$" + e.getPreco());
            }
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void menuGerenciaEventos(Teatro teatroCentral) {
        while (true) {
            int menuGerenciarEventos = GerenciarEventos();
            if (menuGerenciarEventos == 8) break;
            else if (menuGerenciarEventos == 1) {
                alterarNome(teatroCentral);
            } else if (menuGerenciarEventos == 2) {
                adicionarDescricao(teatroCentral);
            } else if (menuGerenciarEventos == 3) {
                alterarData(teatroCentral);
            } else if (menuGerenciarEventos == 4) {
                alterarHorario(teatroCentral);
            } else if (menuGerenciarEventos == 5) {
                addAtracao(teatroCentral);
            } else if (menuGerenciarEventos == 6) {
                defineQuantPublico(teatroCentral);
            } else if (menuGerenciarEventos == 7) {
                rmvEvento(teatroCentral);
            }
        }
    }
    public static int GerenciarEventos() {
        System.out.println("#############################");
        System.out.println("#############################");
        System.out.println("### GERENCIAR EVENTOS");
        System.out.println("### O QUE VOCÊ DESEJA FAZER?");
        System.out.println("## 1) Alterar Nome do Evento");
        System.out.println("## 2) Adicionar Descrição");
        System.out.println("## 3) Alterar Data Do Evento");
        System.out.println("## 4) Alterar Horario do Evento");
        System.out.println("## 5) Adicionar Atração ao Evento");
        System.out.println("## 6) Definir Quantidade de público do Evento");
        System.out.println("## 7) Remover Evento");
        System.out.println("###########################");
        System.out.println("## 8) Sair");
        return leGlobal.nextInt();
    }
    public static void alterarNome(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Deseja alterar o nome de qual evento? (Digite o nome do evento) ");
        String nome = sc.nextLine();
        try {
            teatro.confereEvento(nome);
            System.out.println("### Digite o novo nome: ");
            String nome2 = sc.nextLine();
            teatro.trocaNome(nome, nome2);
            System.out.println("Nome anterior: " + nome);
            System.out.println("Nome atual: " + nome2);
            System.out.println("##NOME ALTERADO COM SUCESSO##");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void adicionarDescricao(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("### Deseja adicionar descrição em qual evento? (Digite o nome do evento) ");
        String nome = sc.nextLine();
        try {
            teatro.confereEvento(nome);
            System.out.println("### Digite a descrição que deseja adcionar ao evento: ");
            String descricao = sc.nextLine();
            teatro.adicionarDescricao(nome, descricao);
            System.out.println("DESCRIÇÃO: " + descricao);
            System.out.println("##Descrição adicionada com sucesso## ");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void alterarData(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("### Tem certeza que deseja alterar a data do evento? (S)im / (N)ão ");
        if (sc.next().toUpperCase().charAt(0) == 'S') {
            System.out.println("Digite o nome do evento que deseja alterar a data: ");

            String nome = sc2.nextLine();
            try {
                teatro.confereEvento(nome);
                System.out.println("Digite a nova data do evento:");
                int dia = sc.nextInt();
                int mes = sc.nextInt();
                int ano = sc.nextInt();
                Data novaData = new Data(dia, mes, ano);
                teatro.alterarData(novaData, nome);
                System.out.println("Data alterada com sucesso!!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("### OK");
        }
    }
    public static void alterarHorario(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("### Tem certeza que deseja alterar o horario do evento? (S)im / (N)ão ");
        if (sc.next().toUpperCase().charAt(0) == 'S') {
            System.out.println("Digite o nome do evento que deseja alterar o horario: ");
            String nome = sc2.nextLine();
            try {
                teatro.confereEvento(nome);
                System.out.println("Digite o novo horario do evento: (00:00) ");
                String horario = sc2.nextLine();
                teatro.alterarHorario(horario, nome);
                System.out.println("NOVO HORARIO: " + horario);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("### OK");
        }
    }
    public static void addAtracao(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("## Deseja adicionar uma atração em qual evento? (DIGITE O NOME CORRETO DO EVENTO)");
        String nomeEven = sc.nextLine();
        try {
            teatro.confereEvento(nomeEven);
            System.out.println("## Digite o nome da atração que deseja adicionar: ");
            String nomeAtra = sc.nextLine();
            System.out.println("## Qual valor dessa atração: ");
            double cache = sc.nextDouble();
            System.out.println("## Digite a descrição dessa atração: ");
            Scanner sc1 = new Scanner(System.in);
            String desr = sc1.nextLine();
            Atracao atracao = new Atracao(nomeAtra, cache, desr);
            teatro.addAtracao(nomeEven,atracao);
            System.out.println("##Atração " + atracao.getNome() + " adicionada com sucesso!");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void defineQuantPublico(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja definir o numero total do publico para qual evento? (DIGITE O NOME CORRETO DO EVENTO)");
        String nome = sc.nextLine();
        try {
            teatro.confereEvento(nome);
            System.out.println("Digite o numero total du público para o evento " + nome + ":");
            int total = sc.nextInt();
            teatro.definePublico(nome, total);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void rmvEvento(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Deseja excluir algum evento? (S)im (N)ão");
        if (sc.next().toUpperCase().charAt(0) == 'S') {
            System.out.println("Qual nome do evento que deseja excluir");
            String rspt = sc2.nextLine();
            try {
                teatro.confereEvento(rspt);
                teatro.rmvEventos(rspt);
                System.out.println("Evento removido com sucesso!!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());

            }

        } else {
            System.out.println("Ok");
        }
    }
    public static void relatorioVendasPorEvento(Teatro teatro){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do evento no qual deseja ver o relatório de vendas: ");
        String nome = sc.nextLine();
        try{
            teatro.confereEvento(nome);
            Evento evento = teatro.retornaEvento(nome);
            informacoesDeVendasPorEvento(evento);

        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void informacoesDeVendasPorEvento(Evento evento) {
        System.out.println("### Numero de ingressos vendidos: "+ evento.NumeroDeVendas());
        System.out.println("### Numero de ingressos não vendidos: "+ evento.ingressosNaoVendidos());
        System.out.println("### Faturamento Arrecadado: R$"+ evento.ValorTotalArrecadado());
        System.out.println("### Lucro obtido no Evento: R$"+ evento.lucroDoEvento());
    }
    public static void relatorioVendasMensais(Teatro teatro){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o mês no qual deseja ver o relatório de vendas: ");
        int mes = sc.nextInt();
        informacoesMensais(teatro, mes);
    }
    public static void informacoesMensais(Teatro teatro, int mes) {
        int ingressosVendidos = teatro.relatorioDeVendasMensal(mes);
        int ingressosNaoVendidos = teatro.relatorioDeingressosNaoVendidosMes(mes);
        double Total = teatro.relatorioDeValorTotalArrecadadoMes(mes);
        double lucro = teatro.relatorioDelucroMes(mes);
        System.out.println("### Numero de ingressos vendidos: "+ ingressosVendidos);
        System.out.println("### Numero de ingressos não vendidos: "+ ingressosNaoVendidos);
        System.out.println("### Faturamento Arrecadado no Mês: R$"+ Total);
        System.out.println("### Lucro obtido no Mês: "+ lucro);
    }
    public static void relatorioVendasAnual(Teatro teatro){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja ver o relatório de qual ano: ");
        int ano = sc.nextInt();
        informacoesAnuais(teatro, ano);
    }
    public static void informacoesAnuais(Teatro teatro, int ano) {
        int ingressosVendidos = teatro.relatorioDeVendasAnual(ano);
        int ingressosNaoVendidos = teatro.relatorioDeingressosNaoVendidosAno(ano);
        double Total = teatro.relatorioDeValorTotalArrecadadoAno(ano);
        double lucro = teatro.relatorioDelucroAno(ano);
        System.out.println("### Numero de ingressos vendidos: "+ ingressosVendidos);
        System.out.println("### Numero de ingressos não vendidos: "+ ingressosNaoVendidos);
        System.out.println("### Faturamento Arrecadado no Ano: R$"+ Total);
        System.out.println("### Lucro obtido no Ano: R$"+ lucro);
    }
    public static void mediaPorEvento(Teatro teatro){
        System.out.println("Media de faturamento por evento: R$"+ teatro.MediaFaturamentoEventos());
        System.out.println("Media de lucros por evento: R$"+ teatro.LucroMedioEventos());
    }
    public static void atracaoMaisIngressosMes(Teatro teatro){
        System.out.println("Deseja ver a atração que vendeu mais ingressos em qual mes?");
        Scanner sc = new Scanner(System.in);
        int mes = sc.nextInt();
        Atracao atracao = teatro.retornaAtracaoMes(mes);
        informacoesAtracaoMaisEscolhida(atracao);
    }
    public static void atracaoMaisIngressosAno(Teatro teatro){
        System.out.println("Deseja ver a atração que vendeu mais ingressos em qual ano?");
        Scanner sc = new Scanner(System.in);
        int ano = sc.nextInt();
        Atracao atracao = teatro.retornaAtracaoAno(ano);
        informacoesAtracaoMaisEscolhida(atracao);
    }

    private static void informacoesAtracaoMaisEscolhida(Atracao atracao) {
        System.out.println("Nome: "+ atracao.getNome());
        System.out.println("Total de ingressos vendidos: "+ atracao.getNumDeIngressosVendidos());
        System.out.println("Valor do cache: "+ atracao.getCache());
    }



    public static void isCliente(char resp2, Scanner sc, Teatro teatroCentral) {
        if (resp2 == 'C') {
            System.out.println("Já possui um cadastro no Cine-Theatro central? (S)im ou (N)ão?");
            char resp = sc.next().toUpperCase().charAt(0);
            ClienteCadastrado(sc, teatroCentral, resp);
            clienteNaoCadastrado(sc, teatroCentral, resp);
        }
    }
    public static void ClienteCadastrado(Scanner sc, Teatro teatroCentral, char resp) {
        if (resp == 'S') {
            String cpf = getCPF(sc);
            try {
                teatroCentral.buscaCPF(cpf);
                validandoLoginCliente(teatroCentral, cpf);
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
    }
    public static void clienteNaoCadastrado(Scanner sc, Teatro teatroCentral, char resp) {
        if (resp == 'N') {
            cadastroCliente(teatroCentral);
            validandoLoginCliente(teatroCentral, getCPF(sc));
        }
    }
    public static void cadastroCliente(Teatro teatro) {
        Cliente cliente = informacoesCliente(teatro);
        if (cliente != null){
            teatro.addClientes(cliente);
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("################################");
        }


    }
    public static Cliente informacoesCliente(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Olá! Vamos fazer seu cadastro!");
        System.out.println("Digite seu nome:");
        String nomeCli = sc.nextLine();
        System.out.println("Digite sua idade:");
        int idadeCli = sc.nextInt();
        System.out.println("Digite seu CPF:");
        String cpfCli = sc.next();
        try {
            teatro.verificaCadastroCliente(cpfCli);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
        Endereco endereco = getEndereco();
        boolean pcd = false;
        System.out.println("É pcd? (S)im ou (N)ão");
        if (sc.next().toUpperCase().charAt(0) == 'S') {
            pcd = true;
        }
        boolean doador = false;
        System.out.println("É doador de sangue? (S)im ou (N)ão");
        if (sc.next().toUpperCase().charAt(0) == 'S') {
            doador = true;
        }
        boolean estudante = false;
        System.out.println("Possui carteirinha de estudante? (S)im ou (N)ão");
        if (sc.next().toUpperCase().charAt(0) == 'S') {
            estudante = true;
        }
        System.out.println("Digite um E-mail válido:");
        String emailCli = sc.next();
        System.out.println("Digite uma senha:");
        String senhaCli = sc.next();
        Cliente cliente = new Cliente(nomeCli, idadeCli, cpfCli, endereco, pcd, doador, estudante, emailCli, senhaCli);
        return cliente;
    }
    public static void validandoLoginCliente(Teatro teatroCentral, String cpf) {
        if (verificaLoginCliente(teatroCentral.buscaCliente(cpf))) {
            System.out.println("Login Incorreto!!!");
            System.exit(-1);
        } else {
            Cliente clienteLogado = teatroCentral.buscaCliente(cpf);
            System.out.println("Olá, "+clienteLogado.getNome()+ " , bem vindo ao Sistema de Vendas \n" +
                    "do Teatro Municipal de Juiz de Fora\n ");

            menuCliente(teatroCentral, clienteLogado);
        }
    }
    public static boolean verificaLoginCliente(Cliente cliente) {
        System.out.print("Login? (Seu E-mail)");
        String login = leGlobal.next();
        System.out.print("Senha? ");
        String senha = leGlobal.next();
        return !login.equals(cliente.getEmail()) || !senha.equals(cliente.getSenha());
    }
    public static int MenuClientePrint() {
        System.out.println("#############################");
        System.out.println("#############################");
        System.out.println("### MENU CLIENTE");
        System.out.println("### O QUE VOCÊ DESEJA FAZER?");
        System.out.println("## 1) Consultar Eventos");
        System.out.println("## 2) Comprar ingresso");
        System.out.println("## 3) Editar/vizualiar perfil");
        System.out.println("###########################");
        System.out.println("## 4) Sair");
        return leGlobal.nextInt();
    }
    public static void menuCliente(Teatro teatroCentral, Cliente clienteLogado) {
        while (true) {
            int menu = MenuClientePrint();
            if (menu == 4) {
                System.out.println("Até mais...");
                System.exit(-1);
            } else if (menu == 1) {
                consultaEventosMes(teatroCentral);
            } else if (menu == 2) {
                comprarIngresso(teatroCentral, clienteLogado);
            } else if (menu == 3) {
                verificaPerfilCliente(clienteLogado);
            }
        }
    }
    public static void verificaPerfilCliente(Cliente clienteLogado) {
        while (true) {
            int menuP = menuPerfilCliente();
            if (menuP == 4) {
                System.out.println("Redirecionando...");
                break;
            } else if (menuP == 1) {
                carteirinhaCliente(clienteLogado);
            } else if (menuP == 2) {
                historicoDeCompras(clienteLogado);
            } else if (menuP == 3) {
                editarEndereco(clienteLogado);
            }
        }
    }
    public static int menuPerfilCliente() {
        System.out.println("#############################");
        System.out.println("#############################");
        System.out.println("### BEM VINDO AO SEU PERFIL");
        System.out.println("#############################");
        System.out.println("### O QUE VOCÊ DESEJA FAZER?");
        System.out.println("## 1) Exibir Carteirinha");
        System.out.println("## 2) Exibir Histórico de compras");
        System.out.println("## 3) Editar Endereço");
        System.out.println("###########################");
        System.out.println("## 4) Sair");
        return leGlobal.nextInt();
    }
    public static void carteirinhaCliente(Cliente cliente) {
        String carteirinha = cliente.carteirinhaDeCliente();
        System.out.println(carteirinha);
    }
    public static void historicoDeCompras(Cliente cliente) {
        System.out.println("Histórico de compras: ");
        System.out.println("################################## ");
        for (Ingresso i : cliente.getIngressos()) {
            System.out.println("Evento: " + i.getEvento().getNome());
            System.out.println("Preço do ingresso: " + i.getPreco());
            System.out.println(i.getPagamento().getDescricao());
            System.out.println("Data da compra: " + i.getPagamento().getData().getDia() + "/" +
                    i.getPagamento().getData().getMes() + "/" + i.getPagamento().getData().getAno());
            System.out.println("Numero da Poltrona: " + i.getNumDoAssento());
            System.out.println("################################## ");
        }
    }
    public static void editarEndereco(Cliente cliente) {
        System.out.println("Digite o novo endereço");
        Endereco end = getEndereco();
        cliente.setEndereco(end);
        System.out.println("Endereço editado com sucesso!");
    }



    public static void venderIngresso(Teatro teatro) {
        Scanner sc = new Scanner(System.in);
        System.out.println("O cliente tem cadastro? (S)im ou (N)ão");
        char rsp = sc.next().toUpperCase().charAt(0);
        TemCadastro(teatro, rsp, sc);
        NaoTemCadastro(teatro, rsp, sc);
    }
    public static void consultaTodosEventos(Teatro teatro) {

        for (Evento e : teatro.getEventos()) {
            System.out.println("Nome do evento: " + e.getNome());
            System.out.println("Atrações:");
            for (Atracao a : e.getAtracoes()) {
                System.out.println("---- " + a.getNome());
            }
            System.out.println("Data do evento: " + e.getData().getDia() + "/" + e.getData().getMes() + "/"
                    + e.getData().getAno());
            System.out.println("Descrição do evento: " + e.getDescricao());
            System.out.println("Horario do evento: " + e.getHorario());
            System.out.println("Numero de assentos disponivei: " + e.getAssentosRestantes());
            System.out.println("Valor do ingresso: R$" + e.getPreco());
            System.out.println("#################");
        }
    }
    public static void NaoTemCadastro(Teatro teatro, char rsp, Scanner sc) {
        if (rsp == 'N') {
            Scanner sc1 = new Scanner(System.in);
            cadastroCliente(teatro);
            Cliente cliente = teatro.buscaCliente(getCPF(sc));
            System.out.println("----------------------");
            System.out.println("Eventos disponiveis:");
            System.out.println("----------------------");
            consultaTodosEventos(teatro);
            System.out.println("Deseja vender ingressos para qual evento? (DIGITE O NOME DO EVENTO IGUAL ESTA NO MENU A CIMA");
            String nome = sc1.nextLine();
            confereSituacaoIngresso(teatro, nome, sc, cliente);
        }
    }
    public static void TemCadastro(Teatro teatro, char rsp, Scanner sc) {
        if (rsp == 'S') {
            Scanner sc1 = new Scanner(System.in);
            Cliente cliente = teatro.buscaCliente(getCPF(sc));
            try {
                teatro.buscaCPF(cliente.getCPF());
                System.out.println("----------------------");
                System.out.println("Eventos disponiveis:");
                System.out.println("----------------------");
                consultaTodosEventos(teatro);
                System.out.println("Deseja vender ingressos para qual evento? (DIGITE O NOME DO EVENTO IGUAL ESTA NO MENU A CIMA");
                String nome = sc1.nextLine();
                confereSituacaoIngresso(teatro, nome, sc, cliente);
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }


        }
    }
    public static void confereSituacaoIngresso(Teatro teatro, String nome, Scanner sc, Cliente cliente) {
        try {
            teatro.confereEvento(nome);
            System.out.println("Quantos ingressos ?");
            int num = sc.nextInt();
            try {
                teatro.retornaEvento(nome).verificaSeHaIngressos(num);
                for (int i = 0; i < num; i++) {
                    boolean rspt = true;
                    ConfirmandoVendaIngresso(teatro, rspt, nome, cliente, sc);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void ConfirmandoVendaIngresso(Teatro teatro, boolean rspt, String nome, Cliente cliente, Scanner sc) {
        while (rspt) {
            Ingresso ingresso = cadastraIngresso(teatro, nome, cliente);
            selecionaAtracao(ingresso);
            System.out.println("Você confirma a venda deste ingresso? (S)im (N)ão ");
            imprimeAtracoesDoIngresso(ingresso);
            InformacoesSobreIngresso(ingresso);
            System.out.println("############### ");
            char res = sc.next().toUpperCase().charAt(0);
            rspt = respostConfirmacao(teatro, rspt, nome, cliente, res, ingresso);
        }
    }
    public static boolean respostConfirmacao(Teatro teatro, boolean rspt, String nome, Cliente cliente, char res, Ingresso ingresso) {
        if (res == 'S') {
            cliente.addIngressos(ingresso);
            addPagamentoNoEvento(teatro, nome, ingresso, cliente);
            rspt = false;
        } else if (res == 'N') {
            removeReserva(teatro, nome, ingresso.getNumDoAssento());
        }
        return rspt;
    }
    public static void InformacoesSobreIngresso(Ingresso ingresso) {
        System.out.println("---Data: " + ingresso.getDataDoEvento().getDia() +
                "/" + ingresso.getDataDoEvento().getMes() + "/" + ingresso.getDataDoEvento().getAno());
        System.out.println("---Valor: " + ingresso.getPreco());
        System.out.println("---Horario: " + ingresso.getHorario());
        System.out.println("---Poltrona: " + ingresso.getNumDoAssento());
        System.out.println("CPF do titulal: " + ingresso.getDono().getCPF());
        System.out.println("Codigo de barras: " + ingresso.getCodDeBarras());
        System.out.println("################## ");
    }



    public static void comprarIngresso(Teatro teatro, Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------");
        System.out.println("Eventos disponiveis:");
        System.out.println("----------------------");
        consultaTodosEventos(teatro);
        System.out.println("Deseja comprar ingressos para qual evento? (DIGITE O NOME DO EVENTO IGUAL ESTA NO MENU A CIMA");
        String nome = sc.nextLine();
        System.out.println("Quantos ingressos deseja comprar?");
        int num = sc.nextInt();
        try {
            teatro.retornaEvento(nome).verificaSeHaIngressos(num);
            ComprandoIngresso(teatro, cliente, num, nome, sc);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());

        }
    }
    public static void ComprandoIngresso(Teatro teatro, Cliente cliente, int num, String nome, Scanner sc) {
        for (int i = 0; i < num; i++) {
            boolean rspt = true;
            while (rspt) {
                Ingresso ingresso = cadastraIngresso(teatro, nome, cliente);
                selecionaAtracao(ingresso);
                System.out.println("Você confirma a compra deste ingresso? (S)im (N)ão ");
                imprimeAtracoesDoIngresso(ingresso);
                InformacoesSobreIngresso(ingresso);
                System.out.println("############### ");
                char res = sc.next().toUpperCase().charAt(0);
                rspt = respostConfirmacao(teatro, rspt, nome, cliente, res, ingresso);
            }
        }
    }
    public static void imprimeAtracoesDoIngresso(Ingresso ingresso) {
        System.out.println("Atrações:####### ");
        for (Atracao a : ingresso.getAtracoes()) {
            System.out.println("Nome: " + a.getNome());
        }
    }
    public static Ingresso cadastraIngresso(Teatro teatro, String nome, Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        Evento evento = teatro.retornaEvento(nome);
        int[] assentos = evento.getAssentos();
        System.out.println("Escolha o seu assento: ");
        System.out.println("Assentos disponiveis: (assentos com numero 0 estão livres)");
        for (int i = 0; i < assentos.length; i += 3) {
            System.out.print("##Assento " + (i + 1) + ": " + assentos[i]);
            if (i+1 < assentos.length) {
                System.out.print(" | ##Assento " + (i + 2) + ": " + assentos[i+1]);
            }
            if (i+2 < assentos.length) {
                System.out.print(" | ##Assento " + (i + 3) + ": " + assentos[i+2]);
            }
            System.out.println();
        }

        int assento = sc.nextInt();
        try {
            evento.reservaAssento(assento);
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
        Ingresso ingresso = new Ingresso(cliente, evento, evento.getAtracoes(), evento.getData(),
                evento.getHorario(), evento.getPreco(), assento);
        ingresso.setPreco(ingresso.definePreco(cliente));
        ingresso.geraCodigoDeBarras();
        System.out.println("Escolha as atrações em que voce deseja ir: ");
        return ingresso;
    }
    public static void selecionaAtracao(Ingresso ingresso) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Atracao> atracoesARemover = new ArrayList<>();
        for (Atracao a : ingresso.getAtracoes()) {
            System.out.println("#################---------################");
            System.out.println("Atração: " + a.getNome());
            System.out.println("Deseja ir nessa atração? (S)im ou (N)ão");
            char resp = sc.next().toUpperCase().charAt(0);
            if (resp == 'S') {
                a.addVendaDeIngresso(1);
            } else if (resp == 'N') {
                atracoesARemover.add(a);
            }
        }
        ingresso.getAtracoes().removeAll(atracoesARemover);
    }
    public static Pagamento GerarPagamento(Ingresso ingresso, Cliente cliente) {

        LocalDate hoje = LocalDate.now();
        Date agora = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaFormatada = formatoHora.format(agora);
        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();
        Data data = new Data(dia, mes, ano);
        Pagamento pg = new Pagamento(data, ingresso.definePreco(cliente));
        pg.setDescricao("Horario de compra: " + horaFormatada + "\n");
        pg.setValor(ingresso.getPreco());
        return pg;
    }
    public static void addPagamentoNoEvento(Teatro teatro, String nome, Ingresso ingresso, Cliente cliente) {
        Pagamento pg = GerarPagamento(ingresso, cliente);
        teatro.retornaEvento(nome).addPagamentos(pg);
        ingresso.setPagamento(pg);
        System.out.println("Pagamento realizado com sucesso! ");
        System.out.println("#########-----##############");
        System.out.println("Data do pagamento: " + pg.getData().getDia() + "/" + pg.getData().getMes() + "/"
                + pg.getData().getAno());
        System.out.println("Informações do pagamento: \n" + pg.getDescricao());
        System.out.println("Valor do pagamento: R$" +pg.getValor());

    }
    public static void removeReserva(Teatro teatro, String nome, int assento) {
        Evento evento = teatro.retornaEvento(nome);
        evento.TiraReserva(assento);
    }
}
