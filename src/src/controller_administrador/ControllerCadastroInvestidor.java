/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_administrador;

import DAO.CarteiraDAO;
import view_administrador.Cadastrar_Investidor;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DAO.Conexao;
import DAO.InvestidorDAO;
import model.Investidor;
import model.Moedas;
/**
 *
 * @author xblak
 */
public class ControllerCadastroInvestidor {
    private Cadastrar_Investidor view;

    public ControllerCadastroInvestidor(Cadastrar_Investidor view) {
        this.view = view;
    }
    
    public void cadastroInvestidor(){
        Investidor investidor = new Investidor(view.getTxtNome().getText(), view.getTxtCPF().getText(), view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.inserir(investidor);
            Moedas moedas = new Moedas(0, 0, null);
            conn = conexao.getConnection();
            CarteiraDAO dao2 = new CarteiraDAO(conn);
            dao2.inserir(investidor, moedas);
            JOptionPane.showMessageDialog(view, "Investidor cadastrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
