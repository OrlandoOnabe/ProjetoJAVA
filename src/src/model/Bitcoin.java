package model;

import javax.swing.JOptionPane;
import view_investidor.CompraCriptomoedas;


public class Bitcoin extends Moedas implements Tarifacao{
    public double saldoBitcoin;
    private CompraCriptomoedas view;
    
    public Bitcoin() {
    }

    public Bitcoin(double saldoBitcoin, double saldo, double cotacao, String tipo) {
        super(saldo, cotacao, tipo);
        this.saldoBitcoin = saldoBitcoin;
    }

    public void compra(double valor){
        System.out.println("oi");
        double valorReal = valor * cotacao;
        if(valorReal > saldo){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double taxa = valorReal * 0.01;
            double valorcompra = valorReal + taxa;
            saldo -= valorcompra;
            saldoBitcoin += valor;
        }
    }

    public void venda(double valor){
        System.out.println("oi");
        double valorReal = valor * cotacao;
        if(valor > saldoBitcoin){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double taxa = valorReal * 0.01;
            double valorvenda = valorReal - taxa;
            saldo += valorvenda;
            saldoBitcoin -= valor;
        }
    }

    public double getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public void setSaldoBitcoin(double saldoBitcoin) {
        this.saldoBitcoin = saldoBitcoin;
    }
    
    
}
