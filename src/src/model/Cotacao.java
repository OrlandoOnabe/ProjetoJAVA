/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xblak
 */
import java.util.Random;
public class Cotacao extends Moedas{
    private Random random = new Random();
    public double nova_cotacao;

    public Cotacao() {
    }
    
    public Cotacao(double saldo, double cotacao, String tipo) {
        super(saldo, cotacao, tipo);
    }
    
    public void atualizarCotacao(double antigaCotacao){
        double varicao = (random.nextDouble() * 0.1) - 0.05;
        nova_cotacao = (antigaCotacao * varicao) + cotacao; 
    }
}
