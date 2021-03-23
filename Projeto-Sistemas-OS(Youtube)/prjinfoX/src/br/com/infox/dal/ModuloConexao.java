package br.com.infox.dal;

import java.sql.*;

public class ModuloConexao {
    // método responsavel por estabelecer a conexão com o banco.
    public static Connection conector(){
        java.sql.Connection conexao = null;
        //a linha abaixo chama o driver importado em biblotecas
        String driver = "com.mysql.jdbc.Driver";
        // criando variaveis para armazenar informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/dbinfox";
        String user = "root";
        String password = "root";   
        // estabelecendo conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // linha de apoio para saber o erro
           // System.out.println(e);
            return null;
        }         
    }
}
