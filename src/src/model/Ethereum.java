package model;

import javax.swing.JOptionPane;
import view_investidor.CompraCriptomoedas;


public class Ethereum extends Moedas implements Tarifacao{
    public double saldoEthereum;
    private CompraCriptomoedas view;
    
    public Ethereum() {
    }

    public Ethereum(double saldoEthereum, double saldo, double cotacao, String tipo) {
        super(saldo, cotacao, tipo);
        this.saldoEthereum = saldoEthereum;
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
            saldoEthereum += valor;
        }
    }

    public void venda(double valor){
        System.out.println("oi");
        double valorReal = valor * cotacao;
        if(valor > saldoEthereum){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double taxa = valorReal * 0.01;
            double valorvenda = valorReal - taxa;
            saldo += valorvenda;
            saldoEthereum -= valor;
        }
    }
    
    public double getSaldoEthereum() {
        return saldoEthereum;
    }

    public void setSaldoEthereum(double saldoEthereum) {
        this.saldoEthereum = saldoEthereum;
    }


    
}
