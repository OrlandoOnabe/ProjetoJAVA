/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_administrador;

/**
 *
 * @author xblak
 */
import DAO.Conexao;
import DAO.MoedasDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Moedas;
import view_administrador.Excluir_Criptomoeda;

public class ControllerExcluirMoedas {
    private Excluir_Criptomoeda view;

    public ControllerExcluirMoedas(Excluir_Criptomoeda view) {
        this.view = view;
    }
    
     public void excluirInvestidor(){
        String nome = view.getTxtNome().getText();
        Moedas moedas = new Moedas(0, 0, nome, 0, 0);
        int opcao = JOptionPane.showConfirmDialog(view, "Deseja REALMENTE excluir o investidor?", "Aviso", JOptionPane.YES_NO_OPTION);
        if(opcao != 1){
            Conexao conexao = new Conexao();
            try{
            Connection conn = conexao.getConnection();
            MoedasDAO dao = new MoedasDAO(conn);
            dao.removermoeda(moedas);
            JOptionPane.showMessageDialog(view, "Moeda removido com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
           } catch(SQLException e){
               JOptionPane.showMessageDialog(view, "Erro ao remover", "Erro", JOptionPane.ERROR_MESSAGE);
           }
        }
    }
}
