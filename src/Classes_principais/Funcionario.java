package Classes_principais;

public class Funcionario extends Pessoa{
	String senha;
	String cargo;

    public Funcionario(String nome, String CPF, String senha, String cargo) {
        super(CPF, nome);
        this.senha = senha;
        this.cargo = cargo;
    }
}
