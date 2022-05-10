package Classes_principais;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Banco_de_dados.ConexaoSQlite;

public class Mecanico extends Funcionario{
	
	//Construtor
	public Mecanico(String nome, String CPF, String senha, String cargo) {
        super(nome, CPF, senha, cargo);
        this.cargo = "Mecanico";
    }
	
	//---------------------------------------------------------------#
    
	//Retorna a lista de todas as ordens de serviso no baco de dados
	public void getOrdensDeServiso(ConexaoSQlite con) {
			ResultSet resultSet = null;
			Statement statement = null;
			
			String sql = "SELECT * FROM ordens_de_servico";
			statement = con.criarStatement();
			
			try {
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					System.out.println("----------------------");
					System.out.println(" ID       = "+resultSet.getInt("id"));
					System.out.println(" Placa    = "+resultSet.getString("placa_cliente"));
					System.out.println(" Problema = "+resultSet.getString("problema"));
				}
				
			} catch(SQLException e) {
				System.out.println(e);
				
			} finally {			
				try {
					resultSet.close();
					statement.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	//Retorna os orçamentos do mecanico em expecifico
	public void getMeusOrcamentos(ConexaoSQlite con) {
		ResultSet resultSet = null;
		Statement statement = null;
		
		String sql = "SELECT * FROM orcamentos WHERE cpf_mecanico = '"+ CPF +"' ";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("----------------------");
				System.out.println(" ID       = "+resultSet.getInt("id"));
				System.out.println(" Placa    = "+resultSet.getString("placa_cliente"));
				System.out.println(" Problema = "+resultSet.getString("problema"));
			}
			
		} catch(SQLException e) {
			System.out.println(e);
			
		} finally {			
			try {
				resultSet.close();
				statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Adciona orçamento
    public void addOrcamento(ConexaoSQlite con, Orcamento orcamento, String idOrdem){
       
    	String sql = "INSERT INTO orcamentos VALUES(NULL,'"
    			+orcamento.placa_cliente+"','"
    			+orcamento.problema+"','"
    			+orcamento.cpfMecanico+"','"
    			+orcamento.valor+"','"
    			+orcamento.servicos+"')";
    	
    	PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
		try {
			preparedStatement.execute();
			System.out.println("Orçamento adicionado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql0 = "DELETE FROMf ordens_de_servico WHERE id = "+idOrdem;

    	PreparedStatement preparedStatement0 = con.criarPreparedStatement(sql0);
		try {
			preparedStatement0.execute();
			System.out.println("Ordem de serviso transformada em orçamento!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    	
}