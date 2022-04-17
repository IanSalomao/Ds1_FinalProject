package Classes_principais;

//  Imports
import java.sql.*;
import Banco_de_dados.ConexaoSQlite;

public class Gerente extends Funcionario{
	
	//Construtor
	public Gerente(String nome, String CPF, String senha, String cargo) {
	
	    super(nome, CPF, senha, cargo);
	    this.cargo = "Gerente";
	}
	
	//---------------------------------------------------------------#
	
	//Retorna a lista de todos os funcionários no baco de dados
	public void getFuncionarios(ConexaoSQlite con) {
		ResultSet resultSet = null;
		Statement statement = null;
		
		String sql = "SELECT * FROM funcionarios";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("----------------------");
				System.out.println(" ID    = "+resultSet.getInt("id"));
				System.out.println(" Nome  = "+resultSet.getString("nome"));
				System.out.println(" CPF   = "+resultSet.getString("cpf"));
				System.out.println(" Senha = "+resultSet.getString("senha"));
				System.out.println(" Cargo = "+resultSet.getString("cargo"));
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
	
	//Retorna a lista de todas as ordens de serviso no baco de dados
	public void getOrdensDeServiso(ConexaoSQlite con) {
		ResultSet resultSet = null;
		Statement statement = null;
		
		String query = "SELECT * FROM ordens_de_servico";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(query);
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
    
	//Retorna a lista de todos os clientes no baco de dados
	public void getClientes(ConexaoSQlite con) {
		ResultSet resultSet = null;
		Statement statement = null;
		
		String query = "SELECT * FROM cliente";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("----------------------");
				System.out.println(" ID       = "+resultSet.getInt("id"));
				System.out.println(" Nome     = "+resultSet.getString("nome"));
				System.out.println(" CPF      = "+resultSet.getString("cpf"));
				System.out.println(" Email    = "+resultSet.getString("email"));
				System.out.println(" Telefone = "+resultSet.getString("telefone"));
				System.out.println(" Endereço = "+resultSet.getString("endereco"));
				System.out.println(" Placa    = "+resultSet.getString("placa"));
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

	//Adiciona funcionários
	public void addFuncionario(ConexaoSQlite con, Funcionario funcionario) {
		
		String sql = "INSERT INTO funcionarios VALUES(NULL,'"
		+funcionario.nome+"','"
		+funcionario.CPF+"','"
		+funcionario.senha+"','"
		+funcionario.cargo+"')";
	
		PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
		try {
			preparedStatement.execute();
			System.out.println("Funcionário(a) "+ funcionario.nome +" adicionado(a)!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	//Excluir funcionário
	public void delFuncionario(ConexaoSQlite con, int id) {
		String sql = "DELETE FROM funcionarios WHERE id =" + id;
		
		PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
		try {
			preparedStatement.execute();
			System.out.println("Funcionário deletado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}