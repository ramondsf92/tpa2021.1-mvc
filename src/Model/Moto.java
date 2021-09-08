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
public class Moto extends Veiculo {
    private String ignicao;

    public Moto(String placa, String modelo, String ano, String motor, double preco, String cambio, String combustivel, String ignicao) {
        super(placa, modelo, ano, motor, preco, cambio, combustivel);
        this.ignicao = ignicao;
    }
    
    
}
