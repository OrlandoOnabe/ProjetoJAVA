/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_administrador;

import DAO.CarteiraDAO;
import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view_administrador.SaldoDoInvestidor;

/**
 *
 * @author xblak
 */
public class ControllerSaldo {
    private SaldoDoInvestidor view;

    public ControllerSaldo(SaldoDoInvestidor view) {
        this.view = view;
    }
    
    public void consultarSaldo(){
        Investidor investidor = new Investidor(null, view.getTxtCpf().getText(), null);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CarteiraDAO dao = new CarteiraDAO(conn);
            ResultSet res = dao.consultarcpf(investidor);
            if(res.next()){
                String senha = res.getString("Senha");
                Double saldo_real = res.getDouble("Real");
                Double saldo_ethereum = res.getDouble("Ethereum");
                Double saldo_ripple = res.getDouble("Ripple");
                Double saldo_bit = res.getDouble("Bitcoin");
                Investidor investidor1 = new Investidor(null, view.getTxtCpf().getText(), senha);
                InvestidorDAO dao2 = new InvestidorDAO(conn);
                res = dao2.consultar(investidor1);
                if(res.next()){
                    String nome = res.getString("Nome");
                    view.getTxtSaldo().setText("Nome: " + nome + " CPF: " + view.getTxtCpf().getText() + "\n Real: " + saldo_real + " Ethereum: " + saldo_ethereum + " Ripple: " + saldo_ripple + " Bitcoin: " + saldo_bit);
                }
                
            }else{
                JOptionPane.showMessageDialog(view, "Não foi encontrado uma conta vinculado a esse cpf", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
