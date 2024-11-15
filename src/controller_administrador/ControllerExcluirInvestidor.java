/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_administrador;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view_administrador.Excluir_Investidor;

/**
 *
 * @author xblak
 */
public class ControllerExcluirInvestidor {
    private Excluir_Investidor view;

    public ControllerExcluirInvestidor(Excluir_Investidor view) {
        this.view = view;
    }
    
    public void excluirInvestidor(){
        String cpf = view.getTxtCPF().getText();
        Investidor investidor = new Investidor(null, cpf, null);
        int opcao = JOptionPane.showConfirmDialog(view, "Deseja REALMENTE excluir o investidor?", "Aviso", JOptionPane.YES_NO_OPTION);
        if(opcao != 1){
            Conexao conexao = new Conexao();
            try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.remover(investidor);
            JOptionPane.showMessageDialog(view, "Investidor removido com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
           } catch(SQLException e){
               JOptionPane.showMessageDialog(view, "Erro ao remover", "Erro", JOptionPane.ERROR_MESSAGE);
           }
        }
    }
}
