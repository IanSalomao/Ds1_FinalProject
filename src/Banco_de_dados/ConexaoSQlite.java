package Banco_de_dados;

import java.sql.*;

import javax.lang.model.element.ExecutableElement;

public class ConexaoSQlite {
	
	private Connection conexao;

	public boolean conectar() {
        
        try {
            String url = "jdbc:sqlite:src/Banco_de_dados/banco_sqlite.db";
            this.conexao = DriverManager.getConnection(url);
            
            System.out.println("Conectou");         
            return true;
                       
        } catch(SQLException e) {
            System.out.println("\n" + e.getMessage());
            return false;
          }
    }
	
	public boolean desconectar() {
        
        try {
            if(this.conexao.isClosed() == false) {
                this.conexao.close();
            }
            
        } catch(SQLException e) {
            System.out.println("\n" + e.getMessage());
            return false;
        }
        System.out.println("Desconectou");
        return true;
    }
	
	public Statement criarStatement() {
		try {
			return this.conexao.createStatement();
					
		} catch (Exception e) {
			return null;
		}
	}
	
	public Connection getConexao() {
		return this.conexao;
	}
	
	public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }
	
	
	
}

