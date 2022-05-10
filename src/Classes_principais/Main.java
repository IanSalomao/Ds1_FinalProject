package Classes_principais;

import java.util.Scanner;
import Banco_de_dados.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		ConexaoSQlite con = new ConexaoSQlite();
		Scanner sc = new Scanner(System.in);
		con.conectar();
		
		Telas tela = new Telas();
		System.out.println("\n#======== TELA DE LOGIN ========#");
		System.out.print("Nome: ");
		String login_nome = sc.nextLine();
		System.out.print("Senha: ");
		String login_senha = sc.nextLine();
		
		String login = tela.telaDeLogin(con, login_nome, login_senha);
		System.out.println("\nSeja bem vindo "+login_nome);
		
		switch (login) {
		case "Gerente": {
			Gerente gerente = new Gerente(null,null,null,null);
			tela.telaGerente(gerente, con);
			break;
			
		} case "Recepcionista": {
			Recepcionista recepcionista = new Recepcionista(null,null,null,null);
			tela.telaRecepcionista(recepcionista, con);
			break;
		
		} case "Mecanico": {
			ResultSet resultSet = null;
			Statement statement = null;
			String sqlLoginMecanico = "SELECT nome,cpf,senha FROM funcionarios WHERE nome = '"+login_nome+"' AND senha = '"+login_senha+"'";
			
			try {
				statement = con.criarStatement();
				resultSet = statement.executeQuery(sqlLoginMecanico);
				Mecanico mecanico = new Mecanico(resultSet.getString("nome"),resultSet.getString("cpf"),resultSet.getString("senha"),null);
				tela.telaMecanico(mecanico, con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		break;
		
		} default:
			System.out.println("Não deu cara :( ");
		}
		
		
		
		con.desconectar();
	}
					
}
