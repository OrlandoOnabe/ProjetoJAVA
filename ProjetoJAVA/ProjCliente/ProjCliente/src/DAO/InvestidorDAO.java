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
public class InvestidorDAO {
    private Connection conn;

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Investidor pessoa) throws SQLException{
        String sql = "select * from investidor where \"Cpf\" = ? AND \"Senha\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCPF());
        statement.setString(2, String.valueOf(pessoa.getSenha()));
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado; 
    }
    
    public void inserir(Investidor pessoa) throws SQLException{
        String sql = "insert into investidor(\"Nome\", \"Cpf\", \"Senha\") values('"+
                pessoa.getNome()     + "', '" +
                pessoa.getCPF()  + "', '" +
                pessoa.getSenha()    + "')";
        System.out.println(sql);
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
}
