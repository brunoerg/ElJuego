/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whacamole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lb20-16
 */
public class Conexao {
    static final String DB_URL = "jdbc:mysql://localhost/eljuego?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    
    public void conectar(){
        try
        {
            connection = DriverManager.getConnection(DB_URL,"root","");
            statement = connection.createStatement();
            System.out.println("Conectou");
        }
        catch (SQLException e)
        {
            System.out.println("Erro ao conectar ao BD");
            System.out.println(e.getMessage());
        }
    }
    
    public void desconectar(){
       try{
           connection.close();
       }catch(SQLException ex){
           System.out.println("Erro a desconectar do BD");
       }
    }
}
