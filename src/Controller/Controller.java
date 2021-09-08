/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.util.ArrayList;

public class Controller {
    private ArrayList<Vendedor> vendedores;
    private Gerente gerente;
    private ArrayList<Cliente> clientes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Venda> vendas;
    
    public Controller() {
        this.gerente = new Gerente("104", "Zé das Couves", "Rua A", "alalal@123.com", "1234");
        this.vendedores = new ArrayList();
        this.clientes = new ArrayList();
        this.veiculos = new ArrayList();
        this.vendas = new ArrayList();
        
        this.vendedores.add(new Vendedor("1", "Pedro", "Rua B", "pedro@123.com"));
        this.clientes.add(new Cliente("10", "Zé da Esquina", "Rua C", "ze157@123.com", false));
        this.clientes.add(new Cliente("20", "Bené da Nova Holanda", "Rua do Pó", "bene157@hotmail123vamoquevamo", true));
        this.veiculos.add(new Carro("ABC1234", "Clio", "2005", "1.6", 30000, "Manual", "Hi-Flex", "Sedan", "Hidráulica"));
        this.veiculos.add(new Moto("AAA1111", "XJ6", "2016", "600cc", 22000, "Manual", "Gasolina", "Eletrônica"));
        this.veiculos.add(new Caminhao("BBB2222", "R450", "2014", "450cv", 70000, "Manual", "Diesel", 5000, "Caçamba", "Hidráulica"));
        
        this.vendas.add(new Venda(vendedores.get(0), clientes.get(0), veiculos.get(0), (vendas.size()+1), veiculos.get(0).getPreco()));
    }
    
    public boolean cadastrarCliente(String cpf, String nome, String endereco, String email) {
        for(Cliente c: clientes) {
            if(cpf.equals(c.getCpf())) {
                return false;
            }
        }
        Cliente cl = new Cliente(cpf, nome, endereco, email, false);
        clientes.add(cl);
        return true;
    }
    
    public boolean cadastrarVendedor(String cpf, String nome, String endereco, String email) {
        for(Vendedor v: vendedores) {
            if(cpf.equals(v.getCpf())) {
                return false;
            }
        }
        Vendedor vend = new Vendedor(cpf, nome, endereco, email);
        vendedores.add(vend);
        return true;
    }
    
    public boolean cadastrarCarro(String placa, String modelo, String ano, String motor, double preco, 
            String cambio, String combustivel,String carroceria, String direcao) {
        for(Veiculo v: veiculos) {
            if(placa.equals(v.getPlaca())) {
                return false;
            }
        }
        Veiculo v = new Carro(placa, modelo, ano, motor, preco, cambio, combustivel,carroceria, direcao);
        veiculos.add(v);
        return true;
    }
    
    public boolean cadastrarMoto(String placa, String modelo, String ano, String motor, double preco, 
            String cambio, String combustivel, String ignicao) {
        for(Veiculo v: veiculos) {
            if(placa.equals(v.getPlaca())) {
                return false;
            }
        }
        Veiculo v = new Moto(placa, modelo, ano, motor, preco, cambio, combustivel,ignicao);
        veiculos.add(v);
        return true;
    }
    
    public boolean cadastrarCaminhao(String placa, String modelo, String ano, String motor, double preco, 
            String cambio, String combustivel,double cargaMaxima, String carroceria, String direcao) {
        for(Veiculo v: veiculos) {
            if(placa.equals(v.getPlaca())) {
                return false;
            }
        }
        Veiculo v = new Caminhao(placa, modelo, ano, motor, preco, cambio, combustivel,cargaMaxima, carroceria, direcao);
        veiculos.add(v);
        return true;
    }
    
    public String[] realizarVenda(String placa, String cpfCliente, String cpfVendedor, double desconto) {
        String [] retorno = new String[2];
        for(Vendedor v: vendedores) {
            if(!cpfVendedor.equals(v.getCpf())) {
                retorno[0] = "1";
                retorno[1] = "Vendedor não encontrado no sistema!";
            }
            else {
                for(Cliente c: clientes) {
                    if(!cpfCliente.equals(c.getCpf())) {
                        retorno[0] = "2";
                        retorno[1] = "Cliente não cadastrado no sistema!";
                    }
                    else if(c.isNegativado()) {
                        retorno[0] = "4";
                        retorno[1] = "Cliente negativado. Venda proibida.";
                    }
                    else {
                        for(Veiculo vei: veiculos) {
                            if(!placa.equals(vei.getPlaca())) {
                                retorno[0] = "3";
                                retorno[1] = "Veiculo não cadastrado no sistema!";
                            }
                            else {
                                Venda venda = new Venda(v, c, vei, vendas.size()+1, vei.getPreco());
                                venda.gerarDesconto(desconto);
                                vendas.add(venda);
                                retorno[0] = "0";
                                retorno[1] = "Venda realizada com sucesso! Favor consultar o gerente para liberar a venda.";
                                return retorno;
                            }
                        }
                    }
                }
            }
        }
        return retorno;
    }
    
    public ArrayList<String> listarClientes() {
        ArrayList<String> listaClientes = new ArrayList();
        for(Cliente c: clientes) {
            listaClientes.add(c.getCpf() + "-" + c.getNome());
        }
        return listaClientes;
    }
    
    public ArrayList<String> listarVendedores() {
        ArrayList<String> listaVendedores = new ArrayList();
        for(Vendedor v: vendedores) {
            listaVendedores.add(v.getCpf() + "-" + v.getNome());
        }
        return listaVendedores;
    }
    
    public ArrayList<String> listarVeiculos() {
        ArrayList<String> listaVeiculos = new ArrayList();
        for(Veiculo vei: veiculos) {
            listaVeiculos.add(vei.getPlaca() + "-" + vei.getModelo());
        }
        return listaVeiculos;
    }
    
    public ArrayList<String> listarVendas() {
        ArrayList<String> listaVendas = new ArrayList();
        for(Venda v: vendas) {
            listaVendas.add("Código " + v.getCodVenda() + " - Vendido para " + 
                    v.getCliente().getNome() + " por " +
                    v.getVendedor().getNome() + " um veículo de placa " + 
                    v.getVeiculo().getPlaca() + " no valor de " + 
                    v.getValorVenda() + " (" + v.getValorComDesconto() + " com desconto) - " + (v.isLiberada() ? "LIBERADA" : "NÃO LIBERADA"));
        }
        return listaVendas;
    }
    
    public String[] autenticarGerente(String senha) {
        String[] retorno = new String[2];
        if(senha.equals(gerente.getSenha())) {
            retorno[0] = "0";
            retorno[1] = "Seja bem-vindo, " + gerente.getNome() + "!";
        }
        else {
            retorno[0] = "1";
            retorno[1] = "Senha inválida!";
        }
        return retorno;
    }
    
    public String[] autenticarVendedor(String cpf) {
        String[] retorno = new String[2];
        for(Vendedor v: vendedores) {
            if(cpf.equals(v.getCpf())) {
                retorno[0] = "0";
                retorno[1] = "Seja bem-vindo, " + v.getNome() + "!";
                return retorno;
            }
        }
        retorno[0] = "1";
        retorno[1] = "Não existe vendedor com esse cpf no sistema";
        return retorno;
    }
    
    public boolean liberarVenda(int codVenda) {
        for(Venda v: vendas) {
            if(v.getCodVenda() == codVenda) {
                v.setLiberada(true);
                return true;
            }
        }
        return false;
    }
    
    public boolean removerVenda(int codVenda) {
        for(Venda v: vendas) {
            if(codVenda == v.getCodVenda()) {
                vendas.remove(v);
                return true;
            }
        }
        return false;
    }
    
    public boolean removerVeiculo(String placa) {
        for(Veiculo v: veiculos) {
            if(placa.equals(v.getPlaca())) {
                veiculos.remove(v);
                return true;
            }
        }
        return false;
    }
}
