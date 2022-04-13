package PrincipalClass;

public class Main {

	public static void main(String[] args) {
		pessoa pessoa = new pessoa("064863853", "Kaique");
	    cliente cliente = new cliente("ksaijef", 847284834, "floamenf", "3835hss", pessoa.CPF, pessoa.Nome);
	    System.out.println(cliente.CPF);

	}

}
