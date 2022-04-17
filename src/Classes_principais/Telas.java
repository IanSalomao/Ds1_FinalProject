package Classes_principais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Banco_de_dados.ConexaoSQlite;

public class Telas {
	
	Scanner sc = new Scanner(System.in);
	
	public String telaDeLogin(ConexaoSQlite con) {
		ResultSet resultSet = null;
		Statement statement = null;
		//Tela de login
		System.out.println("\n#======== TELA DE LOGIN ========#");
		System.out.print("Nome: ");
		String login_nome = sc.nextLine();
		System.out.print("Senha: ");
		String login_senha = sc.nextLine();
		
		String sqlLogin = "SELECT nome,senha,cargo FROM funcionarios WHERE nome = '"+login_nome+"' AND senha = '"+login_senha+"'";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(sqlLogin);
			return resultSet.getString("cargo");
			
		} catch (SQLException e) {
			System.out.println("\n** Usuário ou senha invalido **\n******  Tente novamente  ******");
	
			return telaDeLogin(con);
			
//			if(sc.nextInt() == 1) {
//				return telaDeLogin(con);
//			} else {
//				return "false";
//			}
			
		} finally {
			try {
				resultSet.close();
				statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void telaGerente(Gerente gerente, ConexaoSQlite con) {
		
		System.out.println("[ 1 ] Ver funcionários");
		System.out.println("[ 2 ] Ver ordens de serviço");
		System.out.println("[ 3 ] Ver clientes");
		System.out.println("[ 4 ] Adicionar funcionário");
		System.out.println("[ 5 ] Excluir funcionário");
		int resposta = sc.nextInt();

		
		switch (resposta) {
		case 1: {
			gerente.getFuncionarios(con);
			break;
		} case 2: {
			gerente.getOrdensDeServiso(con);
			break;
		} case 3: {
			gerente.getClientes(con);
			break;
		} case 4: {
			System.out.println("=== Insira os dados ===");
			System.out.println("Nome: ");
			String nome = sc.nextLine();
			System.out.println("CPF: ");
			String CPF = sc.nextLine();
			System.out.println("Senha: ");
			String senha = sc.nextLine();
			System.out.println("Cargo: ");
			String cargo = sc.nextLine();
			
			Funcionario funcionario = new Funcionario(nome,CPF,senha,cargo);
			gerente.addFuncionario(con, funcionario);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
		
	}
	
	
}
