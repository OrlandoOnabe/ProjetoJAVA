/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.JOptionPane;
import view_investidor.CompraCriptomoedas;

/**
 *
 * @author xblak
 */
public class Ripple extends Moedas implements Tarifacao{
    public double saldoRipple;
    private CompraCriptomoedas view;
    public double taxaCompra = 0.01;
    public double taxaVenda = 0.01;

    public Ripple() {
    }

    public Ripple(double saldoRipple, double saldo, double cotacao, String tipo) {
        super(saldo, cotacao, tipo);
        this.saldoRipple = saldoRipple;
    }
    
    
    public void compra(double valor){
        double valorReal = valor * cotacao;
        if(valorReal > saldo){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double taxa = valorReal * taxaCompra;
            double valorcompra = valorReal + taxa;
            saldo -= valorcompra;
            saldoRipple += valor;
        }
    }

    public void venda(double valor){
        double valorReal = valor * cotacao;
        if(valor > saldoRipple){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double taxa = valorReal * taxaVenda;
            double valorvenda = valorReal - taxa;
            saldo += valorvenda;
            saldoRipple -= valor;
        }
    }

    public double getSaldoRipple() {
        return saldoRipple;
    }

    public void setSaldoRipple(double saldoRipple) {
        this.saldoRipple = saldoRipple;
    }
    
    
}
