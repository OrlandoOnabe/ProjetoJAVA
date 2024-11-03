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
import model.Ripple;

/**
 *
 * @author xblak
 */
public class MoedasDAO {
    private Connection conn;

    public MoedasDAO(Connection conn) {
        this.conn = conn;
    }
    public ResultSet consultarmoeda(Moedas moedas) throws SQLException{
        String sql = "select * from moeda where \"Tipo\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, moedas.getTipo());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado; 
    }
    
}
