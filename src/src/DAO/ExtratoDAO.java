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

/**
 *
 * @author xblak
 */
public class ExtratoDAO {
    private Connection conn;

    public ExtratoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Investidor investidor) throws SQLException{
        String sql = "select * from extrato where \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado; 
    }
    
    public void inserir(String senha, String tipo, double valor, String moeda, double cotacao, double taxa) throws SQLException{
        String sql = "insert into extrato(\"Senha\", \"Tipo\", \"Valor\", \"Moeda\", \"Cotacao\", \"Taxa\") values('"+
                senha     + "', '" +
                tipo  + "', '" +
                valor + "', '" + moeda + "', '" + cotacao + "', '" + taxa + "')";
        System.out.println(sql);
        System.out.println("0");
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
