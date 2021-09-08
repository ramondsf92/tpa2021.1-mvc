/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ramon
 */
public class Vendedor extends Funcionario {
    
    private double comissao;
    private ArrayList<Venda> vendasRealizadas;
    
    public Vendedor(String cpf, String nome, String endereco, String email) {
        super(cpf, nome, endereco, email);
        this.comissao = 0.1;
        this.vendasRealizadas = new ArrayList();
    }
}
