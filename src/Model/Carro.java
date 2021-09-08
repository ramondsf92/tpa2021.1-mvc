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
public class Carro extends Veiculo {
    private String carroceria;
    private String direcao;

    public Carro(String placa, String modelo, String ano, String motor, double preco, String cambio, String combustivel, String carroceria, String direcao) {
        super(placa, modelo, ano, motor, preco, cambio, combustivel);
        this.carroceria = carroceria;
        this.direcao = direcao;
    }
    
    
}
