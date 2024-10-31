package model;

import javax.swing.JOptionPane;
import view_investidor.Deposito;


public class Real extends Moedas{
    private Deposito view;
    
    public Real() {
        
    }

    public Real(double saldo) {
        super(saldo);
    }

    public void depositar(double valor){
        saldo += valor;
        
    }
    
    public void sacar(double valor){
        if(saldo == 0){
            JOptionPane.showMessageDialog(view, "Saldo zero", "Erro", JOptionPane.ERROR_MESSAGE);
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
