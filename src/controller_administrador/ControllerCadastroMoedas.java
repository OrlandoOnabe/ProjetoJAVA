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
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Moedas;
import view_administrador.Cadastrar_Criptomoeda;

public class ControllerCadastroMoedas {
    private Cadastrar_Criptomoeda view;

    public ControllerCadastroMoedas(Cadastrar_Criptomoeda view) {
        this.view = view;
    }
    
    public void cadastrarMoedas(){
        Moedas novamoeda = new Moedas(0, Double.parseDouble(view.getTxtCotacao().getText()), view.getTxtNome().getText(), Double.parseDouble(view.getTxtTaxacompra().getText()), Double.parseDouble(view.getTxtTaxaVenda().getText()));
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            MoedasDAO dao = new MoedasDAO(conn);
            dao.inserirmoeda(novamoeda);
            JOptionPane.showMessageDialog(view, "Moeda cadastrada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
