package Classes_principais;

//Imports
import java.sql.*;
import Banco_de_dados.ConexaoSQlite;

public class Recepcionista extends Funcionario{
	
	//Construtor
	public Recepcionista(String nome, String CPF, String senha, String cargo) {
		
        super(nome, CPF, senha, cargo);
        this.cargo = "Recepcionista";  
    }
	
	//---------------------------------------------------------------#
	
	//Retorna lista de clientes
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
	
	//Retorna ordens de serviso
	public void getOrdensDeServiso(ConexaoSQlite con) {
		ResultSet resultSet = null;
		Statement statement = null;
		
		String query = "SELECT * FROM ordens_de_servico";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("----------------------");
				System.out.println(" ID            = "+resultSet.getInt("id"));
				System.out.println(" Placa_cliente = "+resultSet.getString("placa_cliente"));
				System.out.println(" Problema      = "+resultSet.getString("problema"));
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
	
	//Adiciona cliente
	public void addCliente(ConexaoSQlite con, Cliente cliente) {
		String sql = "INSERT INTO cliente VALUES(NULL,'"
				+cliente.nome+"','"
				+cliente.CPF+"','"
				+cliente.email+"','"
				+cliente.telefone+"','"
				+cliente.endereco+"','"
				+cliente.placa+"')";
			
				PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
				try {
					preparedStatement.execute();
					System.out.println("Cliente "+ cliente.nome +" foi adicionado(a)!");
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}
	
	//Adiciona ordem de serviço
	public void addOrdemDeServico(ConexaoSQlite con, OrdemDeServico ordemDeServico) {
		String sql = "INSERT INTO ordens_de_servico VALUES(NULL,'"
				+ordemDeServico.placa_cliente+"','"
				+ordemDeServico.problema+"')";
			
				PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
				try {
					preparedStatement.execute();
					System.out.println("Ordem de serviso adicionado(a)!");
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
		}

	//Excluir cliente
	public void delCliente(ConexaoSQlite con, int id) {
		String sql = "DELETE FROM cliente WHERE id =" + id;
		
		PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
		try {
			preparedStatement.execute();
			System.out.println("cliente deletado!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	//Excluir ordem de seviço
	public void delOrdemDeServico(ConexaoSQlite con, int id) {
		String sql = "DELETE FROM ordens_de_servico WHERE id =" + id;
		
		PreparedStatement preparedStatement = con.criarPreparedStatement(sql);
		try {
			preparedStatement.execute();
			System.out.println("Ordem de serviço deletada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
		
}