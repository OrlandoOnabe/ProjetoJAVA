package model;

import javax.swing.JOptionPane;
import view_investidor.CompraCriptomoedas;


public class Ethereum extends Moedas implements Tarifacao{
    public double saldoEthereum;
    private CompraCriptomoedas view;
    
    public Ethereum() {
    }

    public Ethereum(double saldoEthereum, double saldo, double cotacao, String tipo, double taxacompra, double taxavenda) {
        super(saldo, cotacao, tipo, taxacompra, taxavenda);
        this.saldoEthereum = saldoEthereum;
    }

    

    

    public void compra(double valor, double taxa){
        double valorReal = valor * cotacao;
        if(valorReal > saldo){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double valorcompra = valorReal + taxacompra;
            saldo -= valorcompra;
            saldoEthereum += valor;
            JOptionPane.showMessageDialog(view, "Compra efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void venda(double valor, double taxa){
        double valorReal = valor * cotacao;
        if(valor > saldoEthereum){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double valorvenda = valorReal - taxavenda;
            saldo += valorvenda;
            saldoEthereum -= valor;
            JOptionPane.showMessageDialog(view, "Venda efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public double getSaldoEthereum() {
        return saldoEthereum;
    }

    public void setSaldoEthereum(double saldoEthereum) {
        this.saldoEthereum = saldoEthereum;
    }


    
}
