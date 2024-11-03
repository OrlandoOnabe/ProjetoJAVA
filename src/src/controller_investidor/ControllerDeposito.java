/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_investidor;

import DAO.CarteiraDAO;
import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import model.Moedas;
import model.Real;
import view_investidor.Deposito;

public class ControllerDeposito {
    private Deposito view;
    private static String SENHA;
    
    public ControllerDeposito(Deposito view) {
        this.view = view;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public static void setSENHA(String SENHA) {
        ControllerDeposito.SENHA = SENHA;
    }
    
    public void depositoReal(){
        Investidor investidor = new Investidor(null, null, SENHA);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CarteiraDAO dao = new CarteiraDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                double saldo = res.getDouble("Real");
                Real real = new Real(saldo, 0, null);
                double deposito = Double.parseDouble(view.getTxtDepositar().getText());
                real.depositar(deposito);
                double novo_saldo = real.saldo;
                System.out.println(novo_saldo);
                view.getTxtSaldo().setText(String.valueOf(novo_saldo));
                Moedas moedas = new Moedas(novo_saldo, 0, null);
                dao.atualizar(moedas, investidor);
                JOptionPane.showMessageDialog(view, "Deposito feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
 
}
