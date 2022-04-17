package Classes_principais;

public class Cliente extends Pessoa{
	String email;
	String telefone;
    String endereco;
    String placa;

    //Construtor
    public Cliente(String nome, String CPF, String email,
    			   String telefone, String endereco, String placa) {
	        super(nome, CPF);
	        this.email = email;
	        this.telefone = telefone;
	        this.endereco = endereco;
	        this.placa = placa;
	    }
}
