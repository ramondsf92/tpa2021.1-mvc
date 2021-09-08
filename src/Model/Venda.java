/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ramon
 */
public class Venda {
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;
    private int codVenda;
    private double valorVenda;
    private double valorComDesconto;
    private boolean liberada = false;

    public Venda(Vendedor vendedor, Cliente cliente, Veiculo veiculo, int codVenda, double valorVenda) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.codVenda = codVenda;
        this.valorVenda = valorVenda;
        this.valorComDesconto = valorVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public double getValorComDesconto() {
        return valorComDesconto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setLiberada(boolean liberada) {
        this.liberada = liberada;
    }

    public boolean isLiberada() {
        return liberada;
    }
    
    public boolean gerarDesconto(double desconto) {
        this.valorComDesconto = this.valorComDesconto - (this.valorComDesconto)*desconto;
        return true;
    }
    
}
