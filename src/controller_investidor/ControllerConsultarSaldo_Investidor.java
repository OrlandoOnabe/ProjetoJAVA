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
import view_investidor.Consultar_saldo;

/**
 *
 * @author xblak
 */
public class ControllerConsultarSaldo_Investidor {
    private Consultar_saldo view;

    public ControllerConsultarSaldo_Investidor(Consultar_saldo view) {
        this.view = view;
    }
    
    public void consultarCarteira(){
        Investidor investidor = new Investidor(null, null, view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            CarteiraDAO dao = new CarteiraDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                String cpf = res.getString("Cpf");
                Double saldo_real = res.getDouble("Real");
                Double saldo_ethereum = res.getDouble("Ethereum");
                Double saldo_ripple = res.getDouble("Ripple");
                Double saldo_bit = res.getDouble("Bitcoin");
                Investidor investidor1 = new Investidor(null, cpf, view.getTxtSenha().getText());
                InvestidorDAO dao2 = new InvestidorDAO(conn);
                ResultSet res2 = dao2.consultar(investidor1);
                if(res2.next()){
                    String nome = res2.getString("Nome");
                    view.getTxtSaldo().setText("Nome: " + nome + " CPF: " + cpf + "\n Real: " + saldo_real + " Ethereum: " + saldo_ethereum + " Ripple: " + saldo_ripple + " Bitcoin: " + saldo_bit);
                }
                //JOptionPane.showMessageDialog(view, "Achei tua carteira irmão", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                JOptionPane.showMessageDialog(view, "Não foi encontrado uma conta vinculado a essa senha", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
