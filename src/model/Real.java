package model;

import javax.swing.JOptionPane;
import view_investidor.Deposito;


public class Real extends Moedas{
    private Deposito view;
    
    public Real() {
        
    }

    public Real(double saldo, double cotacao, String tipo, double taxacompra, double taxavenda) {
        super(saldo, cotacao, tipo, taxacompra, taxavenda);
    }

    public void depositar(double valor){
        saldo += valor;
        
    }
    
    public void sacar(double valor){
        if(valor > saldo){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            saldo -= valor;
        }  
    }
    public void exibirInformacoes(){
        System.out.println("-----INFORMACOES SOBRE A MOEDA-----");
        System.out.println("Nao há taxa de compra e venda para este tipo de moeda.");
    }
    
}
