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
public class Gerente extends Funcionario {
   
    private String senha;
    
    public Gerente(String cpf, String nome, String endereco, String email, String senha) {
        super(cpf, nome, endereco, email);
        this.senha = senha;
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean liberarVenda(Venda V) {
        return true;
    }
    
    public boolean liberarDesconto(Venda V) {
       return true; 
    }
    
    public void cadastrarVendedor(Vendedor V) {
        
    }
    
    public void cadastrarVeiculo(Veiculo V) {
        
    }
    
    public void liberarTestDrive(Veiculo V) {
        
    }
}
