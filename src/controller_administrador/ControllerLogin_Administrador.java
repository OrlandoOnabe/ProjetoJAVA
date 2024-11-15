package controller_administrador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import DAO.Conexao;
import DAO.AdministradorDAO;
import model.Administrador;
import view_administrador.Login_Administrador;
import view_administrador.Menu_Administrador;

public class ControllerLogin_Administrador {
    private Login_Administrador view;

    public ControllerLogin_Administrador(Login_Administrador view) {
        this.view = view;
    }
    
    public void loginAdministrador(){
        Administrador administrador = new Administrador(null, view.getTxtCpf().getText(), view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AdministradorDAO dao = new AdministradorDAO(conn);
            ResultSet res = dao.consultar(administrador);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Menu_Administrador mn = new Menu_Administrador();
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
