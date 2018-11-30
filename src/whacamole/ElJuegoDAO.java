/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whacamole;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lb20-16
 */
public class ElJuegoDAO {
    Conexao con;
    public static int id_userBest;
    public static int id_user;
    public static int pontuacao;
    public static int melhor_pontuacao;
    public static String nome_usuario;
    public static String nome_melhor;
    
    public void cadastroUSsuario(String sql){
        try{
            con = new Conexao();
            con.conectar();
            System.out.println("Classe DAO: "+sql);
            PreparedStatement prepst = con.connection.prepareStatement(sql);
            prepst.executeUpdate();
        }catch(Exception e){
            System.out.println("Erro ao inserir dados");
            System.out.println(e.getMessage());
        }
        finally{
            con.desconectar();
        }
    }
    
    public boolean busca(String sql){
        try{
            con = new Conexao();
            con.conectar();
            //statement = con.connection.createStatement();

            System.out.println("Classe Dao: " +sql);
            
            con.resultSet = con.statement.executeQuery(sql);
            if(con.resultSet.next()){
                id_user = con.resultSet.getInt("id");
                nome_usuario = con.resultSet.getString("username");
                String teste2 =  con.resultSet.getString("password");
                System.out.println("id: "+ id_user + "Nome:"+nome_usuario + " senha: " + teste2);
                
                con.resultSet = con.statement.executeQuery("SELECT pontuation FROM games WHERE id_user ="+ id_user + " ORDER BY id_partida DESC LIMIT 1");
                if(con.resultSet.next()){
                    pontuacao = con.resultSet.getInt("pontuation");
                }
                return true;
            }
            else System.out.println("Usuario/senha nao encontrado");
        }catch(Exception e){
            System.out.println("Erro ao buscar usuario");
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            System.err.println(e.getStackTrace());
            return false;
        }
        finally{
            con.desconectar();
        }
        return false;
    }
    
    public void cadastroPartida(String sql){
        try{
            con = new Conexao();
            con.conectar();
            
            System.out.println("Classe DAO: "+sql);
            PreparedStatement prepst = con.connection.prepareStatement(sql);
            prepst.executeUpdate();
            
        }catch(Exception e){
            System.out.println("Erro ao Cadastrar Partida");
            System.out.println(e.getMessage());
        }
    }
    
    public void oMelhor(){
        try{
            con = new Conexao();
            con.conectar();
            //statement = con.connection.createStatement();

            String sql = "SELECT pontuation, id_user FROM games WHERE pontuation = (SELECT MAX(pontuation) FROM games)";
            
            con.resultSet = con.statement.executeQuery(sql);
            if(con.resultSet.next()){
                melhor_pontuacao = con.resultSet.getInt("pontuation");
                id_userBest = con.resultSet.getInt("id_user");
                
                String query = "SELECT username FROM user WHERE id = ?";
                PreparedStatement prep = con.connection.prepareStatement(query);
                prep.setInt(1, id_userBest);
                
                ResultSet result = prep.executeQuery();
                result.first();
                nome_melhor = result.getString(1);
                //con.resultSet = con.statement.executeQuery(query);
                //nome_melhor = con.resultSet.getString("username");
                
                
            }
            else System.out.println("Erro ao encontrar");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            System.err.println(Arrays.toString(e.getStackTrace()));
    
        }
        finally{
            con.desconectar();
        }
    }
    
    public void cadastroPontuacao(float pontuacao){
         try{
            con = new Conexao();
            con.conectar();
            //statement = con.connection.createStatement();
            String sql = "SELECT id_partida FROM games ORDER BY id_partida DESC LIMIT 1";
            
            con.resultSet = con.statement.executeQuery(sql);
            if(con.resultSet.next()){
                int idPartida = con.resultSet.getInt("id_partida");
                System.out.println(idPartida);
                String sqlIn = "UPDATE games SET pontuation = ? WHERE id_partida = ?";
                PreparedStatement prepst = con.connection.prepareStatement(sqlIn);
                prepst.setFloat(1, pontuacao);
                prepst.setInt(2, idPartida);
                prepst.executeUpdate();
            }
            else System.out.println("Erro ao encontrar ");
        }catch(SQLException e){
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
            System.err.println(Arrays.toString(e.getStackTrace()));
    
        }
        finally{
            con.desconectar();
        }
    }
}
