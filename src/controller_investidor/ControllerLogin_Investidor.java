package controller_investidor;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view_investidor.Login_Investidor;
import view_investidor.Menu_Investidor;

public class ControllerLogin_Investidor {
    private Login_Investidor view;

    public ControllerLogin_Investidor(Login_Investidor view) {
        this.view = view;
    }
    
    public void loginInvestidor(){
        Investidor investidor = new Investidor(null, view.getTxtCPF().getText(), view.getTxtSenha().getText());
        investidor.testeCPF(view.getTxtCPF().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Menu_Investidor mn = new Menu_Investidor();
                String senha = investidor.getSenha();
                ControllerDeposito.setSenhaLocal(senha);
                ControllerSaque.setSenhaLocal(senha);
                view.setVisible(false);
                mn.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(view, "Login não foi efetuado", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
