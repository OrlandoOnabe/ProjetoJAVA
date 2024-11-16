package model;

import javax.swing.JOptionPane;
import view_investidor.CompraCriptomoedas;


public class Bitcoin extends Moedas implements Tarifacao{
    public double saldoBitcoin;
    private CompraCriptomoedas view;
    
    public Bitcoin() {
    }

    public Bitcoin(double saldoBitcoin, double saldo, double cotacao, String tipo, double taxacompra, double taxavenda) {
        super(saldo, cotacao, tipo, taxacompra, taxavenda);
        this.saldoBitcoin = saldoBitcoin;
    }

    
    

    public void compra(double valor, double taxa){
        double valorReal = valor * cotacao;
        if(valorReal > saldo){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double valorcompra = valorReal + taxacompra;
            saldo -= valorcompra;
            saldoBitcoin += valor;
            JOptionPane.showMessageDialog(view, "Compra efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void venda(double valor, double taxa){
        double valorReal = valor * cotacao;
        if(valor > saldoBitcoin){
             JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double valorvenda = valorReal - taxavenda;
            saldo += valorvenda;
            saldoBitcoin -= valor;
            JOptionPane.showMessageDialog(view, "Venda efetuada com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public double getSaldoBitcoin() {
        return saldoBitcoin;
    }

    public void setSaldoBitcoin(double saldoBitcoin) {
        this.saldoBitcoin = saldoBitcoin;
    }
    
    
}
