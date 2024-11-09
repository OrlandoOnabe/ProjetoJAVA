package model;

import javax.swing.JOptionPane;
import view_investidor.CompraCriptomoedas;


public class Bitcoin extends Moedas implements Tarifacao{
    public double saldoBitcoin;
    private CompraCriptomoedas view;
    public double taxaCompra = 0.02;
    public double taxaVenda = 0.03;
    
    public Bitcoin() {
    }

    public Bitcoin(double saldoBitcoin, double saldo, double cotacao, String tipo) {
        super(saldo, cotacao, tipo);
        this.saldoBitcoin = saldoBitcoin;
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
            saldoBitcoin += valor;
        }
    }

    public void venda(double valor){
        double valorReal = valor * cotacao;
        if(valor > saldoBitcoin){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double taxa = valorReal * taxaVenda;
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
