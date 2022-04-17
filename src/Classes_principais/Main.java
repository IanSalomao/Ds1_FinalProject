package Classes_principais;

import java.sql.*;
import java.util.Scanner;

import Banco_de_dados.*;

public class Main {

	public static void main(String[] args) {
		ConexaoSQlite con = new ConexaoSQlite();
		Scanner sc = new Scanner(System.in);
		con.conectar();
		
		Cliente cliente = new Cliente("kaique","0231231212","oiauoi@gmail.com","7566273655","casa da egual","ABC9A12");
		
		Recepcionista recepcionista = new Recepcionista("Nailson", "12312312312", "09876", null);
	
		Telas tela = new Telas();
		String login = tela.telaDeLogin(con);
		System.err.println(login);
		con.desconectar();
	}
					
}
