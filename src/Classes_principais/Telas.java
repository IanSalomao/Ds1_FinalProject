package Classes_principais;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Banco_de_dados.ConexaoSQlite;

public class Telas {
	
	Scanner sc = new Scanner(System.in);
	
	//Tela de login
	public String telaDeLogin(ConexaoSQlite con,String login_nome,String login_senha) {
		ResultSet resultSet = null;
		Statement statement = null;
		
		String sqlLogin = "SELECT id,nome,senha,cargo FROM funcionarios WHERE nome = '"+login_nome+"' AND senha = '"+login_senha+"'";
		statement = con.criarStatement();
		
		try {
			resultSet = statement.executeQuery(sqlLogin);
			return resultSet.getString("cargo") ;
			
		} catch (SQLException e) {
			System.out.println("\n** Usuário ou senha invalido **\n******  Tente novamente  ******");
			System.out.println("\n#======== TELA DE LOGIN ========#");
			System.out.print("Nome: ");
			String newLogin_nome = sc.nextLine();
			System.out.print("Senha: ");
			String newLogin_senha = sc.nextLine();
			
			return telaDeLogin(con,newLogin_nome,newLogin_senha);
			
		} finally {
			try {
				resultSet.close();
				statement.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Tela do gerente
	public void telaGerente(Gerente gerente, ConexaoSQlite con) {	
		System.out.println("[ 1 ] Ver funcionários");
		System.out.println("[ 2 ] Ver ordens de serviço");
		System.out.println("[ 3 ] Ver clientes");
		System.out.println("[ 4 ] Adicionar funcionário");
		System.out.println("[ 5 ] Excluir funcionário");
		String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1": {
			gerente.getFuncionarios(con);
			break;
		} case "2": {
			gerente.getOrdensDeServiso(con);
			break;
		} case "3": {
			gerente.getClientes(con);
			break;
		} case "4": {
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
			break;
			
		} case "5": {
			System.out.println("Insira o id do funcionário a ser deletado\nid: ");
			gerente.delFuncionario(con, sc.nextInt());
			break;
			
		}
		default:
			System.out.println("Opção inválida");
			
		}
		
		System.out.println("Deseja continuar? [S / N]");
		String continuar = sc.nextLine();
		switch (continuar) {
		case "S": {
			telaGerente(gerente, con);
			break;
		} case "N": {
			System.out.println("Programa encerado!");
			break;
		}
		default:
			System.out.println("Opção inválida, o programa será enserrado...");
			break;
		}
	
	}
	
	//Tela do recepcionista
	public void telaRecepcionista(Recepcionista recepcionista, ConexaoSQlite con) {
		System.out.println("[ 1 ] Ver clientes");
		System.out.println("[ 2 ] Ver ordens de serviço");
		System.out.println("[ 3 ] Adicionar clientes");
		System.out.println("[ 4 ] Adicionar ordem de serviço");
		System.out.println("[ 5 ] Excluir cliente");
		System.out.println("[ 6 ] Excluir ordem de serviço");
		String resposta = sc.nextLine();		
		switch (resposta) {
		case "1": {
			recepcionista.getClientes(con);
			break;
			
		} case "2": {
			recepcionista.getOrdensDeServiso(con);
			break;
			
		} case "3": {
			System.out.println("=== Insira os dados ===");
			System.out.println("Nome: ");
			String nome = sc.nextLine();
			System.out.println("CPF: ");
			String CPF = sc.nextLine();
			System.out.println("Email: ");
			String email = sc.nextLine();
			System.out.println("Telefone: ");
			String telefone = sc.nextLine();
			System.out.println("Endereço: ");
			String endereco = sc.nextLine();
			System.out.println("Placa: ");
			String placa = sc.nextLine();

			Cliente cliente = new Cliente(nome,CPF,email,telefone,endereco,placa);
			recepcionista.addCliente(con, cliente);
			break;
			
		} case "4": {
			System.out.println("=== Insira os dados ===");
			System.out.println("Placa_cliente: ");
			String placa_cliente = sc.nextLine();
			System.out.println("Problema: ");
			String problema = sc.nextLine();
			
			OrdemDeServico ordem = new OrdemDeServico(placa_cliente, problema);
			recepcionista.addOrdemDeServico(con, ordem);
			break;
			
		} case "5": {
			System.out.println("Insira o id do cliente a ser deletado\nid: ");
			recepcionista.delCliente(con, sc.nextInt());
			break;
			
		} case "6": {
			System.out.println("Insira o id da ordem de serviso a ser deletada\nid: ");
			recepcionista.delOrdemDeServico(con, sc.nextInt());
			break;
		}
		
			
		}

		System.out.println("Deseja continuar? [S / N]");
		String continuar = sc.nextLine();
		switch (continuar) {
		case "S": {
			telaRecepcionista(recepcionista, con);
			break;
		} case "N": {
			System.out.println("Programa encerado!");
			break;
		}
		default:
			System.out.println("Opção inválida, o programa será enserrado...");
			break;
		}
	
	}

	//Tela do mecanico
	public void telaMecanico(Mecanico mecanico, ConexaoSQlite con) {
		System.out.println("[ 1 ] Ver ordens de serviso");
		System.out.println("[ 2 ] Ver meus orçamentos");
		System.out.println("[ 3 ] Adicionar orçamento");

		String resposta = sc.nextLine();
		
		switch (resposta) {
		case "1": {
			mecanico.getOrdensDeServiso(con);
			break;
			
		} case "2": {
			mecanico.getMeusOrcamentos(con);
			break;
			
		} case "3": {
			System.out.println("=== Insira os dados ===");
			System.out.println("Placa_cliente: ");
			String placa_cliente = sc.nextLine();
			System.out.println("Problema: ");
			String problema = sc.nextLine();
			System.out.println("Número da ordem de serviço: ");
			String idOrdem = sc.nextLine();
			System.out.println("Valor: ");
			String valor = sc.nextLine();
			System.out.println("Serviço: ");
			String serviso = sc.nextLine();
			Orcamento orcamento = new Orcamento(placa_cliente, problema, mecanico.CPF, valor, serviso);
			
			mecanico.addOrcamento(con, orcamento, idOrdem);
			
		}
		
			
		}

		System.out.println("Deseja continuar? [S / N]");
		String continuar = sc.nextLine();
		switch (continuar) {
		case "S": {
			telaMecanico(mecanico, con);
			break;
		} case "N": {
			System.out.println("Programa encerado!");
			break;
		}
		default:
			System.out.println("Opção inválida, o programa será enserrado...");
			break;
		}
	
	}
}




