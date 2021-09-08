/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author ramon
 */
public class View {
    
    static Scanner sc = new Scanner(System.in);
    static Controller ctr = new Controller();
    
    public static void menuInicial() {
        String checkSaida;
        System.out.println("Olá! Escolha uma opção:");
        System.out.println("Logar como:");
        System.out.println("1- Gerente");
        System.out.println("2- Vendedor");
        int opLogin = sc.nextInt();
        switch(opLogin) {
            case 1 -> {
                System.out.println("Entre com sua senha");
                String senhaGerente = sc.next();
                String[] retornoGerente = ctr.autenticarGerente(senhaGerente);
                if(retornoGerente[0].equals("0")) {
                    System.out.println(retornoGerente[1]);
                    int retornoMenu;
                    do {
                        retornoMenu = menuGerente();
                        //System.out.println("Digite SAIR para sair, ou qualquer outra coisa pra continuar");
                        //checkSaida = sc.next();
                    } while(retornoMenu == 0);
                }
                else {
                    System.out.println(retornoGerente[1]);
                }
            }
            case 2 -> {
                System.out.println("Entre com seu CPF:");
                String cpfVendedor = sc.next();
                String[] retornoVendedor = ctr.autenticarVendedor(cpfVendedor);
                if(retornoVendedor[0].equals("0")) {
                    System.out.println(retornoVendedor[1]);
                    int retornoMenu;
                    do {
                        retornoMenu = menuVendedor(cpfVendedor);
                        //System.out.println("Digite SAIR para sair, ou qualquer outra coisa pra continuar");
                        //checkSaida = sc.next();
                    } while(retornoMenu == 0);
                }
                else {
                    System.out.println(retornoVendedor[1]);
                }
            }
        }
    }
    
    public static int menuGerente() {
        System.out.println();
        System.out.println("1 - Cadastrar vendedor");
        System.out.println("2 - Cadastrar veículo");
        System.out.println("3 - Listar vendedores");
        System.out.println("4 - Listar veiculos");
        System.out.println("5 - Listar vendas");
        System.out.println("6 - Liberar venda");
        System.out.println("7 - Remover venda");
        System.out.println("8 - Remover veiculo");
        System.out.println("9 - Voltar ao menu inicial");
        System.out.print("Selecione uma opção: ");
        int opGerente = sc.nextInt();
        System.out.println();
        switch(opGerente) {
            case 1 -> {
                System.out.println("Insira o CPF do vendedor");
                String cpfVendedor = sc.next();sc.nextLine();
                System.out.println("Insira o nome do vendedor");
                String nomeVendedor = sc.next();sc.nextLine();
                System.out.println("Insira o endereço");
                String enderecoVendedor = sc.next();sc.nextLine();
                System.out.println("Insira o email do vendedor");
                String emailVendedor = sc.next();sc.nextLine();
                boolean vendedorCheck = ctr.cadastrarVendedor(cpfVendedor, nomeVendedor, enderecoVendedor, emailVendedor);
                if(vendedorCheck) {
                    System.out.println("Vendedor cadastrado com sucesso!");
                }
                else {
                    System.out.println("Este CPF já está cadastrado.");
                }
            }
            case 2 -> {
                System.out.println("Qual tipo de veículo será cadastrado? ");
                System.out.println("1 - Carro");
                System.out.println("2 - Moto");
                System.out.println("3 - Caminhão");
                int opTipoVeiculo = sc.nextInt();sc.nextLine();
                switch(opTipoVeiculo) {
                    case 1 -> {
                        System.out.print("Insira a placa do carro: ");
                        String placa = sc.next();sc.nextLine();
                        System.out.print("Insira o modelo: ");
                        String modelo = sc.next();sc.nextLine();
                        System.out.print("Insira o ano: ");
                        String ano = sc.next();sc.nextLine();
                        System.out.print("Insira o motor: ");
                        String motor = sc.next();sc.nextLine();
                        System.out.print("Insira o preço: ");
                        double preco = sc.nextDouble();sc.nextLine();
                        System.out.print("Insira o tipo de câmbio: ");
                        String cambio = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de combustível: ");
                        String combustivel = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de carroceria: ");
                        String carroceria = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de direção: ");
                        String direcao = sc.next();sc.nextLine();
                        boolean checkCarro = ctr.cadastrarCarro(placa, modelo, ano, motor, preco, cambio, combustivel, carroceria, direcao);
                        if(checkCarro) {
                            System.out.println("Carro cadastrado com sucesso!");
                        } else {
                            System.out.println("Essa placa já está cadastrada no sistema");
                        }
                    }
                    case 2 -> {
                        System.out.print("Insira a placa da moto: ");
                        String placa = sc.next();sc.nextLine();
                        System.out.print("Insira o modelo: ");
                        String modelo = sc.next();sc.nextLine();
                        System.out.print("Insira o ano: ");
                        String ano = sc.next();sc.nextLine();
                        System.out.print("Insira o motor: ");
                        String motor = sc.next();sc.nextLine();
                        System.out.print("Insira o preço: ");
                        double preco = sc.nextDouble();sc.nextLine();
                        System.out.print("Insira o tipo de câmbio: ");
                        String cambio = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de combustível: ");
                        String combustivel = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de ignição: ");
                        String ignicao = sc.next();sc.nextLine();
                        boolean checkMoto = ctr.cadastrarMoto(placa, modelo, ano, motor, preco, cambio, combustivel, ignicao);
                        if(checkMoto) {
                            System.out.println("Moto cadastrado com sucesso!");
                        } else {
                            System.out.println("Essa placa já está cadastrada no sistema");
                        }
                    }
                    case 3 -> {
                        System.out.print("Insira a placa do caminhão: ");
                        String placa = sc.next();sc.nextLine();
                        System.out.print("Insira o modelo: ");
                        String modelo = sc.next();sc.nextLine();
                        System.out.print("Insira o ano: ");
                        String ano = sc.next();sc.nextLine();
                        System.out.print("Insira o motor: ");
                        String motor = sc.next();sc.nextLine();
                        System.out.print("Insira o preço: ");
                        double preco = sc.nextDouble();sc.nextLine();
                        System.out.print("Insira o tipo de câmbio: ");
                        String cambio = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de combustível: ");
                        String combustivel = sc.next();sc.nextLine();
                        System.out.print("Insira a carga máxima em Kg: ");
                        double cargaMaxima = sc.nextDouble();sc.nextLine();
                        System.out.print("Insira o tipo de carroceria: ");
                        String carroceria = sc.next();sc.nextLine();
                        System.out.print("Insira o tipo de direção: ");
                        String direcao = sc.next();sc.nextLine();
                        boolean checkCaminhao = ctr.cadastrarCaminhao(placa, modelo, ano, motor, preco, cambio, combustivel, cargaMaxima, carroceria, direcao);
                        if(checkCaminhao) {
                            System.out.println("Caminhão cadastrado com sucesso!");
                        } else {
                            System.out.println("Essa placa já está cadastrada no sistema");
                        }
                    }
                }
                
            }
            case 3 -> {
                ArrayList<String> listaVendedores = ctr.listarVendedores();
                for(String v: listaVendedores) {
                    System.out.println(v);
                }
            }
            case 4 -> {
                ArrayList<String> listaVeiculos = ctr.listarVeiculos();
                for(String v: listaVeiculos) {
                    System.out.println(v);
                }
            }
            case 5 -> {
                ArrayList<String> listaVendas = ctr.listarVendas();
                for(String ve: listaVendas) {
                    System.out.println(ve);
                }
            }
            case 6 -> {
                System.out.print("Insira o código da venda para liberá-la: ");
                int codVenda = sc.nextInt();sc.nextLine();
                if(ctr.liberarVenda(codVenda)) {
                    System.out.println("Venda " + codVenda + " liberada com sucesso!");
                }
                else {
                    System.out.println("Código de venda inválido.");
                }
            }
            case 7 -> {
                System.out.print("Insira o código da venda para removê-la: ");
                int codVenda = sc.nextInt();sc.nextLine();
                if(ctr.removerVenda(codVenda)) {
                    System.out.println("Venda número " + codVenda + " removida com sucesso!");
                }
                else {
                    System.out.println("Venda número " + codVenda + " não encontrada.");
                }
            }
            case 8 -> {
                System.out.print("Insira a placa do veículo a ser removido: ");
                String placa = sc.next();sc.nextLine();
                if(ctr.removerVeiculo(placa)) {
                    System.out.println("Veículo de placa " + placa + " removido com sucesso!");
                   
                }
                else {
                    System.out.println("Veículo não encontrado.");
                }
            }
            case 9 -> {
                return 1;
            }
        }
        return 0;
    }
    
    public static int menuVendedor(String cpfVendedor) {
        System.out.println();
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Realizar venda");
        System.out.println("4 - Voltar ao menu inicial");
        System.out.print("Selecione sua opção: ");
        int opVendedor = sc.nextInt();
        System.out.println();
        switch(opVendedor) {
            case 1 -> {
                System.out.println("Insira o CPF do cliente");
                String cpfCliente = sc.next();sc.nextLine();
                System.out.println("Insira o nome do cliente");
                String nomeCliente = sc.next();sc.nextLine();
                System.out.println("Insira o endereço");
                String enderecoCliente = sc.next();sc.nextLine();
                System.out.println("Insira o email do cliente");
                String emailCliente = sc.next();sc.nextLine();
                boolean clienteCheck = ctr.cadastrarCliente(cpfCliente, nomeCliente, enderecoCliente, emailCliente);
                if(clienteCheck) {
                    System.out.println("Cliente cadastrado com sucesso!");
                }
                else {
                    System.out.println("Algo deu errado, ou cliente já cadastrado");
                }
            }
            
            case 2 -> {
                ArrayList<String> listaClientes = ctr.listarClientes();
                for(String c: listaClientes) {
                    System.out.println(c);
                }
            }
            case 3 -> {
                System.out.print("Digite o CPF do cliente: ");
                String cpfCliente = sc.next();sc.nextLine();
                System.out.print("Digite a placa do veículo: ");
                String placaVeiculo = sc.next();sc.nextLine();
                System.out.print("Digite o valor do desconto. Se não houver desconto, insira o valor 0: ");
                double desconto = sc.nextDouble();sc.nextLine();
                String[] retornoVenda = ctr.realizarVenda(placaVeiculo, cpfCliente, cpfVendedor, desconto);
                System.out.println(retornoVenda[1]);
            }
            case 4 -> {
                return 1;
            }
        }
        return 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        do {
            menuInicial();
        }while(true);
        
        
    }
    
}
