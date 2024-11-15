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

    public Ripple() {
    }

    public Ripple(double saldoRipple, double saldo, double cotacao, String tipo, double taxacompra, double taxavenda) {
        super(saldo, cotacao, tipo, taxacompra, taxavenda);
        this.saldoRipple = saldoRipple;
    }

    public void compra(double valor, double taxa){
        double valorReal = valor * cotacao;
        if(valorReal > saldo){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double valorcompra = valorReal + taxacompra;
            saldo -= valorcompra;
            saldoRipple += valor;
        }
    }

    public void venda(double valor, double taxa){
        double valorReal = valor * cotacao;
        if(valor > saldoRipple){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double valorvenda = valorReal - taxavenda;
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
