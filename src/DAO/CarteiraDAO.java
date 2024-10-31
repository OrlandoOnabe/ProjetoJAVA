/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Investidor;
import model.Moedas;

/**
 *
 * @author xblak
 */
public class CarteiraDAO {
    private Connection conn;

    public CarteiraDAO(Connection conn) {
        this.conn = conn;
    }
    public ResultSet consultar(Investidor carteira) throws SQLException{
        String sql = "select * from carteira where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, carteira.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado; 
    }
    
    public void atualizar(Moedas saldo, Investidor senha) throws SQLException{
        String sql = "update carteira set \"Real\" = ? where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, saldo.getSaldo());
        statement.setString(2, senha.getSenha());
        statement.execute();
        conn.close();
    }
}
