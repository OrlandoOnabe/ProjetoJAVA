package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Administrador;

public class AdministradorDAO {
    private Connection conn;

    public AdministradorDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Administrador administrador) throws SQLException{
        String sql = "select * from administrador where \"Cpf\" = ? AND \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, administrador.getCPF());
        statement.setString(2, administrador.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado; 
    }

}
