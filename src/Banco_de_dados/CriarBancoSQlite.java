package Banco_de_dados;

import java.sql.SQLException;
import java.sql.Statement;

import Banco_de_dados.ConexaoSQlite;

public class CriarBancoSQlite {
	
	private ConexaoSQlite conexaoSQlite;
	
	public CriarBancoSQlite(ConexaoSQlite pConexaoSQlite) {
		this.conexaoSQlite = pConexaoSQlite;
	}
		

	public void criarTabelaPessoa() {
		String sql = "CREATE TABLE IF NOT EXISTS tbl_pessoa(id int PRIMARY KEY, nome text NOT NULL, idade int)";
		
		boolean conectou = false;
		
		try {
			conectou = this.conexaoSQlite.conectar();
			Statement stmt = this.conexaoSQlite.criarStatement();
			stmt.execute(sql);
			System.out.println("Tabela criada");
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if(conectou) {
				this.conexaoSQlite.desconectar();
			}
		}
	}
	
}

