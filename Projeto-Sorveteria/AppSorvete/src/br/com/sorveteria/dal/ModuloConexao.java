package br.com.sorveteria.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {
    // método responsavel por estabelecer a conexão com o banco.
    public static Connection conector(){
        //cria variavel conection
        java.sql.Connection conexao = null;
        //a linha abaixo chama o driver importado em biblotecas
        String driver = "com.mysql.jdbc.Driver";
        // criando variaveis para armazenar informações referente ao banco
        String url = "jdbc:mysql://localhost:3306/sorveteria?autoReconnect=true&useSSL=false";
        //criando variavel que armazena login do banco de dados
        String user = "root";
        //Variavel que armazena senha do banco de dados
        String password = "";        
        //Estabelecendo conexão com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //Instrução de apoio para mostrar erro que está dando no banco de dados
            System.out.println(e);
            return null;
        }
    }
}
